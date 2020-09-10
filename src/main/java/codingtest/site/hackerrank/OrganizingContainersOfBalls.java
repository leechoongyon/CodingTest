package codingtest.site.hackerrank;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author lee
 *
 *         1. Container 안에 같은 공이 들어가도록 공을 스왑하자. 2. 특정 컨테이너에 특정공이 몇개 들어있으면 가능하겠네.
 */

public class OrganizingContainersOfBalls
{
	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);
		int q = in.nextInt();
		for (int i = 0; i < q; i++)
		{
			int n = in.nextInt();
			int container[] = new int[n];
			int ballType[] = new int[n];
			for (int k = 0; k < n; k++)
			{
				for (int j = 0; j < n; j++)
				{
					int x = in.nextInt();
					container[k] += x;
					ballType[j] += x;
				}
			}
			System.out.println(solve(container, ballType));
		}
	}

	public static String solve(int container[], int ballType[])
	{
		Arrays.sort(container);
		Arrays.sort(ballType);
		if (Arrays.equals(container, ballType))
			return "Possible";
		else
			return "Impossible";
	}
}
