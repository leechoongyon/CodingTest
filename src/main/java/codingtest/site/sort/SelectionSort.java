package codingtest.site.sort;

public class SelectionSort
{
	public static void main(String [] args)
	{
		int[] arr = new int[] {10, 13, 7, 5, 3, 6, 1, 2};
		sort(arr);
		for (int i = 0 ; i < arr.length ; i++)
			System.out.print(arr[i] + " ");
	}
	
	private static void sort(int[] arr)
	{
		/**
		 * 	처음부터 끝까지 작은 수 찾기.
		 * 	처음 + 1 부터 끝까지 작은 수 찾기. 
		 * 	반복
		 */

		int minIndex = 0;
		int temp = 0;
		for (int i = 0 ; i < arr.length ; i++)
		{
			minIndex = i;
			for (int j = i ; j < arr.length ; j++)
			{
				if (arr[j] < arr[minIndex])
					minIndex = j;
			}
			
			if (i != minIndex)
			{
				temp = arr[i];
				arr[i] = arr[minIndex];
				arr[minIndex] = temp;
			}
		}
	}
}
