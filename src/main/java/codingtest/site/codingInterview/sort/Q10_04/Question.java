package codingtest.site.codingInterview.sort.Q10_04;

public class Question
{
	public static void main(String [] args)
	{
		int arr[] = {1,3,5,7,9,11,13,15,17,19,21};
		for (int a : arr)
			System.out.println(solve(arr, a));
	}
	
	public static int solve(int arr[], int x)
	{
		/**
		 * 	1. 2의 배수씩 접근
		 * 	2. arr[i] 값이 작다면 2의 배수 점프
		 * 	3. arr[i] 값이 크다면 i범위안에 있는 것임. 
		 * 
		 * 	계산의 편의성을 위해 0을 별도로 비교
		 */
		
		if (arr[0] == x) return 0;
		int index = 1;
		while (true)
		{
			try
			{
				if (arr[index] == x)
				{
					return index;
				}
				else if (arr[index] < x)
				{
					index *= 2;
				}
				else if (arr[index] >= x)
				{
					/** (index) 와 (index / 2) 사이에 해당 값이 존재. */
					return binarySearch(arr, x, index / 2, index);
				}
			}
			catch (Throwable th)
			{
				/** (index) 와 (index / 2) 사이에 해당 값이 존재. */
				return binarySearch(arr, x, index / 2, index);
			}
		}
	}
	
	public static int binarySearch(int arr[], int x, int first, int last)
	{
		/** 원래대로라면 listy 자료구조를 이용해서 last 의 값을 찾아야 하나 생략 */
		if (last > arr.length) last = arr.length - 1;
		int mid = (first + last) / 2;
		if (arr[mid] == x) return mid;
		if (arr[mid] < x)
		{
			return binarySearch(arr, x, mid + 1, last);
		}
		else 
			return binarySearch(arr, x, first, mid);
	}
}
