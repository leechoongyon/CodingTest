package codingtest.site.etc;

import java.util.Scanner;

public class ConvertDecimalNumToNDecimal
{
	public static void main(String [] args)
	{
		Scanner scan = new Scanner(System.in);
		/** 숫자 */
		int n = scan.nextInt();
		/** n 진수*/
		int number = scan.nextInt();
		
		System.out.println(solve(n, number));
	}
	
	public static String solve(int n, int number)
	{
		StringBuilder sb = new StringBuilder();
		int temp; 
		/** 
		 * 	4 를 2로 계속 나눈다고 해보자.
		 *	4 % 2 = 0 , 2 % 2 = 0, 1 % 2 = 1 
		 *	이렇게 쭉 나누다보면 0으로 바뀔 때가 멈출 때임.
		 */
		while (n != 0)
		{
			if (number < 10)
			{
				sb.append(n % number);
				n /= number;
			}
			else
			{
				temp = n % number;
				if (temp >= 10)
				{
					switch(temp)
					{
						case 10:
							sb.append("A");
							break;
						case 11:
							sb.append("B");
							break;
						case 12:
							sb.append("C");
							break;
						case 13:
							sb.append("D");
							break;
						case 14:
							sb.append("E");
							break;
						case 15:
							sb.append("F");
							break;
					}
				}
				else
					sb.append(temp);
				n /= number;
			}
		}
		return sb.reverse().toString();
	}
}
