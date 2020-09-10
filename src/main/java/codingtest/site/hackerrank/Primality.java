package codingtest.site.hackerrank;

import java.util.Scanner;

/**
 * @author lee
 *	
 * @desc 1과 자기 자신으로 나뉘는 수를 Prime 이라 한다.
 * ex) 1 - 1 (Not prime)
 *     2 - 1,2 (Prime)
 *     6 - 1,2,3,6 (Not prime)
 *     		
 * 원하는 답은 시간복잡도가 O(루트 n) 이거나 / 정렬 알고리즘이 O(n)	
 */

public class Primality
{
	public static void main(String [] args)
	{
		 Scanner in = new Scanner(System.in);
	     int p = in.nextInt();
	     for (int pItr = 0 ; pItr < p ; pItr++)
	     {
	    	 int n = in.nextInt();
	    	 String result = solve(n);
	    	 System.out.println(result);
	     }
	}
	
	public static String solve(int n)
	{
		// result : Not prime or Prime
		/**
		 * 12가 들어왔어. Prime 인지 어떻게 판단할까?
		 * 
		 * 솔루션 1. 
		 * 2부터 12까지 하나씩 나눠보기.
		 * 이러면 O(n) 임. 들어오는 수는 n 개일테니 최종 시간복잡도는 O(n의 2승)
		 * B : 병목으로 따지면 for 문이 2번 돈다는거. 			  
		 * U : 하나라도 자기자신 이외의 값이 나오면 break. 물론 마지막에 답이 나오면 시간복잡도는 그대로
		 * 		불필요한 작업인 2~n까지 하는게 아니라 n에 루트를 씌움으로써 n의 횟수를 루트 n만큼 줄임.
		 * 
		 * 
		 */
		
		if (n == 1)
			return "Not prime";
		else
		{
			int l = (int) Math.sqrt(n);
			for (int i = 2 ; i <= l ; i++)
			{
				if (n % i == 0)
					return "Not prime";
			}
		}
		return "Prime";
	}
}
