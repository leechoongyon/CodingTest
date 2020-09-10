package codingtest.site.solveProblemsExample;

public class Q14_Tiling 
{
	static int board[][] = new int[2][5];
	static int cache[] = new int[5];

	public static void main(String[] args)
	{
		System.out.println("routeCount : " + new Q14_Tiling().Tiling(0));
	}

	// case 1 : 1*2
	// case 2 : 2*1


	public int Tiling(int start)
	{

		if(start == board[0].length)
			return 1;
		else if(start > board[0].length)
			return 0;

		if(cache[start] != 0) return cache[start];		

		for(int i = 0 ; i < 2 ; i++)
		{
			if( i % 2 == 0 && i + 2 < board[0].length)
				cache[start] += Tiling(start+2);
			else if( i % 2 == 1 && i+1 < board[0].length)
				cache[start] += Tiling(start+1);
		}

		return cache[start];
	}

}
