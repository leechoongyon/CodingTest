package codingtest.site.codingInterview.arrayAndString;

import java.util.Scanner;


/**
 * 
 * @author lee

4
1 2 3 4
5 6 7 8
9 10 11 12
13 14 15 16
 
5
1 2 3 4 5
6 7 8 9 10
11 12 13 14 15
16 17 18 19 20
21 22 23 24 25

6
1 2 3 4 5 6
7 8 9 10 11 12
13 14 15 16 17 18
19 20 21 22 23 24
25 26 27 28 29 30
31 32 33 34 35 36


 */


public class Problem1g
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		
		int arr[][] = new int[n][n];
		for (int i = 0 ; i < n ; i++)
		{
			for (int j = 0 ; j < n ; j++)
			{
				arr[i][j] = scan.nextInt();
			}
		}
		solve1(arr);
	}
	
	private static void solve(int arr[][])
	{
		if (arr.length == 0 || arr.length != arr[0].length)
		{
			System.out.println("???");
			return ;
		}
		int n = arr.length;
		for (int layer = 0 ; layer < n / 2 ; layer++)
		{
			int first = layer;
			int last = n - 1 - layer;
			for (int i = first ; i < last ; i++)
			{
				int offset = i - first;
				int top = arr[first][i];
				
//				System.out.println("arr[" + first + "][" + i + "] = arr[" + (last-offset) + "][" + first + "]");
				arr[first][i] = arr[last-offset][first];
				
//				System.out.println("arr[" + (last-offset) + "][" + first + "] = arr[" + (last) + "][" + (last-offset) + "]");
				arr[last-offset][first] = arr[last][last-offset];
				
//				System.out.println("arr[" + last + "][" + (last-offset) + "] = arr[" + (i) + "][" + last + "]");
				arr[last][last-offset] = arr[i][last];
				
//				System.out.println("arr[" + i + "][" + last + "] = top");
				arr[i][last] = top;
			}
		}
		print(arr);
	}
	
	private static void solve1(int matrix[][])
	{
		if (matrix.length == 0 || matrix.length != matrix[0].length)
		{
			System.out.println("???");
			return ;
		}
		
		int n = matrix.length;
		
		for (int layer = 0 ; layer < n / 2 ; layer++)
		{
			int first = layer;
			int last = n - 1 - layer;
			
			for (int i = first ; i < last ; i++)
			{
				int offset = i - first;
				int top = matrix[first][i];
				
				// left --> top
				matrix[first][i] = matrix[last-offset][first];
				
				// bottom --> left
				matrix[last-offset][first] = matrix[last][last-offset];
				
				// right --> bottom
				matrix[last][last-offset] = matrix[first+offset][last];
				
				// top --> right
				matrix[first+offset][last] = top;
			}
		}
		print(matrix);
	}
	
	private static void print(int arr[][])
	{
		for (int i = 0 ; i < arr.length ; i++)
		{
			for (int j = 0 ; j < arr.length ; j++)
			{
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}
