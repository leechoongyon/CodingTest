package codingtest.site.hackerrank;

import java.util.Scanner;

public class SimpleArraySum
{
	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int arr[] = new int[n];
		for (int i = 0 ; i < n ; i++)
		{
			arr[i] = in.nextInt();
		}
		int result = solve(arr);
		System.out.println(result);
	}
	
	public static int solve(int arr[])
	{
		int sum = 0;
		for (int num : arr)
		{
			sum += num;
		}
		return sum;
	}
}
