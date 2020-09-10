package codingtest.site.solveProblemsExample;

public class Q9_LIS 
{
	int cache[] = new int[10];
	static int input[] = {1,3,2,8,5,6,7};
	static int choices[] = new int[10];
	
	
	public static void main(String[] args) 
	{
		new Q9_LIS().init();
		new Q9_LIS().start();
		new Q9_LIS().reconstruct();
	}
	
	
	public void init()
	{
		for(int i = 0 ; i < choices.length ; i++)
			choices[i] = -1;
	}
	
	public void start()
	{
		int max = 0;
		
		for(int i = 0 ; i < input.length ; i++)
			max = Math.max(max, Lis(i));
		
		System.out.println("MaxDistance : " + max);
	}
	
	
	
	/**
	 * @param start
	 * @desc :
	 * 중요 핵심은 경로를 일일이 다 저장하는 것이 아니라 경로 1개를 +1이라 보고 이를 +1시켜서 재귀호출을 해서 끝까지 도달하게 하는 것이 이 알고리즘의 핵심이다.
	 * 
	 */
	public int Lis(int start)
	{
		
		if(cache[start] != 0) return cache[start];
		
		cache[start] = 1;
		
		for(int next = start + 1 ; next < input.length ; next++)
		{
			// 이 부분이 중요. cache[start]는 최소 길이 1을 가지고 있고, 1 + Lis(next)를 통해 배열의 끝을 향해 달림. 그래서 for문이 끝나는 곳이 배열의 끝이며, 이를 cache[start]에 담아서 
			// Lis(next)가 끝에 도달하면 +1 씩 계속 리턴해주기 때문에 결국 cache[start]는 커지게 되어 있다.
			
			if(input[start] < input[next])
			{
				int cand = Math.max(cache[start], 1 + Lis(next));
				if(cand > cache[start])
				{
					cache[start] = cand;
					choices[start] = next;
				}
			}
				
		}
		
		return cache[start];
	}
	
	public void reconstruct()
	{
		/*for(int i = 0 ; i < choices.length ; i++)
		{
			if(choices[i] != -1)
				System.out.println(choices[i]);
			else
				break;
		}*/
	}
}
