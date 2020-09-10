package codingtest.site.acmicpc;

import java.util.Scanner;

/**
 * @author lee
 *
 */

public class Num1003
{
	public static void main(String [] args)
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int n = 0;
		int res[][] = new int[T][2];
		for (int i = 0 ; i < T ; i++)
		{
			n = sc.nextInt();
			fibonacci(n, res[i]);
		}
		
		for (int i = 0 ; i < T ; i++)
		{
			System.out.println(res[i][0] + " " + res[i][1]);
		}
	}
	
	public static void fibonacci(int n, int res[])
	{
		if (n == 0) res[0] += 1;
		else if (n == 1) res[1] += 1;
		else
		{
			fibonacci(n-1, res);
			fibonacci(n-2, res);
		}
	}
}
