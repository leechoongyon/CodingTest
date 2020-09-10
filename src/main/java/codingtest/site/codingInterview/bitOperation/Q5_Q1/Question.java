package codingtest.site.codingInterview.bitOperation.Q5_Q1;

public class Question
{
	public static void main(String[] args)
	{
		int N = Integer.parseInt("10000000000", 2);
		int M = Integer.parseInt("10011", 2);
		System.out.println(insert(N, M, 2, 6));
	}
	
	/**
	 *	1. N 의 i 부터 j 까지 비트를 0으로 초기화
	 *	2. M 을 순회하면서 M 의 비트가 1이면, 1 << i 로 해당 위치를 만듬.
	 *	3. N | ( 1 << i ) 로 비트를 변경시켜 줌.
	 *
	 *  비트가 초과되거나 i,j 가 이상한 값이 들어오는건 가정하지 않는다. (문제에서 언급 됨)
	 */
	public static String insert(int N, int M, int i, int j)
	{
		int result = 0;
		for (int s = i ; s <= j ; s++ )
		{
			N = clearBit(N, s);
		}
		M = M << i;
		result = N | M ;
		return Integer.toBinaryString(result);
	}
	
	public static int clearBit(int N, int i)
	{
		i = ~(1 << i);
		return N & (i);
	}
}
