package codingtest.site.acmicpc;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author lee
 * @point
 * 	1. 건설순서 자료구조를 어떤걸 사용할 것인가?
 * 	2. 순서를 정한 뒤 시간을 구해야하는데 시간은 최대 시간을 구해야한다. 이를 어떻게 해결할 것인가?
 * 	3. 컴퓨터가 인식할 수 있는 문제의 패턴이 뭘까?   
 */
public class Num1005
{
	private static int D[] = null;
	private static int cache[] = null;
	private static List<BuildingOrder> list;
	
	public static void main(String [] args)
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int W;
		
		BuildingOrder buildingOrder = null;
		for (int i = 0 ; i < T ; i++)
		{
			// 건물 및 순서 갯수
			int N = sc.nextInt();
			int K = sc.nextInt();

			// 건설에 걸리는 시간 D
			D = new int[N];
			for (int j = 0 ; j < N ; j++)
			{
				D[j] = sc.nextInt();
			}
			
			// 건설순서 X Y
			list = new ArrayList<BuildingOrder>();
			for (int z = 0 ; z < K ; z++)
			{
				buildingOrder = new BuildingOrder(sc.nextInt(), sc.nextInt());
				list.add(buildingOrder);
			}
			
			W = sc.nextInt();
			cache = new int[N];
			
			System.out.println(solve(W, D, list, cache));
		}
	}
	
	public static int solve(int W, int D[], List<BuildingOrder> list, int cache[])
	{
		// 기저사례
		if (cache[W-1] != 0)
		{
			return cache[W-1];
		}
		cache[W-1] = D[W-1];
		
		// 재귀
		for (BuildingOrder buildingOrder : list)
		{
			int time = D[W-1];
			if (W == buildingOrder.Y)
			{
				time += solve(buildingOrder.X, D, list, cache);
				cache[W-1] = Math.max(time, cache[W-1]); 
			}
		}
		return cache[W-1];
	}
}

class BuildingOrder
{
	int X;
	int Y;
	
	public BuildingOrder(int x, int y)
	{
		X = x;
		Y = y;
	}
}