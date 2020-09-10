package codingtest.site.etc;

import java.util.Scanner;

public class ConvertDecimalNumToOctalNum
{
	public static void main(String [] args)
	{
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		StringBuilder sb = new StringBuilder();
		/** 8로 계속 나누다 보면 무조건 1이 나옴. */
		while (n != 7)
		{
			sb.append(n % 8);
			n /= 8;
		}
		sb.append(n);
		System.out.println(sb.reverse());
	}
}
