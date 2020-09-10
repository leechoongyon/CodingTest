package codingtest.site.codingInterview.bitOperation.Q5_Q7;

public class Question
{	
	public static void main(String[] args)
	{
		int n = 300;
		System.out.println(Integer.toBinaryString(n));
		System.out.println(Integer.toBinaryString(bitSwap(n)));;
	}
	
	public static int bitSwap(int n)
	{
		/**
		 * 
		 * 	int 4bytes 라 가정
		 * 
		 * 	1. 짝수번째 비트들을 버퍼에 marking. marking 할 때,
		 * 		index 위치를 +1 씩 해서 marking.
		 * 		30 이 마지막 짝수.
		 * 	2. 홀수번째 비트들을 버퍼에 marking. marking 할 때,
		 * 		index 위치를 -1씩 해서 marking.
		 * 		31이 마지막 홀수
		 */
		
		int result = 0;
		
		for (int i = 0 ; i < 32 ; i+=2)
		{
			if (getBit(n,1)) result = result | (1 << i + 1);
			else result = result | (0 << i + 1);
		}
		
		for (int j = 1 ; j < 32 ; j+=2)
		{
			if (getBit(n, j)) result = result | (1 << j - 1);
			else result = result | (0 << j - 1);
		}
		
		return result;
	}
	
	public static boolean getBit(int n, int i)
	{
		return ((n & (1 << i)) != 0);
	}
}

