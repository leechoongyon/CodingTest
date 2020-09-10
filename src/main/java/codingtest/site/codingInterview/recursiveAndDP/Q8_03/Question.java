package codingtest.site.codingInterview.recursiveAndDP.Q8_03;

public class Question
{
	public static void main(String[] args)
	{
		int arr[] = new int[] {-1,1,2,7,9,11};
		System.out.println(getMagicIndex(arr, 0, arr.length - 1));
	}
	
	/**
	 *	1. 이진 탐색을 이용해서 풀기
	 *	2. 가운데 index 의 값이 같으면 해당 값을 return
	 *	3. 가운데 index 의 값이 작으면 left 로 이동. 반대면 right 이동
	 *	4. 반복해서 찾기.
	 */
	public static int getMagicIndex(int arr[], int start, int end)
	{	
		/** 1/2 씩 하니 결국 start = end 가 됨. */
		if (start == end) 
		{
			if (arr[start] == start) return start;
			else return Integer.MIN_VALUE;
		}
		
		/** 미드 값 비교 */
		int mid = (start + end) / 2;
		if (arr[mid] == mid) return mid;
		else if (arr[mid] > mid) return getMagicIndex(arr, start, mid - 1);
		else return getMagicIndex(arr, mid + 1, end);
	}
}
