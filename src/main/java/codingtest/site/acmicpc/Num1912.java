package codingtest.site.acmicpc;

import java.util.Scanner;

public class Num1912
{
	private static int[] num;
	private static int[] cache;
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		num = new int[n];
		cache = new int[n];
		for (int i = 0 ; i < n ; i++)
		{
			num[i] = scan.nextInt();
		}
		
		System.out.println(solve());
	}
	
	public static int solve()
	{
		/**
		 * 	Sol1. brute-force
		 * 	1. O(n 제곱)
		 * 
		 *  Sol2. memorization 
		 */
		int max = Integer.MIN_VALUE;
		for (int i = num.length - 1 ; i >= 0 ; i--)
		{
			max = Math.max(max, solve(i));
		}
		return max;
	}
	
	public static int solve(int start)
	{
		int max = Integer.MIN_VALUE;
		int sum = 0;
		for (int i = start ; i < num.length ; i++)
		{
			if (cache[i] != 0)
			{
				sum += cache[i];
				max = Math.max(max, sum);
				break;
			}
			else
			{
				sum += num[i];
				max = Math.max(max, sum);
			}
		}
		return cache[start] = max;
	}
	
}
