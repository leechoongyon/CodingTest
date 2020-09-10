package codingtest.site.codingInterview.sort.Q10_03;

public class Question
{
	public static void main(String [] args)
	{
		int arr[] = new int[] {15,16,19,20,25,1,3,4,5,7,10,14};
		System.out.println(solve(arr,15,0,arr.length - 1));
		System.out.println(solve(arr,16,0,arr.length - 1));
		System.out.println(solve(arr,19,0,arr.length - 1));
		System.out.println(solve(arr,20,0,arr.length - 1));
		System.out.println(solve(arr,25,0,arr.length - 1));
		System.out.println(solve(arr,1,0,arr.length - 1));
		System.out.println(solve(arr,3,0,arr.length - 1));
		System.out.println(solve(arr,4,0,arr.length - 1));
		System.out.println(solve(arr,5,0,arr.length - 1));
		System.out.println(solve(arr,7,0,arr.length - 1));
		System.out.println(solve(arr,10,0,arr.length - 1));
		System.out.println(solve(arr,14,0,arr.length - 1));
	}
	
	public static int solve(int arr[], int n, int first, int last)
	{
		int mid = (first + last) / 2;
		if (arr[mid] == n) return mid;
		else if (arr[first] <= n && n <= arr[mid])
		{
			if (arr[mid] == n) return mid;
			else return solve(arr,n,first,mid);
		}
		else if (arr[mid] <= n && n <= arr[last])
		{
			if (arr[mid + 1] == n) return mid + 1;
			else return solve(arr, n, mid + 1, last);
		}
		else if (arr[first] <= n && arr[mid] <= n)
		{
			if (arr[mid] == n) return mid;
			else if (arr[first] <= arr[mid]) return solve(arr, n, mid + 1, last);
			else if (arr[first] > arr[mid]) return solve(arr, n, first, mid);
		}
		
		/** 못 찾을 경우 -1 */
		return -1;
	}
}
