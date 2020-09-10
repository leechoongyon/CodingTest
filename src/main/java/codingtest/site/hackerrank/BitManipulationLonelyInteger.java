package codingtest.site.hackerrank;

import java.util.Scanner;

/**
 * @author lee
 *
 *	1. A = {a1, a2, a3, ..., an} 중 1개만 유일 값
 *	2. 나머지는 pairs 를 이룸.
 *	3. 유일 값을 찾아라.
 *
 *	XOR : 2개의 주어진 명제 가운데 1개만 참인 것을 고름.
 *	같은게 나오면 0이되고 오직 1가지 비트만 켜질테니 1가지 비트만 켜진 
 */
public class BitManipulationLonelyInteger
{
	public static void main(String [] args)
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for (int idx = 0 ; idx < n ; idx++)
		{
			int x = sc.nextInt();
			arr[idx] = x;
		}
		System.out.println(lonelyInteger(arr));
	}
	
	public static int lonelyInteger(int arr[])
	{
		int value = 0;
		for (int i : arr)
		{
			value ^= i;
		}
		return value;
	}
}
