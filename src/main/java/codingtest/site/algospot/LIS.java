package codingtest.site.algospot;

/**
 * @file		algospot.LIS.java
 * @filetype	java source file
 * @brief
 * @author		lee
 * @version		0.1
 * @history
 * 버전			성명			일자			변경내용
 * 0.1			lee		2015. 9. 26.		신규작성
 *
 *	1. lis는 Cache 안쓴 것
 *	2. lis2는 Cache 사용 (중복된 계산을 피할 수 있음)
 */
public class LIS 
{
	
	private final static int S[] = {7,1,2,5,6,8,9};
	private final static int cache[] = new int[7];
	
	public static void main(String[] args) 
	{
		flow();
	}
	
	public static void flow()
	{
		int max = 0;
		
		// lis
		long before = System.nanoTime();
		for (int i = 0 ; i < S.length ; i++)
			max = Math.max(max, lis(i));
		System.out.println(max);
		System.out.println("lis time : " + (System.nanoTime() - before));
		
		// lis2
		before = System.nanoTime();
		for (int i = 0 ; i < S.length ; i++)
			max = Math.max(max, lis2(i));
		System.out.println(max);
		System.out.println("lis time : " + (System.nanoTime() - before));
	}
	
	public static int lis(int start)
	{
		int max = 0;
		
		if (start == S.length -1)
			return 1;
		
		for (int next = start + 1 ; next < S.length ; next++)
		{
			if (S[start] < S[next])
				max = Math.max(max, 1 + lis(next)); 
		}
		
		return max;
	}
	
	public static int lis2(int start)
	{
		if (cache[start] != 0)
			return cache[start];
		if (start == S.length -1)
			return 1;
		
		for (int next = start + 1 ; next < S.length ; next++)
		{
			if (S[next] > S[start])
				cache[start] = Math.max(cache[start], 1+ lis2(next));
		}
		
		return cache[start];
	}
}
