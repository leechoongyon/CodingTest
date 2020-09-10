package codingtest.site.hackerrank;

import java.math.BigInteger;
import java.util.Scanner;


/**
 * @author lee
 *
 *	n 팩토리얼의 수를 구하라.
 */

public class ExtraLongFactorials
{
	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		
		BigInteger result = solve(n);
		System.out.println(result);
	}
	public static BigInteger solve(int n)
	{
		BigInteger fac = BigInteger.ONE;
		for (int i = 1 ; i <= n ; i++)
		{
			fac = fac.multiply(BigInteger.valueOf(i));
		}
		return fac;
	}
}
