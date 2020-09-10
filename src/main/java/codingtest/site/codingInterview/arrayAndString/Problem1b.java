package codingtest.site.codingInterview.arrayAndString;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Problem1b
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		String a1 = scan.next();
		String a2 = scan.next();
		
//		solveIfASCII(a1, a2);
		solveIfUnicode(a1, a2);
	}
	
	/**
	 *  ASCII 일 경우
	 *  sol1. 
	 *  - int 배열을 127 개를 만들어.
	 *  - 문자가 각 인덱스에 들어갈 때마다 +1 시킴.
	 *  - a1 집어넣음.
	 *  - a2 는 집어넣을 때마다 -1 시킴.
	 *  - 이 때, -1 시켰는데 0보다 작다면 순열 관계 아님.
	 *  - 시간복잡도 O(2n) , 공간 O(1) 
	 * 
	 *  Unicode 일 경우
	 *  sol1. 문자열 정렬한 뒤, 같은지 비교
	 *  - n * logn * 2
	 *  
	 *  sol2. HashMap<Character, Integer> 위와 동일하게 함.
	 *  - 시간 O(2n) , 공간 O(n) 
	 */
	private static void solveIfASCII(String a1, String a2)
	{
		if (a1.length() != a2.length())
		{
			System.out.println("permutation x");
			return ;
		}
		
		int arr[] = new int[127];
		
		for (char c : a1.toCharArray())
			arr[(int) c]++;
		for (char c : a2.toCharArray())
		{
			arr[(int) c]--;
			if (arr[(int) c] < 0)
			{
				System.out.println("permutation x");
				return ;
			}
		}
	}
	
	private static void solveIfUnicode(String a1, String a2)
	{
		if (a1.length() != a2.length())
		{
			System.out.println("permutation x");
			return ;
		}
		
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (char c : a1.toCharArray())
		{
			if (map.containsKey(c))
				map.put(c, map.get(c) + 1);
			else
				map.put(c, 1);
		}
		
		for (char c : a2.toCharArray())
		{
			if (map.get(c) == null || map.get(c) - 1 < 0)
			{
				System.out.println("permutation x");
				return ;
			}
			map.put(c, map.get(c) - 1);
		}
		System.out.println("permutation");
	}
}
