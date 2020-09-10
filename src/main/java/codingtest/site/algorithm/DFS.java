package codingtest.site.algorithm;

import java.util.Scanner;

/**
 * 
 * @author lee

6
1 2
2 3
2 4
2 5
3 1
5 4

 */
public class DFS
{
	private static boolean visited[];
	private static int arr[][];
	
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		
		arr = new int[n + 1][n + 1];
		visited = new boolean[n+1];
		for (int i = 0 ; i < n ; i++)
		{
			int l = scan.nextInt();
			int r = scan.nextInt();
			
			arr[l][r] = arr[r][l] = 1;
		}
		dfs(1);
	}
	
	private static void dfs(int start)
	{
		visited[start] = true;
		
		for (int i = 1 ; i < arr.length ; i++)
		{
			if (visited[i] == false && arr[start][i] == 1)
			{
				visited[i] = true;
				System.out.println(start + " --> " + i);
				dfs(i);
			}
		}
	}
}
