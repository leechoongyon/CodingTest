package codingtest.site.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *	input 7 3 1 1 5 5 4 6
 *	output 3 1 3 5
 */

public class Num2688
{
	private static int[] arr;
	private static boolean[] visited;
	
	public static void main(String [] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		arr = new int[N + 1];
		visited = new boolean[N + 1];
		for (int i = 1 ; i < N+1 ; i++)
		{
			arr[i] = Integer.parseInt(br.readLine());
		}
		solve(N);
	}
	
	private static void solve(int N)
	{
		List<Integer> list = new ArrayList<>();
		int next = 0;
		/** 처음부터 마지막까지 순회. 인덱스 1부터 시작. 계산 용이 */
		for (int i = 1 ; i < N+1 ; i++)
		{
			/** 
			 * 	visited 를 초기화시키는 이유는 노드마다 DFS 를 
			 * 	수행하기에 이전 이력은 의미가 없다. 
			 */
			visited = new boolean[N + 1];
			if (isCycle(i, i))
			{
				if (list.contains(i)) continue;
				/** cycle 이면, list 에 담음. */
				list.add(i);
				next = arr[i];
				while (next != i)
				{
					list.add(next);
					next = arr[next];
				}
			}
		}
		System.out.println(list.size());
		Collections.sort(list);
		for (int i = 0 ; i < list.size() ; i++)
			System.out.println(list.get(i));
	}
	
	private static boolean isCycle(int point, int start)
	{
		int next = 0;
		if (visited[point]) return false;
		else
		{
			visited[point] = true;
			next = arr[point];
			/** cycle 체크 */
			if (next == start) return true;
			else return isCycle(next, start);
		}
	}
}
