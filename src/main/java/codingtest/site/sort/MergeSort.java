package codingtest.site.sort;

public class MergeSort
{
	public static int [] sorted = new int [30];

	public static void mergeSort(int[] arr, int start, int end)
	{
		int middle;
		/**
		 * 	start < end 가 종료조건
		 * 	일단 나눈다. 그리고 합친다. (divide and conquer)
		 * 	아래와 같이 짜면, start, end 를 기준으로 합침.
		 */
		if (start < end)
		{
			middle = ( start + end ) / 2;
			mergeSort(arr, start, middle);
			mergeSort(arr, middle + 1, end);
			merge(arr, start, middle, end);
		}
	}

	public static void merge(int [] arr, int start, int middle, int end)
	{
		int i, j, k, t;

		i = start;
		j = middle + 1;
		k = start;

		/** 왼쪽과 오른쪽으에 있는 부분들을 비교해서 sorted 에 넣어 줌. */
		while (i <= middle && j <= end)
		{
			if (arr[i] <= arr[j])
				sorted[k] = arr[i++];
			else
				sorted[k] = arr[j++];
			k++;
		}

		/** 남아 있는 것을 처리 */
		if (i > middle)
		{
			for (t = j; t <= end; t++, k++)
				sorted[k] = arr[t];
		}
		else
		{
			for (t = i; t <= middle; t++, k++)
				sorted[k] = arr[t];
		}

		/** sorted 에 있는 것을 arr(원본) 에 반영 */
		for (t = start; t <= end; t++)
			arr[t] = sorted[t];
	}

	public static void main(String [] args)
	{
		int [] arr = { 69, 10, 30, 2, 16, 8, 31, 22 };
		MergeSort.mergeSort(arr, 0, arr.length - 1);
		for (int i : arr)
			System.out.print(i + " ");
	}

}
