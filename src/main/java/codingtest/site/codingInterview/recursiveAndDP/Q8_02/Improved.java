package codingtest.site.codingInterview.recursiveAndDP.Q8_02;

import java.util.ArrayList;
import java.util.List;

public class Improved
{
	private static int ROW = 5;
	private static int COL = 5;
	private static int arr[][] = new int[ROW][COL];
	private static List<Point> list = new ArrayList<Point>();
	public static void main(String[] args)
	{
		/** 금지 영역 */
		arr[0][1] = -1; arr[0][2] = -1;
		
		goAround(0, 0);
	}
	
	/**
	 *	1. O(r,c) 오른쪽 하단 꼭지점에 도달하기 위해, 
	 *	   O(r-1, c), O(r, c-1) 위치에 있어야 한다.
	 *	2. 위와 같이 하면 O(r,c) 에 도달하는 경로를 구하기 위해 이전 위치들의 값을 알아야 한다.
	 *	
	 *	* 금지 영역은 -1 , 통과해도 되는 지점은 0이라 가정
	 *
	 * 	* 메모라이제이션 사용
	 * 	1. r,c 위치에 해당하는 모든 경로를 cache 에 담고 있어야 함. 
	 * 		1,1 위치에 1,2 --> 1,3 --> 1,4 --> 2,1 --> ... 
	 * 				   1,2 --> 1,3 --> 2.2 --> ...
	 * 
	 * 		key 가 int r,c 이고, 뒤에 경로는 List 로 담아야할 것 같음.
	 * 		Object[][] obj = list 의 주소 값.
	 */
	
	public static void goAround(int r, int c)
	{
		/** validate */
		if (r > ROW - 1 || c > COL - 1 || arr[r][c] == -1) return ; 
			
		/** 오른쪽 꼭지점 도달 */
		if (r == ROW - 1 && c == COL - 1) 
		{
			print(list);
			return ;
		}
		
		/** 오른쪽, 아래로 이동하는 경로 */
		list.add(new Point(r, c+1));
		goAround(r, c + 1);
		list.remove(list.size() - 1);
		
		list.add(new Point(r+1, c));
		goAround(r+1, c);
		list.remove(list.size() - 1);
	}
	
	public static void print(List<Point> list)
	{
		for (int i = 0 ; i < list.size() ; i++)
		{
			System.out.print(list.get(i).row + "," + list.get(i).col);
			if (i != list.size() - 1) System.out.print(" --> ");
		}
		System.out.println();
	}
	
	public static class Point
	{
		int row;
		int col;
		
		public Point(int r, int c)
		{
			this.row = r;
			this.col = c;
		}

		@Override
		public String toString()
		{
			return "Point [row=" + row + ", col=" + col + "]";
		}
	}
}
