package codingtest.site.acmicpc;

import java.util.Scanner;

/**
 * @author lee

문제
두 정수 A와 B를 입력받은 다음, A/B를 출력하는 프로그램을 작성하시오.

입력
첫째 줄에 A와 B가 주어진다. (0 < A, B < 10)

출력
첫째 줄에 A/B를 출력한다. 절대/상대 오차는 10-9 까지 허용한다.

예제 입력 1 
1 3

예제 출력 1 
0.33333333333333333333333333333333


예제 입력 2 
4 5

예제 출력 2 
0.8

 */
public class Num1008
{
	public static void main(String [] args)
	{
		Scanner scan = new Scanner(System.in);
		double a = scan.nextDouble();
		double b = scan.nextDouble();
		System.out.println(solve(a, b));
	}
	
	public static double solve(double a, double b)
	{
		return a/b;
	}
}