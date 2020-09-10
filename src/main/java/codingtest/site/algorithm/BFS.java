package codingtest.site.algorithm;

import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 
 * @author lee

6
1 2
2 3
2 4
2 5
1 4
5 4

 */

public class BFS
{
	private static boolean visited[];
	private static int arr[][];
	private static Queue<Integer> queue = new LinkedBlockingQueue<Integer>();
	
	
	public static void main(String[] args)
	{

		Scanner scan = new Scanner(System.in);

		int n = scan.nextInt();

		arr = new int[n + 1][n + 1];
		visited = new boolean[n + 1];
		for (int i = 0; i < n; i++)
		{
			int l = scan.nextInt();
			int r = scan.nextInt();

			arr[l][r] = arr[r][l] = 1;
		}
		bfs(1);
	}
	
	private static void bfs(int start)
	{
		visited[start] = true;
		queue.add(start);
		while (!queue.isEmpty())
		{
			int temp = queue.poll();
			System.out.println("visited : " + temp);
			for (int i = temp + 1 ; i < arr.length ; i++)
			{
				if (visited[i] == false && arr[temp][i] == 1)
				{
					visited[i] = true;
					queue.add(i);
				}
			}
		}
	}
}
