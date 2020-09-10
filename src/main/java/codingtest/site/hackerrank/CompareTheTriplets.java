package codingtest.site.hackerrank;

import java.util.Scanner;

public class CompareTheTriplets
{
	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);
		int a[] = new int[3];
		int b[] = new int[3];
		for (int i = 0 ; i < 3 ; i++)
			a[i] = in.nextInt();
		for (int i = 0 ; i < 3 ; i++)
			b[i] = in.nextInt();
		
		int result[] = solve(a, b);
		System.out.println(result[0] + " " + result[1]);
	}
	
	public static int[] solve(int a[], int b[])
	{
		int aPoint = 0;
		int bPoint = 0;
		for (int i = 0 ; i < 3 ; i++)
		{
			if (a[i] > b[i])
				aPoint++;
			else if (b[i] > a[i])
				bPoint++;
		}
		return new int[] {aPoint,bPoint};
	}
}
