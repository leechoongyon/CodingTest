package codingtest.site.codingInterview.arrayAndString;

import java.util.Scanner;

public class Problem1f
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		String str = scan.next();
		
		System.out.println(solve1(str));
	}
	
	private static String solve(String str)
	{
		/**
		 * brute force
		 */
		
		StringBuffer sb = new StringBuffer();
		char chars[] = str.toCharArray();
		char temp = str.charAt(0);
		int cnt = 1;
		for (int i = 1 ; i < str.length() ; i++)
		{
			if (temp == chars[i])
				cnt++;
			else
			{
				sb.append(temp).append(cnt);
				temp = chars[i];
				cnt = 1;
			}
		}
		sb.append(temp).append(cnt);
		return sb.toString().length() > str.length() ? str : sb.toString();
	}
	
	private static String solve1(String str)
	{
		char chars[] = str.toCharArray();
		StringBuffer sb = new StringBuffer();
		int consecutiveCnt = 0;
		for (int i = 0 ; i < str.length() ; i++)
		{
			consecutiveCnt++;
			if (i+1 >= str.length() || str.charAt(i) != str.charAt(i+1))
			{
				sb.append(str.charAt(i));
				sb.append(consecutiveCnt);
				consecutiveCnt = 0;
			}
		}
		return sb.length() > str.length() ? str : sb.toString();
	}
}
