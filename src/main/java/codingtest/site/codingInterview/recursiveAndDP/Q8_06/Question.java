package codingtest.site.codingInterview.recursiveAndDP.Q8_06;

import java.util.Stack;

public class Question
{
	public static void main(String[] args)
	{
		Stack<Integer> src = new Stack<Integer>();
		Stack<Integer> buffer = new Stack<Integer>();
		Stack<Integer> dest = new Stack<Integer>();
		
		src.add(3);
		src.add(2);
		src.add(1);
		
		hanoi(3, src, buffer, dest);
		System.out.println(dest);
	}
	
	public static void hanoi(int n, Stack<Integer> src, Stack<Integer> buffer, Stack<Integer> dest)
	{
		/**
		 * 	하노이는 대표적인 재귀 호출 문제이다.
		 * 
		 * 	1. f(1) = src --> dest
		 * 	2. f(2) = src(1) --> buffer(1)
		 * 			  src(2) --> dest(2)
		 * 			  buffer(1) --> dest(2)
		 * 	3. f(3) = src(1~2) --> buffer(1~2)
		 * 			  src(3) --> dest(3)
		 * 			  buffer(1~2) --> dest(3)
		 * 
		 * 	과정을 구하는 것이기에 메모라이제이션 사용 어려움.
		 */
		
		if (n == 1) dest.add(src.pop());
		else
		{
			hanoi(n-1, src, dest, buffer);
			dest.add(src.pop());
			hanoi(n-1, buffer, src, dest);
		}
			
	}
}
