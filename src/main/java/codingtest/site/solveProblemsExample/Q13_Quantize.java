package codingtest.site.solveProblemsExample;

/**
 * @author	: 2013BWG-02
 * @date	: 2014. 8. 9.
 * @desc	: 내가 이 문제에 잘못 접근한점은 평균에 평균을 정의하고 그것이 반드시 답이라고 검증안된 가정을 해서

			     틀린것이다. 1가지 답이 아니라 모든 경우를 다 비교해봐야지.
 */
public class Q13_Quantize 
{
	static int num[] = {1,2,3,4,5,500,510,520,530,540,550};
	static int cache[][] = new int[10][10];
	static int INF = 987654321;
	
	public static void main(String[] args)
	{
		int n = 2; 	//나눌 묶음 수
		
		int minErrorValue = 0;
		
		minErrorValue = new Q13_Quantize().quantize(0, n);
		
		System.out.println("minErrorValue : " + minErrorValue);
	}

	
	// from : start Index, parts : divide num Value
	public int quantize(int from, int parts)
	{
		if(from == num.length)
			return 0;
		if(parts == 0) return INF;
		
		if(cache[from][parts] != 0)
			return cache[from][parts];
		
		cache[from][parts] = INF;
		
		for(int partSize = 1 ; from + partSize <= num.length ; partSize++)
			cache[from][parts] = Math.min(cache[from][parts], minError(from, from + partSize -1 ) + quantize(from + partSize, parts - 1));
		
		return cache[from][parts];
			

	}

	public int minError(int start, int end)
	{	
		// num[start] ~ num[end]의 평균을 구하고 해당 평균을 통해 오차를 구하기.
		//그래서 그 오차를 return으로 넘겨주기.

		int sum = 0;
		int minError = 0;
		
		for(int i = start; i <= end ; i++)
			sum += num[i];
		
		sum = sum / (end - start + 1);
		
		
		for(int i = start ; i <= end ; i++)
			minError += Math.pow(Math.abs(num[start] - sum), 2);
		
		
		
		return minError;
	}

	public int searchPartRange(int start, int end, int n)
	{
		//Get Range
		//start, end index is needed to part range condition

		//test case example 
		//new Q13().searchPartRange(0, num.length - 1); 

		if(n == 1)
			return (end+1);
		
		int range = (num[end] - num[start]) / n;

		for(int i = start ; i < end ; i++)
			if(num[i] > range)
				return i;

		// return 0 means num array final index		

		return 0;
	}

}
