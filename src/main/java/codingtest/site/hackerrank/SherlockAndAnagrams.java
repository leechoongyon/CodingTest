package codingtest.site.hackerrank;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author lee
 *
 *	- 하나의 단어를 재조립하여 2개의 단어를 추출한다. 아나그램의 조합을 구하라.
 *	- 연속적이여야 함.
 *	- 완전히 똑같은 단어만 아니면 됨.
 *

2
ifailuhkqq
kkkk

1
ifailuhkqq

1
cdcd

 */
public class SherlockAndAnagrams
{
	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		String strArr[] = new String[n];
		for (int i = 0 ; i < n ; i++)
		{
			strArr[i] = in.next();
			System.out.println(solve(strArr[i]));
		}
	}
	
	private static int solve(String str)
	{
		Set<String> set;
		int sum = 0;
		
		// 끝까지 체크할 필요가 없기에, str.length
		int strLen = str.length();
		for (int i = 1 ; i <= strLen - 1 ; i++)
		{
			// j 는 단어의 시작부분을 의미
			for (int j = 0 ; j < strLen - i ; j++)
			{
				// set 을 사용한 이유는 비교를 쉽게 하기 위해
				set = new HashSet<String>();
				int sIdx = j;
				
				// 초기 String 을 set 에 넣는다.
				set.add(extractString(str, sIdx, sIdx + i));
				sIdx++;
				while (sIdx + i <= strLen)
				{
					if (set.contains(extractString(str, sIdx, sIdx + i)))
						sum++;
					sIdx++;
				}
			}
		}
		return sum;	
	}
	
	private static String extractString(String str, int to, int from)
	{
		String tmp = str.substring(to, from);
		char ch[] = tmp.toCharArray();
		Arrays.sort(ch);
		return new String(ch);
	}
}
