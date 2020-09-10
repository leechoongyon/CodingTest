package codingtest.site.codingInterview.recursiveAndDP.Q8_01;

public class Repeat
{
	private static int cache[] = new int[11];
	
	public static void main(String [] args)
	{
		System.out.println(solve(10));
	}
	
	public static int solve(int remain)
	{
		int ways = 0;

		/** 기저 사례 */
		if (remain == 0) return 1;
		else if (remain < 0) return 0;

		/** 캐시 */
		if (cache[remain] != 0) return cache[remain];
		
		for (int i = 1 ; i <= 3 ; i++)
		{
			ways += solve(remain - i);
		}
		return cache[remain] = ways;
	}
}
