package codingtest.site.sort;

public class QuickSort
{
	public void sort(int [] arr, int left, int right)
	{
		int leftPos = left;
		int rightPos = right;
		int pivot = arr[ ( left + right ) / 2 ];

		/**
		 * pivot 의 왼쪽이 pivot 의 오른쪽 보다 크면 중지
		 * pivot 의 값은 left <= right 조건이기에 마지막에 swap 됨. 
		 */
		do
		{
			while (arr[leftPos] < pivot) leftPos++;
			while (arr[rightPos] > pivot) rightPos--;
			if (leftPos <= rightPos)
			{
				swap(arr, leftPos, rightPos);
				leftPos++;
				rightPos--;
			}
		}
		while (leftPos <= rightPos);

		// 왼쪽 부분집합 정렬
		/** 
		 * 	이게 언뜻 보면 rightPos 가 아니라 leftPos 가 와야하는데,
		 *	rightPos 가 온 이유는 위에 로직대로 타고 흐르면 leftPos 가 rightPos 를 넘어서고,
		 *	rightPos 는 leftPos 보다 작아짐. 즉, pivot 을 기준으로 서로 뒤바뀜.
		 *	이건 그림 한 번 그려보면 쉽게 이해 감
		 */
		if (left < rightPos)
			sort(arr, left, rightPos);
		// 오른쪽 부분집합 정렬
		if (right > leftPos)
			sort(arr, leftPos, right);
	}

	private void swap(int arr[], int a, int b)
	{
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	
	public static void main(String [] args)
	{

		int arr[] = { 9, -7, -10, 1, 0, 55, 100, -1 };

		QuickSort quick = new QuickSort();
		quick.sort(arr, 0, arr.length - 1);
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
	}
}