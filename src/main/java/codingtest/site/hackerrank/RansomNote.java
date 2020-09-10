package codingtest.site.hackerrank;

import java.util.Scanner;

/**
 * @author lee
 * @point & feedback
 *	1. ransom 을 기준으로 managine 비교해나가기.
 *	2. 중복처리를 위해 매칭하면 해당 값 null 로 바꾸기.
 */
public class RansomNote
{
	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);
		int m = in.nextInt();
		int n = in.nextInt();
		String magazine [] = new String [m];
		for (int magazine_i = 0; magazine_i < m; magazine_i++)
		{
			magazine[magazine_i] = in.next();
		}
		String ransom [] = new String [n];
		for (int ransom_i = 0; ransom_i < n; ransom_i++)
		{
			ransom[ransom_i] = in.next();
		}
		System.out.println(solve(magazine, ransom));
	}
	public static String solve(String magazine[], String ransom[])
	{
		for (int i = 0 ; i < ransom.length ; i++)
		{
			boolean match = false;
			for (int j = 0 ; j < magazine.length ; j++)
			{
				if (ransom[i].equals(magazine[j]))
				{
					magazine[j] = null;
					match = true;
					break;
				}
			}
			if ( !match)
				return "No";
		}
		return "Yes";
	}
	
}
