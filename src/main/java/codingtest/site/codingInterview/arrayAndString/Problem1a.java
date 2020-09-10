package codingtest.site.codingInterview.arrayAndString;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Problem1a
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		String str = scan.next();
		
//		solveIfAscii(str);
		solveIfUnicode(str);
	}
	
	/**
	 * - ASCII 일경우 총 127 이기에, 정해진 수 안에서 해결
	 *   (참고로 자바는 UNICODE 이지만, 앞자리는 아스키 코드와 같다.)
	 */
	
	private static void solveIfAscii(String str)
	{
		boolean mark[] = new boolean[127];
		for (char c : str.toCharArray())
		{
			int idx = (int) c;
			if (mark[idx] == true)
			{
				System.out.println("Duplicate word : " + c);
				return ;
			}
			else
				mark[idx] = true;
		}
	}
	
	private static void solveIfUnicode(String str)
	{
		Set<Character> set = new HashSet<Character>();
		for (char c : str.toCharArray())
		{
			boolean isNotConflict = set.add(c);
			if ( !isNotConflict)
			{
				System.out.println("Duplicate word : " + c);
				return ;
			}
		}
	}
	
}
