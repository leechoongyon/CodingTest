package codingtest.site.hackerrank;

import java.util.Scanner;

/**
 * 	* 제약사항
 * 		- rows * columns >= L
 * 		- rows * columns = 최소 면적
 * 		- 루트 L 의 버림 값 <= row <= column <= 루트 L의 올림 값	
 * 
 * 	1. s 의 길이를 구함.
 * 	2. row, column 을 구함.
 * 		- row * column > 루트 s의 길이 (validate)
 *  3. 스타트 문자부터 column 만큼 출력
 *  
 *   * rows, columns 를 구하는 것이 핵심
 *   a. L 이 소숫점이 없다면, rows = columns = L 의 루트
 *   b. L 이 소숫점이 있으면 L 의 버림 정수가 rows, columns = rows + 1
 *   	- 이 때, rows * coluns >= L 이라면 columns = columns + 1
 *   
 *   
 */

public class Encryption
{
	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);
		String s = in.next();
		solve(s);
	}

	public static void solve(String s)
	{
		int len = s.length();
		double rootLen = Math.sqrt(len);
		int ip = (int) rootLen;
		double fp = rootLen - ip;

		int rows, columns = 0;

		if (fp > 0)
		{
			rows = ip;
			columns = ip + 1;
			while (rows * columns < len)
			{
				rows = rows + 1;
			}
		}
		else if (fp == 0)
		{
			rows = columns = ip;
		}

		int start = 0;
		while (start < columns)
		{
			for (int i = start; i < len; i = i + columns)
			{
				System.out.print(s.charAt(i));
			}
			start++;
			System.out.print(" ");
		}
	}
}
