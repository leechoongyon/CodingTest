package codingtest.site.codingInterview.recursiveAndDP.Q8_12;

public class Question
{
	private final static int INIT_NUM = -1;
	private final static int QUEEN = 9;
	
	public static void main(String [] args)
	{
		int chess[][] = new int[8][8];
		for (int i = 0 ; i < 8 ; i++)
			for (int j = 0 ; j < 8 ; j++)
				chess[i][j] = INIT_NUM;
		solve(chess, 0);
	}
	
	public static void solve(int chess[][], int row)
	{
		/**
		 * 	Sol1. brute-force
		 * 	1. 맨 위부터 체크하면서 맨 아래로 마크하면서 수행.
		 * 	2. mark (가로, 세로 대각선 표시)
		 * 	3. 재귀 호출
		 * 	4. unmark (이전에 표시해뒀던 것만 unmark 해야 함)
		 */
		
		/** 종료 조건 */
		if (row == 8)
		{
			print(chess);
			return ;
		}
		
		for (int col = 0 ; col < 8 ; col++)
		{
			if (chess[row][col] == INIT_NUM)
			{
				mark(chess, row, col);
				solve(chess, row+1);
				unmark(chess, row, col);
			}
		}
		
	}
	
	public static void print(int chess[][])
	{
		for (int row = 0 ; row < 8 ; row++)
		{
			for (int col = 0 ; col < 8 ; col++)
			{
				System.out.print(chess[row][col] + "\t");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public static void mark(int chess[][], int row, int col)
	{
		// row mark
		for (int i = 0 ; i < 8 ; i++)
		{
			if (chess[row][i] == INIT_NUM)
				chess[row][i] = row;
		}
		
		// col mark
		for (int i = 0 ; i < 8 ; i++)
		{
			if (chess[i][col] == INIT_NUM)
				chess[i][col] = row;
		}
		
		// diagonal mark
		int x = row;
		int y = col;
		
		while (x >= 0 && y >= 0)
		{
			if (chess[x][y] == INIT_NUM)
				chess[x][y] = row;
			x--; y--;
		}
	
		x = row; y = col;
		while (x >= 0 && y < 8)
		{
			if (chess[x][y] == INIT_NUM)
				chess[x][y] = row;
			x--; y++;
		}
		
		x = row; y = col;
		while (x < 8 && y < 8)
		{
			if (chess[x][y] == INIT_NUM)
				chess[x][y] = row;
			x++; y++;
		}
		
		x = row; y = col;
		while (x < 8 && y >= 0)
		{
			if (chess[x][y] == INIT_NUM)
				chess[x][y] = row;
			x++; y--;
		}
		
		chess[row][col] = QUEEN;
	}
	
	public static void unmark(int chess[][], int row, int col)
	{
		// row mark
		for (int i = 0 ; i < 8 ; i++)
		{
			if (chess[row][i] == row)
				chess[row][i] = INIT_NUM;
		}
		
		// col mark
		for (int i = 0 ; i < 8 ; i++)
		{
			if (chess[i][col] == row)
				chess[i][col] = INIT_NUM;
		}
		
		// diagonal mark
		int x = row;
		int y = col;
		
		while (x >= 0 && y >= 0)
		{
			if (chess[x][y] == row)
				chess[x][y] = INIT_NUM;
			x--; y--;
		}
	
		x = row; y = col;
		while (x >= 0 && y < 8)
		{
			if (chess[x][y] == row)
				chess[x][y] = INIT_NUM;
			x--; y++;
		}
		
		x = row; y = col;
		while (x < 8 && y < 8)
		{
			if (chess[x][y] == row)
				chess[x][y] = INIT_NUM;
			x++; y++;
		}
		
		x = row; y = col;
		while (x < 8 && y >= 0)
		{
			if (chess[x][y] == row)
				chess[x][y] = INIT_NUM;
			x++; y--;
		}
		
		chess[row][col] = INIT_NUM;
	}
}
