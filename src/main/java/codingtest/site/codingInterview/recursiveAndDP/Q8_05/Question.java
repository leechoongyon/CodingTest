package codingtest.site.codingInterview.recursiveAndDP.Q8_05;

public class Question
{
	private static int cache[] = new int[5 + 1];
	
	public static void main(String[] args)
	{
		for (int i = 0 ; i < cache.length ; i++)
			cache[i] = Integer.MIN_VALUE;
		
		System.out.println(multiply(5,5));
	}
	
	public static int multiply(int a, int b)
	{
		int smaller = a < b ? a : b;
		int bigger = a < b ? b : a;
		return multiplyInternal(smaller, bigger);
	}
	
	public static int multiplyInternal(int smaller, int bigger)
	{
		/**
		 * 	곱하기를 셀의 개수를 세는 문제로 변환
		 * 
		 * 	1. 절반을 나눈다.
		 * 		1.1 side1, side2 라고 가정했을 때, 셀의 row 가 짝수면
		 * 			side1 = side2 이다.
		 * 		1.2 smaller 가 홀수라면, side1 과 side2 는 같지 않다.
		 * 		1.3 그러하기에 side2 는 별도로 구해야 함.
		 */
		
		if (cache[smaller] != Integer.MIN_VALUE) return cache[smaller];
		
		/** 기저 사례 */
		if (smaller == 0) return 0;
		else if (smaller == 1) return bigger;
		
		int s = smaller >> 1;
		int side1 = multiplyInternal(s, bigger);
		int side2 = side1;
		
		if (smaller % 2 == 1)
			side2 = multiplyInternal(smaller - s, bigger);
		
		return (cache[smaller] = side1 + side2);
		
	}
}
