package codingtest.site.hackerrank;

import java.util.Scanner;

/**
 * @author lee
 *
 * 	1. 이미 주어진 LeaderBoard 에서 Alice 가 획득한 점수의 Ranking 은 어떻게 되는지?
 * 	2. scores 는 단조 감소
 * 	3. 

7
100 100 50 40 40 20 10
4
5 25 50 120

 */
public class ClimbingTheLeaderboard
{
	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int score[] = new int[n]; 
		for (int i = 0 ; i < n ; i++)
			score[i] = in.nextInt();
		int m = in.nextInt();
		int aliceScore[] = new int[m];
		for (int j = 0 ; j < m ; j++)
			aliceScore[j] = in.nextInt();
		
		int result[] = solve(score, aliceScore);
		
		for (int k = 0 ; k < result.length ; k++)
			System.out.println(result[k]);
	}
	
	public static int[] solve(int score[], int aliceScore[])
	{
		int result[] = new int[aliceScore.length];
		
		// 1. 순위 매기기 (시간복잡도 O(n)
		int rank[] = new int[score.length];
		rank[0] = 1;
		int rankNum = 1;
		for (int i = 1 ; i < score.length ; i++)
		{
			if (score[i-1] == score[i])
				rank[i] = rankNum;
			else 
			{
				rankNum++;
				rank[i] = rankNum;
			}
		}

		/**
		 * 	2. 이진검색
		 * 		- 찾아서 값이 일치하면 해당 Rank 리턴
		 * 		- 찾아서 값이 없으면 앞 뒤로 비교한 뒤, 해당 Rank 리턴
		 */
		for (int i = 0 ; i < aliceScore.length ; i++)
		{
			result[i] = binarySearch(score, rank, aliceScore[i], 0, score.length - 1);
		}
		return result;
	}
	
	public static int binarySearch(int score[], int rank[], int key, int min, int max) 
	{
		if (min >= max)
		{
			if (key < score[min])
			{
				return rank[min] + 1;
			}
			else if (key > score[min])
			{
				if (min == 0) return 1;
				return rank[min];
			}
			else
			{
				return rank[min];
			}
		}
		
		int mid = (min + max) / 2;

		if (key == score[mid])
			return rank[mid];
		else if (key > score[mid])
			return binarySearch(score, rank, key, min, mid - 1);
		else if (key < score[mid])
			return binarySearch(score, rank, key, mid + 1, max);
		else
			throw new IllegalStateException("IllegalState...");
	}
}
