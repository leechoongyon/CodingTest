package codingtest.site.codingInterview.bitOperation.Q5_Q6;

public class Question
{
	public static void main(String[] args)
	{
		int A = 29;
		int B = 15;
		
		int diffCount = 0;
		
		for (int i = 0 ; i < 32 ; i++)
		{
			if (((A & (1 << i)) != (B & (1 << i))))
				diffCount++;
		}
		
		System.out.println(diffCount);
	}
}
