package codingtest.site.hackerrank;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author lee
 *
 * @desc 
 * 	1. 가로, 세로, 대각선 합이 같은 정사각형을 찾는다.
 * 	2. 1번 조건을 만족하기 위해 숫자를 교체할 수 있으며, 최소의 Cost를 사용하여 정사각형을 찾는다.
 * 		ex) 1을 2로 교체하면 |1-2| = 1 임.
 * 	3. 중복되는 숫자는 없음. 
 */

public class FormingAMagicSquare
{
	private static int answer[][] = 
	{
		{2,9,4,7,5,3,6,1,8},
		{4,3,8,9,5,1,2,7,6},
		{4,9,2,3,5,7,8,1,6},
	    {8,3,4,1,5,9,6,7,2},
	    {8,1,6,3,5,7,4,9,2},
		{2,7,6,9,5,1,4,3,8},
		{6,1,8,7,5,3,2,9,4},
		{6,7,2,1,5,9,8,3,4},
	};
			
	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);
		int square[][] = new int[3][3];
		for (int i = 0 ; i < 3 ; i++)
		{
			for (int j = 0 ; j < 3 ; j++)
			{
				square[i][j] = in.nextInt();
			}
		}
		int result = solve(square);
		System.out.println(result);
	}
	
	public static int solve(int square[][])
	{
		int cost[] = new int[8];
		for (int i = 0 ; i < 8 ; i++)
		{
			cost[i] += Math.abs(answer[i][0] - square[0][0]) + Math.abs(answer[i][1] - square[0][1]) + Math.abs(answer[i][2] - square[0][2]);
			cost[i] += Math.abs(answer[i][3] - square[1][0]) + Math.abs(answer[i][4] - square[1][1]) + Math.abs(answer[i][5] - square[1][2]);
			cost[i] += Math.abs(answer[i][6] - square[2][0]) + Math.abs(answer[i][7] - square[2][1]) + Math.abs(answer[i][8] - square[2][2]);
		}
		Arrays.sort(cost);
		return cost[0];
	}
	
	public static void printSquare(int square[][])
	{
		for (int i = 0 ; i < 3 ; i++)
		{
			for (int j = 0 ; j < 3 ; j++)
			{
				System.out.print(square[i][j] + " ");
			}
			System.out.println();
		}
	}
}
