package codingtest.site.codingInterview.sort.Q10_09;

public class Question
{
	
	public static void main(String [] args)
	{
		int matrix[][] = new int [][] { {1,2,3,4} , {5,6,7,8} , {9,10,11,12} };
		solve(matrix, 1);
		solve(matrix, 2);
		solve(matrix, 3);
		solve(matrix, 4);
		solve(matrix, 5);
		solve(matrix, 6);
		solve(matrix, 7);
		solve(matrix, 8);
		solve(matrix, 9);
		solve(matrix, 10);
		solve(matrix, 11);
		solve(matrix, 12);
		solve(matrix, 13);
	}
	
	public static void solve(int matrix[][], int k)
	{
		/**
		 * 	1. 이진 탐색으로 풀기.
		 * 	2. 1차원 --> 2차원 좌표 변환
		 * 	3. 나머진 이진 탐색과 동일하게
		 */
		int m = matrix.length;
		int n = matrix[0].length;
		binarySearch(matrix, k, 0, m * n - 1, m, n);
	}
	
	public static void binarySearch(int matrix[][], int k, int first, int last, int m, int n)
	{
		/** 기저 사례 */
		int mid = (first + last) / 2;
		int i = mid / n;
		int j = mid % n;

		if (first == last && matrix[i][j] != k) 
		{
			System.out.println("There no numbers to look for.");
			return ;
		}
		
		if (matrix[i][j] == k) 
		{
			System.out.println("(row,col) : " + "(" + i + "," + j + ")");
			return ;
		}
		else if (k < matrix[i][j])
		{
			binarySearch(matrix, k, first, mid, m, n);
		}
		else if (k > matrix[i][j])
		{
			binarySearch(matrix, k, mid + 1, last, m, n);
		}
	}
}