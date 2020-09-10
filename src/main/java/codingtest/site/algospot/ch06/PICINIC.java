package codingtest.site.algospot.ch06;

import java.util.Scanner;

/**
3
2 1
0 1
4 6
0 1 1 2 2 3 3 0 0 2 1 3
6 10
0 1 0 2 1 2 1 3 1 4 2 3 2 4 3 4 3 5 4 5

예제출력
1
3
4
 */

public class PICINIC
{
	private static int[][] pairs;  
	
	public static void main(String [] args)
	{
		Scanner scan = new Scanner(System.in);
		int C = scan.nextInt();
		int person, pairsNum;
		int a, b;
		for (int i = 0 ; i < C ; i++)
		{
			person = scan.nextInt();
			pairsNum = scan.nextInt();
			pairs = new int[person][person];
			for (int j = 0 ; j < pairsNum ; j++)
			{
				a = scan.nextInt();
				b = scan.nextInt();
				pairs[a][b] = pairs[b][a] = 1;
			}
			System.out.println(getPairsNum());
		}
	}
	
	private static int getPairsNum()
	{
		return 0;
	}
}
