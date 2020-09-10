package codingtest.site.codingInterview.arrayAndString;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Problem1d
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		String str = scan.next();
		
		solve(str);
	}
	
	private static void solve(String str)
	{
		/**
		 * 길이 짝수, 홀수 구분
		 */
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (char c : str.toCharArray())
		{
			if (map.containsKey(c))
				map.put(c, map.get(c) + 1);
			else
				map.put(c, 1);
		}
		
		if (str.length() % 2 == 0)
		{
			for (int value : map.values())
			{
				if (value % 2 != 0)
				{
					System.out.println("Not palindrome.");
					return ;
				}
			}
		}
		else
		{
			int oddNumCount = 0;
			for (int value : map.values())
			{
				if (value % 2 != 0)
					oddNumCount++;
				if (oddNumCount > 1)
				{
					System.out.println("Not palindrome.");
					return ;
				}
			}
		}
		System.out.println("palindrome.");
	}
}
