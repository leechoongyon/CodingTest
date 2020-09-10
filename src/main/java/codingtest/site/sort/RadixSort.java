package codingtest.site.sort;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class RadixSort
{
	private static Queue<Integer> queue[] = new LinkedBlockingQueue[]
			{
				new LinkedBlockingQueue<Integer>(), new LinkedBlockingQueue<Integer>(), new LinkedBlockingQueue<Integer>(),
				new LinkedBlockingQueue<Integer>(), new LinkedBlockingQueue<Integer>(), new LinkedBlockingQueue<Integer>(),
				new LinkedBlockingQueue<Integer>(), new LinkedBlockingQueue<Integer>(), new LinkedBlockingQueue<Integer>(), 
				new LinkedBlockingQueue<Integer>()
			};
	public static void main(String [] args)
	{
		
		int arr[] = new int[] {15,27,64,255,256,505,17,39,28};
		int res[] = sort(arr, 3);
		for (int i : res)
			System.out.print(i + " ");
	}
	
	
	/**
	 * 	1. 버킷을 9개 만듬.
	 * 	2. 배열 중 가장 자릿수가 큰 것을 구함.
	 * 	3. 일의 자리부터 비교해서 버킷에 집어넣음.
	 * 	4. 버킷에 집어넣은 것을 0~9부터 순서대로 빼서 배열에 집어넣음.
	 * 	5. 십의 자리를 비교. 위에 반복.
	 * 	6. 배열 출력
	 */
	public static int[] sort(int arr[], int maxDigit)
	{
		int res[] = arr;
		for (int i = 0 ; i < maxDigit ; i++)
		{
			res = internalSort(res, i);
//			print(res);
		}
		
		return res;
	}
	
	public static int[] internalSort(int arr[], int digit)
	{
		int k = 0;
		int pos = 0;
		int res[] = new int[arr.length];
		
		for (int i = 0 ; i < arr.length ; i++)
		{
			if (digit == 0)
				k = arr[i] % 10;
			else
				k = (int) (arr[i] / Math.pow(10, digit)) % 10;
			queue[k].add(arr[i]);
		}
		
		for (int i = 0 ; i < queue.length ; i++)
		{
			while (!queue[i].isEmpty())
				res[pos++] = queue[i].poll();
		}
		return res;
	}
}
