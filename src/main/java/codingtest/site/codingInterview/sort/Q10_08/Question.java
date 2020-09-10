package codingtest.site.codingInterview.sort.Q10_08;

import java.util.BitSet;

public class Question
{
	/** 
	 * 	4KB --> 32000 bit 
	 * 	1 부터 N 까지의 (<= 32000) 숫자로 이루어진 배열이 있다고 가정.
	 * 	각각 bitSet 에 넣고 비트가 이미 켜져있으면 해당 값을 count	
	 * */
	public static void main(String [] args)
	{
		int arr[] = {1,2,3,4,5,6,6,6,6,6,7,8,9,10};
		printDuplicateNum(arr);
	}
	
	public static void printDuplicateNum(int arr[])
	{
		int count = 0;
		BitSet bit = new BitSet(32000);
		for (int i : arr)
		{
			if (bit.get(i))
				System.out.println(i);
			else
				bit.set(i);
		}
	}
}
