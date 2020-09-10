package codingtest.site.hackerrank;

import java.util.Scanner;

/**
 * @author USER
 * @desc 
 * 	1. n 개의 수가 나옴.
 * 	2. 각 n개의 수마다 가운데 숫자를 구한다.
 * 
 * ex) 12, 4, 5, 3, 8 ,7 이면
 *     처음엔 12.0
 *     두번째는 4, 12 짝수니 (4+12) / 2 = 8.0
 *     세번째는 4,5,12 홀수니 5
 *     ...
 *     ... 
 */
public class FindTheRunningMedian
{
	public static void main(String[] args)
	{
		 Scanner in = new Scanner(System.in);
	     int n = in.nextInt();
	     int arr[] = new int[n];
	     for (int i = 0 ; i < n ; i++)
	     {
	    	 arr[i] = in.nextInt();
	    	 solve(arr);
	     }
	}
	
	/**
	 * @param arr
	 * 
	 * sol1 brute force 로 풀면 정렬하는데 O(n) 이 걸림.
	 *  
	 */
	public static void solve(int arr[])
	{
		
	}
}
