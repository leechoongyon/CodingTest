package codingtest.site.sort;

/**
 * @author lee
 *
 */

public class HeapSortFunction
{
	public void sort(int arr[])
	{
		int n = arr.length;
		
		// 최대 힙을 구성
		for (int i = n / 2 - 1 ; i >= 0 ; i--)
			heap(arr, n, i);
		
		// delete 연산을 수행해 뒤에 배열부터 노트 노드랑 swap
		for (int i = n - 1 ; i >= 0 ; i--)
		{
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;
			
			heap(arr, i, 0);
			printArray(arr);
		}
		
	}
	
	public void heap(int arr[], int n, int parent)
	{
		int largest = parent;
		int left = 2 * parent + 1;
		int right = 2 * parent + 2;
		
		// 왼쪽 자식노드 중 큰 것
		if (left < n && arr[left] > arr[largest])
			largest = left;
		
		// 오른쪽 자식노드 중 큰 것
		if (right < n && arr[right] > arr[largest])
			largest = right;
		
		// largest != parent 가 다르면 swap
		// 재귀를 한 번 더 태우는 이유는 swap 해서 변경된 값에 대해 다시 한 번 최대 힙을 만들어야 함.
		if (largest != parent)
		{
			int swap = arr[parent];
			arr[parent] = arr[largest];
			arr[largest] = swap;
			
			heap(arr, n, largest);
		}
	}
	
	public static void printArray(int arr[])
	{
		int n = arr.length;
		for (int i = 0 ; i < n ; i++)
			System.out.println(arr[i] + " ");
		System.out.println();
	}
	
	public static void main(String args[])
	{
		int arr[] = {12,11,13,5,6,7};
		System.out.println("before sorting array is");
		printArray(arr);
		
		HeapSortFunction ob = new HeapSortFunction();
		ob.sort(arr);
		
		System.out.println("sorted array is");
		printArray(arr);
	}
}
