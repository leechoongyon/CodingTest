package codingtest.site.codingInterview.recursiveAndDP.Q8_09;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Question
{
	public static void main(String [] args)
	{
		Set<String> set = solve(3);
		System.out.println(set);
	}
	
	public static Set<String> solve(int n)
	{
		Set<String> set = null;
		for (int i = 1 ; i <= n ; i++)
		{
			set = internalSolve(set);
		}
		return set;
	}
	
	public static Set<String> internalSolve(Set<String> temp)
	{
		/**
		 * 	1. f(n) = f(n-1) * 괄호를 집어넣음.
		 * 	2. f(1) ~ f(n) 순차적으로 누적 계산
		 * 	3. 중복 제외하는 법은 나중에 풀어보자.
		 */
		
		/** 기저 사례 */
		Set<String> result = new HashSet<String>();
		if (temp == null) return new HashSet<String>(Arrays.asList(new String("()")));
		for (String s : temp)
		{
			for (int i = 0 ; i < s.length() ; i++)
			{
				StringBuilder sb = new StringBuilder()
						.append(s.substring(0, i))
						.append("()")
						.append(s.substring(i, s.length()));
				result.add(sb.toString());
			}
		}
		return result;
	}
}
