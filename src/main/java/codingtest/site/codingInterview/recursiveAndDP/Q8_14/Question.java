package codingtest.site.codingInterview.recursiveAndDP.Q8_14;

import java.util.HashMap;
import java.util.Map;

public class Question
{
	private static Map<String, Integer> cache = new HashMap<String, Integer>();
	public static void main(String [] args)
	{
		System.out.println(countEval("1^0|0|1", false));
		System.out.println(countEval("0&0&0&1^1|0", true));
	}
	
	/**
	 *	1. 부분문제로 나누어서 풀기.
	 *		1.1 부분문제로 나눈다는 것은 연산자를 기준으로 나눠야 함.
	 *	2. 나눈 부분문제들을 계산하는 방식은 연산자와 result 에 따라 case by case
	 *		2.1 &, |, ^ 와 result 가 true, false 에 따라 다름.
	 *		2.2 result 가 true 이고, 연산자가 & 이면, leftTrue * rightTrue
	 *	3. 위와 같이 연산자와 result 에 따라 count 하는 방식이 달라짐. 
	 *		3.1 boolean 이 true 일 때와 false 일 때가 달라짐.
	 *	4. 위 문제를 치환한다면 이렇게 생각할 수 있음. 전체 total 경우의 수를 구하고,
	 *		true 의 경우의 수를 구함. result 가 true 이면, true return. result 가 false 이면,
	 *		total 에서 true 경우의 수를 빼줌.
	 *	5. memorization 은 중복되는 것에 적용.
	 *	 
	 */
	public static int countEval(String regex, boolean result)
	{
		int ways = 0;
		int subWays = 0;
		
		/** 기저 사례 */
		if (regex.length() == 0) return 0;
		else if (regex.length() == 1) return stringToBoolean(regex) == result ? 1 : 0;
		
		/** memorization */
		if (cache.containsKey(result + regex))
			return cache.get(result + regex);
		
		for (int i = 1 ; i < regex.length() ; i+=2)
		{
			char operation = regex.charAt(i);
			String left = regex.substring(0, i);
			String right = regex.substring(i+1);
			int leftTrue = countEval(left, true);
			int leftFalse = countEval(left, false);
			int rightTrue = countEval(right, true);
			int rightFalse = countEval(right, false);
			
			int leftTotal = leftTrue + leftFalse;
			int rightTotal = rightTrue + rightFalse;
			/** 각각의 경우의 수를 곱하면 모든 경우의 수가 나옴. */
			int total = leftTotal * rightTotal;
			
			if (operation == '^')
				subWays = leftTrue * rightFalse + leftFalse * rightTrue;
			else if (operation == '&')
				subWays = leftTrue * rightTrue;
			else if (operation == '|')
				subWays = leftTrue * rightFalse + leftTrue * rightTrue + leftFalse * rightTrue;
				
			ways += result == true ? subWays : total - subWays;
			cache.put(result+regex, ways);
		}
		return ways;
	}
	
	public static boolean stringToBoolean(String a)
	{
		return "1".equals(a);
	}
}
