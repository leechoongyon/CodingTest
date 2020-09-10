package codingtest.site.util;

import java.util.List;

public class MathUtil {

	public static void main(String[] args) {
		
/*		int pickedSize = 2;
		int range = 3;
		List<Integer> picked = new ArrayList<Integer>();
		List<T> storage = new ArrayList<Integer>();
		duplicateCombination(picked, pickedSize, range, storage);
		
		for (int i = 0 ; i < storage.size() ; i++) {
			System.out.println(storage.get(i));
			
		}*/
		
		
	}
	
	public static String convertNumber(int num, int divideNum) {

		if(num < divideNum)
			return convertNumberToAlphabet(num);
		int quotient = 0;
		int remainder = 0;

		quotient = num / divideNum;
		remainder = num % divideNum;

		return convertNumber(quotient, divideNum) + convertNumberToAlphabet(remainder);
	}

	public static String convertNumberToAlphabet(int remainder) {
		switch(remainder) {
		case 10:
			return "A";
		case 11:
			return "B";
		case 12:
			return "C";
		case 13:
			return "D";
		case 14:
			return "E";
		case 15:
			return "F";
		case 16:
			return "G";
		default : 
			return String.valueOf(remainder);
		}
	}

	
	/*
	 * # 설명
	 * 
	 * 
	 * # 사용법
	 * List<Integer> picked = new ArrayList<Integer>();
	 * int n = 3;
	 * boolean isPick[] = new boolean[n];
	 * permutation(picked, isPick, n);
	 */
	
	public static void permutation(List<Integer> picked, boolean isPick[], int n)
	{
		if(picked.size() == n)
		{
			System.out.println(picked);
			return;
		}

		for(int next = 0 ; next < n ; next++)
		{
			if(isPick[next])
				continue;
			picked.add(next);
			isPick[next]  = true;

			// picked가 new ArrayList<Integer>(picked)로 되있는데 
			// 이건 좀 이상한듯
			permutation(picked, isPick, n);		

			picked.remove(picked.size() - 1);
			isPick[next] = false;
		}
	}

	/*
	 * desc
	 * 
	 * 중복 순열
	 * 크기 n에서 범위 n만큼 추출
	 */
	
	public static void duplicatePermutation(List<Integer> picked, int n)
	{
		if(picked.size() == n)
		{
			System.out.println(picked);
			return ;
		}

		for(int next = 0 ; next < n ; next++)
		{
			picked.add(next);
			duplicatePermutation(picked, n);
			picked.remove(picked.size() -1);
		}
	}
	
	/*
	 * 중복 조합
	 * 
	 *  picked : 선택된 숫자를 담는 
	 *  pickedSize : 뽑을 크기
	 *  range : 뽑을 범위
	 *  storage : 각 조합을 저장할 저장소
	 */
	
	public static <T> void duplicateCombination(List<Integer> picked, int pickedSize, int range, List<T> storage)
	{
		if(picked.size() == pickedSize)
		{
			System.out.println(picked);
			return ;
		}

		for(int next = 0 ; next < range ; next++)
		{
			picked.add(next);
			duplicateCombination(picked, pickedSize, range, storage);
			picked.remove(picked.size() -1);
		}
	}
	
	
}
