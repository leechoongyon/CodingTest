package codingtest.site.hackerrank;

import java.util.Scanner;

/**
 * @author lee
 *

Feedback
1. 처음에 문제 잘못읽음.. 대각선이 되는 것 파악 못함.
2. 이건 Cache 를 적용할 수 없는 이유가 한 번 들른데를 또 들리기 때문
3. DFS 의 개념으로 풀면 들린데를 체크해서 하나 하나씩 카운트 하면 심플한 답이 나옴.
4. 이 문제를 풀 때 개념은 DFS 로 끝까지 탐색하고 최대 값을 찾는다는 개념
 * 
 * 
 * 
 */
public class ConnectedCellInAGrid
{
	private static boolean visited[][];

	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int grid[][] = new int[n][m];
		visited = new boolean[n][m];
		for (int x = 0; x < n; x++)
		{
			for (int y = 0; y < m; y++)
			{
				grid[x][y] = in.nextInt();
			}
		}
		System.out.println(DFS(grid));
	}

	public static int DFS(int grid[][])
	{
		int n = grid.length;
		int m = grid[0].length;
		int result = 0;
		for (int x = 0; x < n; x++)
		{
			for (int y = 0; y < m; y++)
			{
				if (grid[x][y] == 1)
					result = Math.max(result, DFS(grid, x, y));
			}
		}
		return result;
	}

	public static int DFS(int grid[][], int x, int y)
	{
		int result = 1;
		visited[x][y] = true;

		int n = grid.length;
		int m = grid[0].length;

		// x + 1, y
		if (x + 1 < n && grid[x + 1][y] == 1 && visited[x + 1][y] == false)
		{
			visited[x + 1][y] = true;
			result = Math.max(result, 1 + DFS(grid, x + 1, y));
			visited[x + 1][y] = false;
		}

		// x - 1, y
		if (0 <= x - 1 && grid[x - 1][y] == 1 && visited[x - 1][y] == false)
		{
			visited[x - 1][y] = true;
			result = Math.max(result, 1 + DFS(grid, x - 1, y));
			visited[x - 1][y] = false;
		}

		// x, y + 1
		if (y + 1 < m && grid[x][y + 1] == 1 && visited[x][y + 1] == false)
		{
			visited[x][y + 1] = true;
			result = Math.max(result, 1 + DFS(grid, x, y + 1));
			visited[x][y + 1] = false;
		}

		// x, y - 1
		if (0 <= y - 1 && grid[x][y - 1] == 1 && visited[x][y - 1] == false)
		{
			visited[x][y - 1] = true;
			result = Math.max(result, 1 + DFS(grid, x, y - 1));
			visited[x][y - 1] = false;
		}

		// x + 1, y + 1
		if (x + 1 < n && y + 1 < m && grid[x + 1][y + 1] == 1 && visited[x + 1][y + 1] == false)
		{
			visited[x + 1][y + 1] = true;
			result = Math.max(result, 1 + DFS(grid, x + 1, y + 1));
			visited[x + 1][y + 1] = false;
		}

		// x - 1, y - 1
		if (0 <= x - 1 && 0 <= y - 1 && grid[x - 1][y - 1] == 1 && visited[x - 1][y - 1] == false)
		{
			visited[x - 1][y - 1] = true;
			result = Math.max(result, 1 + DFS(grid, x - 1, y - 1));
			visited[x - 1][y - 1] = false;
		}

		// x-1, y + 1
		if (0 <= x - 1 && y + 1 < m && grid[x - 1][y + 1] == 1 && visited[x - 1][y + 1] == false)
		{
			visited[x - 1][y + 1] = true;
			result = Math.max(result, 1 + DFS(grid, x - 1, y + 1));
			visited[x - 1][y + 1] = false;
		}

		// x + 1, y - 1
		if (x + 1 < n && 0 <= y - 1 && grid[x + 1][y - 1] == 1 && visited[x + 1][y - 1] == false)
		{
			visited[x + 1][y - 1] = true;
			result = Math.max(result, 1 + DFS(grid, x + 1, y - 1));
			visited[x + 1][y - 1] = false;
		}

		return result;
	}
}
