package codingtest.site.solveProblemsExample;

import java.util.ArrayList;

/**
 * @author	: 2013BWG-02
 * @date	: 2014. 11. 12.
 * @desc	:
 * 
 * 1. Sum이라는 정보를 저장해둘 필요 없음.
 * 2. 아래로 내려가는 path, 오른쪽으로 가는 path중 어떤 것이 더 큰지를 판단해서 기존 triangle[x][y]에 더해주면 됨.
 *
 */
public class Q10_TRIANGLEPATH
{
	static int board[][] = new int[5][5];
	static int cache[][] = new int[5][5];
	static int max = 0;

	static int n = 5;
	
	public static void main(String[] args)
	{
		board[0][0] = 6;
		board[1][0] = 1; board[1][1] = 2;
		board[2][0] = 3; board[2][1] = 7; board[2][2] = 4;
		board[3][0] = 9; board[3][1] = 4; board[3][2] = 1; board[3][3] =7;
		board[4][0] = 2; board[4][1] = 7; board[4][2] = 5; board[4][3] = 9; board[4][4] = 4;

		ArrayList<Integer> picked = new ArrayList<Integer>();

		System.out.println(new Q10_TRIANGLEPATH().path2(0, 0));
		
//		new Q10_CalculateMaxDistanceAboveTriangle().CalculateMaxDistanceAboveTriangleWithMemorizatio(0,0,picked);
//		System.out.println("Max : " + max);
	}

	public void CalculateMaxDistanceAboveTriangleWithMemorizatio(int h, int w, ArrayList<Integer> picked)
	{
		picked.add(board[h][w]);

		if(h == board.length -1 && w == board[h].length -1)
		{
			CompareMaxDistance(picked);
		}

		if(h+1 < board.length && board[h+1][w] != 0)
			CalculateMaxDistanceAboveTriangleWithMemorizatio(h+1, w, picked);
		if(w+1 < board[h].length && board[h][w+1] != 0)
			CalculateMaxDistanceAboveTriangleWithMemorizatio(h, w+1, picked);

		picked.remove(picked.size() - 1);
	}

	public void CompareMaxDistance(ArrayList<Integer> picked)
	{
		int sum = 0;

		for(int i = 0; i < picked.size() ; i++)
			sum += picked.get(i);
		if(max <= sum)
			max = sum;
	}
	
	
	public int path2(int x, int y)
	{
		if( x == n - 1 ) return board[x][y];
		
		if(cache[x][y] != 0) return cache[x][y];
		
		return cache[x][y] = Math.max(path2(x+1,y), path2(x+1, y+1)) + board[x][y];
	}
	
}

