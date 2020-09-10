package codingtest.site.codingInterview.sort.Q11_11;

public class Improved
{
	public static void main(String [] args)
	{
		int array[] = new int[] {5,3,1,2,4,6};
		sortValleyPeak(array);
		for (int i : array)
			System.out.print(i + " ");
	}	
	
	/**
	 *	1. element 3개를 비교하면서 정렬해 나감.
	 *	2. 세 개의 element 중 제일 큰 것을 가운데 것이랑 바꾸면 자연스럽게 peak, valley 가 됨.
	 *	3. 처음과 마지막은 1개씩 비교함. (양옆 비교 아님)  
	 */
	public static void sortValleyPeak(int array[])
	{
		for (int i = 1 ; i < array.length ; i+=2)
		{
			int maxIndex = getMaxIndex(array, i-1, i, i+1);
			if (i != maxIndex)
			{
				swap(array, i, maxIndex);
			}
		}
	}
	
	public static int getMaxIndex(int array[], int a, int b, int c)
	{
		int length = array.length;
		int aValue = (a >= 0 && a < length) ? array[a] : Integer.MIN_VALUE;
		int bValue = (b >= 0 && b < length) ? array[b] : Integer.MIN_VALUE;
		int cValue = (c >= 0 && c < length) ? array[c] : Integer.MIN_VALUE;
		
		int max = Math.max(aValue, Math.max(bValue, cValue));
		if (max == aValue) return a;
		else if (max == bValue) return b;
		else return c;
	}
	
	public static void swap(int array[], int a, int b)
	{
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}
}
