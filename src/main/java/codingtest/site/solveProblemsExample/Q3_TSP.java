package codingtest.site.solveProblemsExample;

import java.util.LinkedList;

public class Q3_TSP
{
	static int n = 4;
	static int distance[][] = new int[n][n];
	
	static int best = Integer.MAX_VALUE;
	
	
	public static void main(String[] args) 
	{
		LinkedList<Integer> list = new LinkedList<Integer>();
		
		boolean taken[] = new boolean[n];
		
		int currentLength = 0;

		// 0��° ���ú��� ����
		list.add(0); taken[0] = true;
		
		setUp();
		
		recursiveTSP(taken, list, currentLength);
		
		System.out.println("best : " + best);
	}
	
	public static void recursiveTSP(boolean taken[], LinkedList<Integer> list, int currentLength)
	{
		
		if ( best < currentLength ) 
			return;
		
		if ( list.size() == n) {
			best = Math.min(best, currentLength);
		}
		
		int here = list.getLast();
		
		for ( int next = 0 ; next < taken.length ; next++) {
			
			if (!taken[next]) {
				list.add(next);
				taken[next] = true;
				recursiveTSP(taken, list,  currentLength + distance[here][list.getLast()]);
				list.removeLast();
				taken[next] = false;
			}
		}
	}
			
			
	
	public static void setUp()
	{
		distance[0][1] = 1; distance[0][2] = 2; distance[0][3] = 3;
		distance[1][0] = 1; distance[1][2] = 5; distance[1][3] = 6;
		distance[2][0] = 2; distance[2][1] = 5; distance[2][3] = 7;
		distance[3][0] = 3; distance[3][1] = 6; distance[3][2] = 7;
	}
}
