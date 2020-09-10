package codingtest.site.solveProblemsExample;

public class Q7_Jump {

	static int board[][] = new int[3][3];
	static int n = 3;
	static int cache[][] = new int[3][3];
	
	public static void main(String[] args)
	{
		board[0][0] = 2; board[0][1] = 1; board[0][2] = 3;
		board[1][0] = 1; board[1][1] = 1; board[1][2] = 2;
		board[2][0] = 1; board[2][1] = 1; board[2][2] = -1;

		cache[0][0] = -1; cache[0][1] = -1; cache[0][2] = -1;
		cache[1][0] = -1; cache[1][1] = -1; cache[1][2] = -1;
		cache[2][0] = -1; cache[2][1] = -1; cache[2][2] = -1;
		
		int sum = 0;

		//TestCase 1 - countRoutes
//		sum = new Q7_Jump().countRoute(0,0,board[0][0]);
//		System.out.println("Sum : " + sum);

		//TestCase 2 - checkRoute
//		System.out.println(new Q7_Jump().checkRoute(0,0));
		
		//TestCase 3 - checkRouteWithMemorization
		System.out.println(new Q7_Jump().checkRouteWithMemorization(0, 0));
		
	}

	public boolean checkRoute(int y, int x)
	{
		if(y >= n || x>= n) return false;
		if(y == n-1 && x == n-1) return true;
		int jumpSize = board[y][x];
		return checkRoute(y + jumpSize, x) || checkRoute(y, x + jumpSize);
	}
	
	public int checkRouteWithMemorization(int x, int y)
	{
		if(y >= n || x>= n) return 0;
		if(y == n-1 && x == n-1) return 1;
		
		int ret = cache[x][y];
		
		if(ret != -1) return ret;
		
		int jumpSize = board[x][y];
		cache[x][y] = checkRouteWithMemorization(x + jumpSize, y) | checkRouteWithMemorization(x, y + jumpSize);
		
		return cache[x][y];
	}

	public int countRoute(int i, int j, int n)
	{
		int ret = 0;
		
		if(i >= board.length || j >= board[i].length)
			return 0;

		if(board[i][j] == -1 && n == 0)
			ret++;
		if(n == 0)
			n =  board[i][j];

		ret += countRoute(i+1, j, --n);
		++n;
		ret += countRoute(i, j+1, --n);


		return ret;
	}

	
}
