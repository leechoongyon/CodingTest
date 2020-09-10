package codingtest.site.hackerrank;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author lee
 *
 * 1. 정렬되지 않은 수를 정렬시키는데 swap 을 최소 몇 번 하는지? 
 * 2. 중복 없음.
 */
public class MinimumSwaps2
{
	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int arr[] = new int [n];
		for (int i = 0; i < n; i++)
			arr[i] = in.nextInt();
		System.out.println(solve(arr));
	}

	public static int solve(int arr[])
	{
		/**
		 * * brute force
		 * - 끝에서부터 앞에서 제일 작은 것과 Swap 복잡도 : O(n2)
		 * 
		 * * optimize
		 * - 메모리를 이용해서 최적화
		 * 		- 이 방법은 모든 케이스를 비교하지 않음.
		 * - 알고리즘
		 */

		int arrLength = arr.length;
		int swapCount = 0;
		int copyArr[] = arr.clone();
		Arrays.sort(copyArr);
		for (int i = 0 ; i < arrLength ; i++)
		{
			if (arr[i] != copyArr[i])
			{
				swapCount++;
				for (int j = i + 1 ; j < arrLength ; j++)
				{
					if (arr[j] == copyArr[i])
					{
						int temp = arr[j];
						arr[j] = arr[i];
						arr[i] = temp;
						break;
					}
				}
			}
		}
		return swapCount;
	}
}
