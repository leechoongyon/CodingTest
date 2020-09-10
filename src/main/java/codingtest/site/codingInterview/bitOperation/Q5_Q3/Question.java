package codingtest.site.codingInterview.bitOperation.Q5_Q3;

import java.util.ArrayList;
import java.util.List;

public class Question
{
	public static void main(String[] args)
	{

		int n = 12345;
		System.out.println("BinaryString : " + Integer.toBinaryString(n));
		/** 
		 * 	1. 0과 1이 반복돼는걸 배열로 표현.
		 * 	2. 배열을 순회하면서 가장 긴 길이를 반환
		 * 		2.1 앞에 0은 스킵하고, 101을 순회. 
		 * 		2.2 0 이 1이면 101 에서 101 을 이어 붙임.
		 * 		2.3 다음번에도 101 을 비교. 2.1, 2.2 반복
		 * */
		List<Integer> list = createArray(n);
		System.out.println(list);
		System.out.println(findLongestLength(list));
	}

	public static List<Integer> createArray(int n)
	{
		List<Integer> list = new ArrayList<Integer>();
		int zeroCount = 0;
		int oneCount = 0;
		int searchingFor = 0;
		for (int i = 0 ; i <= Integer.BYTES * 8 ; i++)
		{
			/** 0 인지, 1인지 확인 */
			if (searchingFor == 0 && !getBit(n, 0))
			{
				zeroCount++;
			}
			else if (searchingFor == 0 && getBit(n, 0))
			{
				searchingFor = 1;
				oneCount++;
				list.add(zeroCount);
				zeroCount = 0;
			}
			else if (searchingFor == 1 && getBit(n, 0))
			{
				oneCount++;
			}
			else if (searchingFor == 1 && !getBit(n, 0))
			{
				searchingFor = 0;
				zeroCount++;
				list.add(oneCount);
				oneCount = 0;
			}
			else
			{
				System.out.println("else");
			}
			n = n >>> 1;
		}
		if (zeroCount != 0)	list.add(zeroCount);
		if (oneCount != 0) list.add(oneCount);
		
		return list;
	}
	
	public static boolean getBit(int n, int i)
	{
		return ((n & (1 << i)) != 0);
	}

	/**
	 * 2. 배열을 순회하면서 가장 긴 길이를 반환
	 * 	2.1	101 을 비교.
	 * 	2.2 i - 1, i + 1 을 validate 하는지 체크. (oneLeft, oneRight)
	 * 	2.3 zeroSeq = 1 일 경우 이어 붙임.
	 * 	2.4 zeroSeq > 1 일 경우 둘 중 하나를 고른 뒤 +1 함.
	 * 	2.5 zeroSeq == 0 일 경우는 처음에 0으로 시작안하는 경우겠지.
	 * 		- right 와 left 만 비교하면 됨.
	 */
	
	public static int findLongestLength(List<Integer> list)
	{
		int max = 0;
		for (int i = 0 ; i < list.size() ; i+=2)
		{
			int zeroSeq = list.get(i);
			int onesRight = i - 1 >= 0 ? list.get(i-1) : 0;
			int onesLeft = i + 1 < list.size() ? list.get(i + 1) : 0;
			
			int cur = 0;
			if (zeroSeq == 1)
			{
				cur = onesLeft + 1 + onesRight;
			}
			else if (zeroSeq > 1)
			{
				cur = 1 + Math.max(onesLeft, onesRight);
			}
			else if (zeroSeq == 0)
			{
				cur = Math.max(onesLeft, onesRight);
			}
			max = Math.max(cur, max);
		}
		return max;
	}
}
