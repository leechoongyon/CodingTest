package codingtest.site.hackerrank;

import java.util.Scanner;

/**
 * @author lee
 *
 *         문제 : arr 가 주어졌을 때, 오름차순 정렬하기 위해 몇 번의 swap 이 필요한지?
 *
 *         1 5 2 1 3 1 2
 */
public class MergeSortCountingInversions
{
	public static long mergeSort(int arr[], int start, int end)
	{
		if (start == end) return 0;
		int mid = ( start + end ) / 2;
		long cnt = 0;
		cnt += mergeSort(arr, start, mid); 
		cnt += mergeSort(arr, mid + 1, end);
		cnt += merge(arr, start, end); 
		return cnt;
	}

	public static long merge(int arr[], int start, int end)
	{
		int mid = ( start + end ) / 2;
		int copy[] = new int [end - start + 1];
		int curr = 0;
		int left = start;
		int right = mid + 1;
		long cnt = 0;
		while (left <= mid && right <= end)
		{
			if (arr[left] > arr[right])
			{
				copy[curr++] = arr[right++];
				cnt += mid - left + 1;
			}
			else
				copy[curr++] = arr[left++];
		}
		
		while (left <= mid)
			copy[curr++] = arr[left++];

		while (right <= end)
			copy[curr++] = arr[right++];
		
		System.arraycopy(copy, 0, arr, start, end - start + 1);
		return cnt;
	}

	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);
		int d = in.nextInt();
		for (int i = 0; i < d; i++)
		{
			int n = in.nextInt();
			int arr[] = new int [n];
			for (int j = 0; j < n; j++)
			{
				arr[j] = in.nextInt();
			}
			System.out.println(mergeSort(arr, 0, arr.length - 1));
		}
	}
}
