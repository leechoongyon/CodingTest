package codingtest.site.hackerrank;

import java.util.*;

/**
 * @author lee
 *
 *	1. 출발 지점에서 모든 노드까지의 최단거리를 구하라.
 *	2. 두 노드 간에 거리 6
 *	3. input

2
4 2
1 2
1 3
1
3 1
2 3
2


1
6 5
1 2
1 4
2 5
4 6
3 6


	4. output
6 6 -1
-1 6

	5. 생각
		5.1 BFS 개념 모호
		5.2 Start 지점 부터 노드 간 거리를 구하는 방법과 저장 방법
		5.3 while 문을 돌면서 length 를 6씩 증가하는 방법을 씀.
			- 이렇게 하면 같은 레벨의 Distance 가 다르게 나옴. 그러하기에 기존 nodeNum + 6 으로 대체

 */
public class ShortestReachInAGroup
{	
	private static Map<Integer, List<Integer>> graph; 
	private static boolean visited[];
	
	private static int n;
	
	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);
	
		// number of queries
		int q = in.nextInt();
		
		for (int j = 0 ; j < q ; j++)
		{
			// number of node
			n = in.nextInt();
			
			graph = new HashMap<Integer, List<Integer>>();
			visited = new boolean[n + 1];
			
			for (int k = 1 ; k <= n ; k++)
			{
				graph.put(k, new ArrayList<Integer>());
			}
			
			// number of edges
			int m = in.nextInt();
			
			for (int i = 0 ; i < m ; i++)
			{
				int u = in.nextInt(); 
				int v = in.nextInt();
				
				graph.get(u).add(v); 
				graph.get(v).add(u);
			}
			
			int s = in.nextInt();
			
			int res[] = BFS(s);
			
			printAnswer(s, res);
		}
	}
	
	public static void printAnswer(int start, int res[])
	{
		for (int i = 1 ; i < res.length ; i++)
		{
			if (start == i)
				continue;
			
			if (res[i] == 0)
				System.out.print(-1 + " ");
			else
				System.out.print(res[i] + " ");
		}
		System.out.println();
	}
	
	public static int[] BFS(int start)
	{
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(start);
		
		int res[] = new int[n + 1];
		int nodeNum = 0;
		
		visited[start] = true;
		
		while ( !queue.isEmpty())
		{
			nodeNum = queue.poll();
			for (Integer edgeNum  : graph.get(nodeNum))
			{
				if (visited[edgeNum] == false)
				{
					queue.add(edgeNum);
					res[edgeNum] = res[nodeNum] + 6;
					visited[edgeNum] = true;
				}
			}
		}
		return res;
	}
}
