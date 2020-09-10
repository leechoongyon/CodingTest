package codingtest.site.acmicpc;

import java.util.Scanner;

/**
 * @author lee
 *
 */

public class Num1003UsingCache
{
	private static int cache[][] = new int[41][2];
	public static void main(String [] args)
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int n = 0;
		for (int i = 0 ; i < T ; i++)
		{
			n = sc.nextInt();
			fibonacci(n);
			print(n);
		}
	}
	
	public static void print(int n)
	{
		System.out.println(cache[n][0] + " " + cache[n][1]);
	}
	
	public static int[] fibonacci(int n)
	{
		int result[];
		if (cache[n][0] != 0 || cache[n][1] != 0)
		{
			return cache[n];
		}
		
		if (n == 0)
		{
			cache[n][0] += 1;
			return cache[n];
		}
		else if (n == 1)
		{
			cache[n][1] += 1;
			return cache[n];
		}
		else 
		{
			result = fibonacci(n-1);
			cache[n][0] += result[0]; cache[n][1] += result[1];
			result = fibonacci(n-2);
			cache[n][0] += result[0]; cache[n][1] += result[1];
			return cache[n];
		}
	}
}
