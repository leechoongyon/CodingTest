package codingtest.site.sort;

public class BubbleSort
{
	public static void main(String [] args)
	{
		int[] arr = new int[] {10, 13, 7, 5, 3, 6, 1, 2};
		sort(arr);
		for (int i = 0 ; i < arr.length ; i++)
			System.out.print(arr[i] + " ");
	}
	
	public static void sort(int[] arr)
	{
		/**
		 * 	처음부터 끝까지 회전
		 * 	처음부터 마지막 - 1 까지 회전
		 * 	처음부터 마지막 - 2 까지 회전
		 */
		int temp = 0;
		for (int i = arr.length - 1 ; i >= 0 ; i--)
		{
			for (int j = 0 ; j < i ; j++)
			{
				if (arr[j] > arr[j+1])
				{
					temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
	}
}

