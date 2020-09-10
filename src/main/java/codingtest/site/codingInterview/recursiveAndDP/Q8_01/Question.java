package codingtest.site.codingInterview.recursiveAndDP.Q8_01;

public class Question
{
	private static int matchCount = 0;
	public static void main(String[] args)
	{
		permutation(5, 0);
		System.out.println(matchCount);
	}
	
	public static void permutation(int n, int sum)
	{
		if (n < sum) 
		{
			return ;
		}
		
		if (n == sum)
		{
			matchCount++;
			return ;
		}
		
		for (int i = 1 ; i <= 3 ; i++)
		{
			permutation(n, sum + i);
		}
	}
}
