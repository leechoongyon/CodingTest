package codingtest.site.hackerrank;

import java.util.Scanner;

/**
 * @author lee
 *
 *	1. 한 사람이 최대 두 사람에게 뇌물을 줄 수 있다.
 *	2. 처음 상태에서 입력 값 상태로 변경할 수 있는 최소 뇌물 값이 얼마인지 구하라.
 */
public class NewYearChaos
{
	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		
		for (int i = 0 ; i < t ; i++)
		{
			int n = in.nextInt();
			int arr[] = new int[n];
			for (int j = 0 ; j < n ; j++)
			{
				arr[j] = in.nextInt();
			}
			int ans = solve(arr);
			if (ans == 0)
				System.out.println("Too chaotic");
			else
				System.out.println(ans);
		}
	}
	
	/**
	 * 
	 * 1. brute force 로 푸는법
	 * 
	 * Sol 1. 
	 * 	1. 끝에서부터 Too chaotic 찾기
	 * 	2. 끝에서부터 앞에 있는 애를 몇 번 넘어야 하는지 체크
	 * 	 
	 * 
	 * @param arr
	 * @return
	 */
	
	public static int solve(int arr[])
	{
		int ans = 0;
		for (int i = arr.length - 1 ; i >= 0 ; i--)
		{
			if (arr[i] - (i + 1) > 2)
			{
				return 0;
			}
			for (int j = Math.max(0, arr[i] - 2) ; j < i ; j++)
			{
				if (arr[j] > arr[i]) ans++;
			}
		}
		return ans;
	}
}
