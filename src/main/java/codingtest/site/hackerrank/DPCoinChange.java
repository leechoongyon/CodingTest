package codingtest.site.hackerrank;

import java.util.Scanner;

/**
 * @author lee
 *	
 * @desc
 * 	1. 달러를 동전으로 바꾸는 방법을 구하라. (순서 X)
 * 	
 */

public class DPCoinChange
{
	private static long cache[][];
	
	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		cache = new long[n + 1][m + 1];
		int coins[] = new int[m];
		for (int i = 0 ; i < m ; i++)
			coins[i] = in.nextInt();
		
		System.out.println(solve(n, 0, coins));
		
		in.close();
	}
	/**
	 * 
	 * @param startIdx
	 * @param n
	 * @param coins
	 * @return
	 * @desc
	 * 
	 *  cache[n=4][startIdx=0]
	 *  i = 0
	 *  cache[n=4][startIdx=0] = cache[n=4][startIdx=0] + solve(3, 0)
	 *  solve(3, 0) = cache[n=3][startIdx=0] += cache[n=3][startIdx=0] + solve(2, 0)
	 *   									 += cache[n=3][startIdx=0] + solve(1, 1)
	 *   									 += cache[n=3][startIdx=0] + solve(0, 2) -- 1
	 *  solve(2, 0) = cache[n=2][startIdx=0] += cache[n=2][startIdx=0] + solve(1, 0)
	 *  									 += cache[n=2][startIdx=0] + solve(0, 1) -- 1
	 *  									 += cache[n=2][startIdx=0] + solve(-1, 2)
	 *  solve(1, 1) = cache[n=1][startIdx=1] += cache[n=1][startIdx=1] + solve(0, 0) -- 1
	 *  									 += cache[n=1][startIdx=1] + solve(-1, 1)
	 *  									 += cache[n=1][startIdx=1] + solve(-2, 2) 	
	 *  i = 1
	 *  cache[n=4][startIdx=0] = cache[n=4][startIdx=0] + solve(2, 1)
	 *  solve(2,1) = cache[n=2][startIdx=1] += cache[n=2][startIdx=1] + solve(1, 0)
	 *  									+= cache[n=2][startIdx=1] + solve(0, 1) -- 1  
	 *  									+= cache[n=2][startIdx=1] + solve(-1, 2)
	 *  
	 *  i = 2
	 *  cache[n=4][startIdx=0] = cache[n=4][startIdx=0] + solve(1, 2)
	 *  solve(1,2) = cache[n=1][startIdx=2] += cache[n=1][startIdx=2] + solve(0, 0) -- 1 (startIdx 가 넘어섰기에 X)
	 *  									+= cache[n=1][startIdx=2] + solve(-1, 1)
	 *  									+= cache[n=1][startIdx=2] + solve(-2, 2)
	 */
	public static long solve(int n, int startIdx, int coins[])
	{
		System.out.println("n : "+ n + "\t startIdx : " + startIdx);
		if (n == 0) return 1;
		if (n < 0) return 0;
		if (cache[n][startIdx] != 0) return cache[n][startIdx];
		for (int i = startIdx ; i < coins.length ; i++)
		{
			cache[n][startIdx] += solve(n - coins[i], i, coins);
		}
		System.out.println("cache[" + n + "][" + startIdx + "] : " + cache[n][startIdx]);
		return cache[n][startIdx];
	}
}
