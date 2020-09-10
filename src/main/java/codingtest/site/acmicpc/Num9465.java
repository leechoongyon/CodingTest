package codingtest.site.acmicpc;

import java.util.Scanner;

/*

1
5
50 10 100 20 40
30 50 70 10 60

2
5
50 10 100 20 40
30 50 70 10 60
7
10 30 10 50 100 20 40
20 40 30 50 60 20 80

*/


// dp[0][N] : 0열에서 출발하여 (0, N) 위치까지의 score 의 합
// dp[1][N] : 0열에서 출발하여 (1, N) 위치까지의 score 의 합

/**
 * @author lee
 * 
 */
public class Num9465
{
	private static int dp[][]; 
	
	public static void main(String [] args)
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int n, score[][];
		for (int i = 0 ; i < T ; i++)
		{
			dp = new int[2][100000];
			n = sc.nextInt();
			score = new int[2][n];
			
			for (int index = 0 ; index < n ; index++)
				score[0][index] = sc.nextInt();
			for (int index = 0 ; index < n ; index++)
				score[1][index] = sc.nextInt();
			
			System.out.println(solve(score, n));
		}
	}
	
	public static int solve(int score[][], int n)
	{
		for (int i = 0 ; i < n ; i++)
		{
			dp[0][i] = Math.max(getDpValue(1, i-1), getDpValue(1, i-2)) + score[0][i];
			dp[1][i] = Math.max(getDpValue(0, i-1), getDpValue(0, i-2)) + score[1][i];
		}
		return Math.max(dp[0][n-1], dp[1][n-1]);
	}
	
	public static int getDpValue(int x, int y)
	{
		if (x < 0 || y < 0) return 0;
		
		return dp[x][y];
	}
}
