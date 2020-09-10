package codingtest.site.codingInterview.arrayAndString;

import java.util.Scanner;

/**

4 4
1 2 3 4
5 6 7 8
9 10 11 12
13 14 0 16
 
5 5
1 2 3 4 5
6 7 8 9 10
11 12 13 14 15
16 0 18 19 20
21 22 23 24 25

6 6
1 2 3 4 5 6
0 8 9 10 11 12
13 14 15 16 17 18
19 20 21 22 23 24
25 26 27 28 29 30
31 32 33 34 35 36

 * @author lee
 *
 */

public class Problem1h
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		int m = scan.nextInt();
		int n = scan.nextInt();
		
		int matrix[][] = new int[m][n];
		for (int i = 0 ; i < m ; i++)
			for (int j = 0 ; j < n ; j++)
				matrix[i][j] = scan.nextInt();
		
		solve(matrix);
		print(matrix);
	}
	
	private static void solve(int matrix[][])
	{
		int row = matrix.length;
		int col = matrix[0].length;
		
		for (int i = 0 ; i < row ; i++)
		{
			for (int j = 0 ; j < col ; j++)
			{
				if (matrix[i][j] == 0)
				{
					setZeros(matrix, i, j, row, col);
					return ;
				}
			}
		}
	}
	
	private static void setZeros(int matrix[][], int row, int col, int maxRow, int maxCol)
	{
		for (int rowIndex = 0 ; rowIndex < maxRow ; rowIndex++)
			matrix[rowIndex][col] = 0;
		for (int colIndex = 0 ; colIndex < maxCol ; colIndex++)
			matrix[row][colIndex] = 0;
	}
	
	private static void print(int matrix[][])
	{
		int row = matrix.length;
		int col = matrix[0].length;
		for (int r = 0 ; r < row ; r++)
		{
			for (int c = 0 ; c < col ; c++)
			{
				System.out.print(matrix[r][c] + " ");
			}
			System.out.println();
		}
	}
}
