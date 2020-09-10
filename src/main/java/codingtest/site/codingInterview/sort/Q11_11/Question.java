package codingtest.site.codingInterview.sort.Q11_11;

import java.util.Arrays;

public class Question
{
	public static void main(String [] args)
	{
		int arr[] = new int[] {5,3,1,2,4,6};
//		int arr[] = new int[] {5,3,1,2,3};
		int res[] = solve(arr);
		for (int i : res)
			System.out.print(i + " ");
	}
	
	/**
	 * 	입력 : {5,3,1,2,3}
	 * 	출력 : {5,1,3,2,3}
	 */
	public static int[] solve(int arr[])
	{
		Arrays.sort(arr);
		
		int mid = (0 + arr.length - 1) / 2;
		int lastPos = arr.length - 1; 
		
		int res[] = new int[arr.length];
		
		int leftPos = 0;
		int midPos = mid;
		int curPos = 0;
		while (leftPos <= mid && mid < lastPos)
		{
			res[curPos++] = arr[lastPos--];
			res[curPos++] = arr[leftPos++];
		}
		
		while (leftPos <= mid)
			res[curPos++] = arr[leftPos++];
		while (mid < lastPos)
			res[curPos++] = arr[lastPos--];
		
		return res;
	}
}
