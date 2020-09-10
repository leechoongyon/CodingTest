package codingtest.site.hackerrank;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author lee
 *
 * @desc
 * 	1. 조건에 맞는 양말 개수를 구하라.
 * 	2. 조건은 색깔이 같은 양말을 1개로 count 함.
 */
public class SockMerchant
{
	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int arr[] = new int[n];
		for (int i = 0 ; i < n ; i++)
			arr[i] = in.nextInt();
		
		System.out.println(solve(arr));
		
		in.close();
	}
	
	/**
	 * map 에 데이터를 누적해서 넣고, values 을 가져와 계산 
	 * 
	 * @param arr
	 * @return
	 */
	public static int solve(int arr[])
	{
		int pairsCount = 0;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i : arr)
		{
			if (map.containsKey(i))
			{
				map.put(i, map.get(i) + 1);
			}
			else
			{
				map.put(i, 1);
			}
		}
		
		for (Integer i : map.values())
		{
			pairsCount += i / 2;
		}
		return pairsCount;
	}
}
