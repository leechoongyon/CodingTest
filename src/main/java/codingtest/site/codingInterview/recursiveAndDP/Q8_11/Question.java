package codingtest.site.codingInterview.recursiveAndDP.Q8_11;

public class Question
{
	private static int cache[][] = new int[101][4];
	
	public static void main(String [] args)
	{
		int coins[] = {25,10,5,1};
		int nCent = 100;
		System.out.println(makeChange(coins, nCent));
	}
	
	public static int makeChange(int coins[], int nCent)
	{
		return makeChange(coins, nCent, 0);
	}
	
	public static int makeChange(int coins[], int remain, int index)
	{
		/**
		 * 	1. 큰 동전부터 작은 동전으로 모든 경우의 수를 계산한다.
		 * 		1.1 특정 동전의 모든 경우의 수를 순회해야 하므로 for 문 
		 * 			1.1.1 for (int i = 0 ; nCent 초과 X ; i++)
		 * 		1.2 다음 동전을 선택하기 위해 index 를 넣어줌. 
		 * 			1.2.1 만약 index 없이 for 문만을 이용한다면, 가능은 하겠는데?
		 * 			1.2.2 대신 직관적이지가 않음.
		 * 			1.2.3 index 를 넣음으로써 25 - 0, 10 - 1 등 직관적으로 이해 가능.
		 * 	2. 종료 조건
		 * 		2.1 마지막 index 까지 왔다면 그건 이미 해결된 것임.
		 * 		2.2 ex) 25-0, 10-0, 5-0, 1-100
		 * 			 	25-0, 10-0, 5-1, 1-95
		 * 	3. 최적화
		 * 		3.1 amount 와 index 에 따라 중복되는 ways 가 나옴.
		 * 		3.2 이를 memorization 하기 
		 */
		
		/** Cache */
		if (cache[remain][index] != 0) return cache[remain][index];
		/** 종료 조건 */
		if (index >= coins.length - 1) return 1;
		
		int ways = 0;
		int amount = coins[index];
		for (int i = 0 ; i * amount <= remain ; i++)
		{
			ways += makeChange(coins, remain - i * amount, index + 1);
		}
		return (cache[remain][index] = ways);
	}
}
