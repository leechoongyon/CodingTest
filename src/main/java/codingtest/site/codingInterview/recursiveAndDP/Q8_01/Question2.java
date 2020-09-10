package codingtest.site.codingInterview.recursiveAndDP.Q8_01;

public class Question2
{
	private static int cache[] = new int[100];
	
	public static void main(String[] args)
	{
		System.out.println(countWays(5));
		System.out.println(countWaysUsingCache(5)); 
	}
	
	public static int countWays(int n)
	{
		if (n < 0) return 0;
		else if (n == 0) return 1;
		else 
			return countWays(n-1) + countWays(n-2) + countWays(n-3);
	}
	
	public static int countWaysUsingCache(int n)
	{
		if (cache[n] != 0) return cache[n];
		if (n < 0) return 0;
		else if (n == 0) return 1;
		else 
		{
			return cache[n] = (countWays(n-1) + countWays(n-2) + countWays(n-3));
		}
	}
}
