package codingtest.site.acmicpc;

import java.util.Scanner;

/**
 * @author lee
 *
 *	문제 : -1로만 채워진 종이 개수, 0으로만 채워진 종이 개수, +1으로만 채워진 종이 개수를 
 *  구한다.
 */
public class Num1780
{
	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int board[][] = new int[N][N];
		for (int i = 0 ; i < N ; i++)
		{
			for (int j = 0 ; j < N ; j++)
			{
				board[i][j] = in.nextInt();
			}
		}
		int res[] = solve(board, 0, 0, N);
		for (int num : res)
		{
			System.out.println(num);
		}
	}
	
	/**
	 * @param board
	 * @return
	 * 
	 * @desc
	 * 	sol1 brute-force
	 * 	1. 같은지 확인. O(n제곱)
	 * 	2. 같지 않으면, 9개로 분할 (1/3n * 1/3n ... = O(n제곱)	
	 * 
	 * 	sol2 divide
	 * 	1. 나눈다. 크기가 1일 때까지 (log2N)
	 * 	2. 나눈 것을 합친다. (N)
	 */
	public static int[] solve(int board[][], int x, int y, int size)
	{
		// 기저사례
		if (x + size > board.length)
			return new int[] {0,0,0};
		if (y + size > board[0].length)
			return new int[] {0,0,0};
		
		int resize = size / 3;
		int res[] = new int[3];
		
		// compare
		int num = board[x][y];
		boolean isSame = true;
		for (int i = x ; i < x + size ; i++)
		{
			for (int j = y ; j < y + size ; j++)
			{
				if (num != board[i][j])
				{
					isSame = false;
				}
			}
			if ( !isSame) break;
		}
		if (isSame)
		{
			if (num == -1)
				return new int[] {1,0,0};
			else if(num == 0)
				return new int[] {0,1,0};
			else if(num == 1)
				return new int[] {0,0,1};
		}
		
		// divide
		int output1[] = solve(board, x, y, resize);
		int output2[] = solve(board, x, y + (resize * 1), resize);
		int output3[] = solve(board, x, y + (resize * 2) , resize);
		int output4[] = solve(board, x + resize, y, resize);
		int output5[] = solve(board, x + resize, y + (resize * 1), resize);
		int output6[] = solve(board, x + resize, y + (resize * 2), resize);
		int output7[] = solve(board, x + (resize * 2), y, resize);
		int output8[] = solve(board, x + (resize * 2), y + (resize * 1), resize);
		int output9[] = solve(board, x + (resize * 2), y + (resize * 2), resize);

		/**
		 * compare
		 * -1 , 0 , 1 인지 판별
		 */
		res[0] = output1[0] + output2[0] + output3[0] + output4[0] + output5[0] +
				 output6[0] + output7[0] + output8[0] + output9[0];
		res[1] = output1[1] + output2[1] + output3[1] + output4[1] + output5[1] +
				 output6[1] + output7[1] + output8[1] + output9[1];
		res[2] = output1[2] + output2[2] + output3[2] + output4[2] + output5[2] +
				 output6[2] + output7[2] + output8[2] + output9[2];
		return res;
	}
	public static void print(int board[][])
	{
		for (int i = 0 ; i < board.length ; i++)
		{
			for (int j = 0 ; j < board[i].length ; j++)
			{
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}
}
