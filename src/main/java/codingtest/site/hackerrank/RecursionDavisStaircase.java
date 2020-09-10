package codingtest.site.hackerrank;

import java.util.Scanner;

/**
 * @author lee
 *
 *	계단을 오르는 방법의 개수
 */
public class RecursionDavisStaircase
{
	private static int cache[];
	
	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int testcase = 0; testcase < t; testcase++)
		{
			int n = in.nextInt();
			cache = new int[n + 1];
			System.out.println(solve(n));
		}
		in.close();
	}
	
	public static int solve(int n)
	{
		/**
		 * n = 3 구함
		 * 
		 * i = 1 일 때, solve(2) 의 계단 오르는 개수
		 * 	solve(2) 을 구하고자 할 때
		 * 		i = 1 이면 solve(1) 는 몇 개인가? 1개
		 * 		i = 2 이면 solve(0) 는 몇 개 인가? 1개
		 * 		i = 3 이면 solve(-1) X
		 * i = 2 일 때, solve(1) 의 계단 오르는 개수
		 * 	solve(1) 을 구하고자 할 때, 1개
		 * i = 3 일 때, 1개
		 */
		
		if (cache[n] != 0) return cache[n];
		if (n == 0 || n == 1) return 1;
		
		for (int i = 1 ; i <= 3 ; i++)
		{
			if (n - i < 0) break;
			cache[n] += solve(n-i);
		}
		return cache[n];
	}
}
