package codingtest.site.util;

public class Combination
{

	public static void main(String [] args)
	{
		int [] arr = new int [5];
		System.out.println(combination(arr, 0, 5, 2, 0));;
	}

	public static int combination(int [] arr, int index, int n, int r, int target)
	{
		if (r == 0)
			return sum(arr, index);
		else if (target == n)
			return 0;
		else
		{
			arr[index] = target;
			combination(arr, index + 1, n, r - 1, target + 1);
			combination(arr, index, n, r, target + 1);
		}
		return 0;
	}

	public static int sum(int [] arr, int length)
	{
		int sum = 0;
		for (int i = 0; i < length; i++)
			sum += arr[i];

		return sum;
	}

}
