package codingtest.site.etc;

import java.util.Scanner;

/**
 * @author lee

주어진 십진수를 계속 해서 2로 나눔. 나머지가 이진수임.

 */
public class ConvertDecimalNumToBinaryNum
{
	public static void main(String [] args)
	{
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		StringBuilder sb = new StringBuilder();
		/** 2로 계속 나누다 보면 무조건 1이 나옴. */
		while (n != 1)
		{
			sb.append(n % 2);
			n /= 2;
		}
		sb.append(n);
		System.out.println(sb.reverse());
	}
}
