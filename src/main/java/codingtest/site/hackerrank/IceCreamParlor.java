package codingtest.site.hackerrank;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author lee
 * 
 *         1. 2명이 아이스크림을 고른다. 돈이 주어지고, 아이스크림 가격이 주어짐. 2. 돈에 딱 맞게끔 아이스크림을 고르면 된다.
 *         3. 아이스크림의 ID 가 작은 것이 첫번째, 큰 것이 두번째 출력되면 된다. 4. 답은 오직 하나다.
 */
public class IceCreamParlor
{
	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int testcase = 0; testcase < t; testcase++)
		{
			int money = in.nextInt();
			int n = in.nextInt();
			int id[] = new int [n + 1];
			for (int i = 1; i < n + 1; i++)
				id[i] = in.nextInt();
			int res[] = solve(id, money);
			for (int num : res)
			{
				System.out.print(num + " ");
			}
			System.out.println();
		}
		in.close();
	}

	public static int [] solve(int [] id, int money)
	{
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int i = 1; i < id.length; i++)
		{
			map.put(id[i], i);
		}
		System.out.println(map);
		for (int i = 1; i < id.length; i++)
		{
			int diff = money - id[i];
			if (diff > 0 && map.containsKey(diff)
					&& map.get(diff) != i)
			{
				return new int [] { i, map.get(diff) }; 
			}
		}
		throw new IllegalArgumentException("No answer...");
	}
}