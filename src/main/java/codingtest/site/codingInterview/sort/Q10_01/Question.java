package codingtest.site.codingInterview.sort.Q10_01;

public class Question
{
	public static void main(String [] args)
	{
		int a[] = new int[8];
		a[0] = 1; a[1] = 3; a[2] = 6; a[3] = 7;
		int b[] = new int[] {2,4,9,10};
		sort(a,b, 3, 3, a.length - 1);
		for (int i : a)
			System.out.print(i + " ");
	}
	
	/**
	 *
	 * 마지막 위치부터 넣어나간다.
	 * O(n)
	 * 
	 * @param aPos		a의 인덱스 위치
	 * @param bPos		b의 인덱스 위치
	 * @param iPos		a의 마지막 인덱스 위치
	 */
	public static void sort(int a[], int b[], int aPos, int bPos, int iPos)
	{
		while (aPos >= 0 && bPos >= 0)
		{
			if (a[aPos] < b[bPos])
			{
				a[iPos] = b[bPos];
				iPos--; bPos--; 
			}
			else
			{
				a[iPos] = a[aPos];
				iPos--; aPos--;
			}
		}
		
		while (aPos >= 0)
			a[iPos--] = a[aPos--];
		
		while (bPos >= 0)
			a[iPos--] = b[bPos--];
	}
}
