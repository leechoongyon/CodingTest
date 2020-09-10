package codingtest.site.codingInterview.arrayAndString;

import java.util.Scanner;

public class Problem1e
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		String a1 = scan.next();
		String a2 = scan.next();
		
		System.out.println(solve(a1, a2));
	}
	
	private static boolean solve(String a1, String a2)
	{
		int a1Length = a1.length();
		int a2Length = a2.length();
		
		if (a1Length == a2Length)
		{
			return oneReplace(a1, a2);
		}
		else if (a1Length - a2Length == 1)
		{
			return oneInsert(a2, a1);
		}
		else if (a1Length - a2Length == -1)
		{
			return oneInsert(a1, a2);
		}
		return false;
	}
	
	private static boolean oneReplace(String a1, String a2)
	{
		int diff = 0;
		for (int i = 0 ; i < a1.length() ; i++)
		{
			if (a1.charAt(i) != a2.charAt(i))
			{
				diff++;
			}
			if (diff >= 2)
			{
				return false;
			}
		}
		return true;
	}
	
	private static boolean oneInsert(String a1, String a2)
	{
		int index1 = 0;
		int index2 = 0;
		
		while(index1 < a1.length() && index2 < a2.length())
		{
			if (a1.charAt(index1) != a2.charAt(index2))
			{
				if (index1 != index2)
					return false;
				index2++;
			}
			else
			{
				index1++;
				index2++;
			}
		}
		return true;
	}
}
