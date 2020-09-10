package codingtest.site.solveProblemsExample;

/**
 * @author	: 2013BWG-02
 * @date	: 2014. 8. 10.
 * @desc	: 전체를 보면 이 문제는 2가지로 나뉜다.
 * 
 * 			  1) 처음은 최대경로를 선택하는 것
 * 			  2) 두번째는 최대경로를 택한 것에서 num[]을 출력하는 것.
 * 			
 *    		     왜 이렇게 하는가 하면 1),2)를 섞으면 복잡해지기에 따로 분리해서 짜는 것이 간결하고 직관적이기 떄문이다.
 *    		  1)에서 주의할점은 바로 cand > cache[start+1] 부분이다. cand는 for문으로 돌려서 각 열에 맞는 최대 경로수를 가져온다.
 *    		     즉, 예를 들면, start가 0이고 다음 next가 1~ 끝이면 1~끝까지중  이것들을 재귀로 돌려 끝까지 도달한 경로의수가 cand에 저장이 된느 것이고
 *    		     이 cand에 저장된 것을 기존의 cache[start+1] 이랑 비교해서 최고 경로의 수를 choices에 저장하는 방식이다.
 *    		     여기서 재밋는점은 cache[start+1]을 메모이제이션으로 사용하였는데 cache[start]로 사용해도 답은 똑같네. start를 +1시켜서 계산하느냐고 그랬을 것 같다.   
 */
public class Q15_searchLisRoute 
{
	static int num[] = {4,6,9,8,10,20,15,14,21};

	static int cache[] = new int[num.length+1];
	static int choices[] = new int[num.length+1];
	static int tempChoices[] = new int[num.length+1];

	public static void main(String[] args)
	{
		new Q15_searchLisRoute().start();
		new Q15_searchLisRoute().reconstruct(0, choices);
	}

	public void start()
	{
		int max = 0;

		int temp = 0;

		for(int i = 0 ; i < num.length ; i++)
		{
			CacheAndChoiceClear();
			temp = lis4(i);
			if(max < temp)
			{
				max = temp;
				transition();
				choices[i] = i;
			}
		}

		System.out.println("Max : " + max);
	}

	public int lis4(int start)
	{
		if(cache[start] != -1) return cache[start];
	
		cache[start] = 1;

		int baseNext = -1;

		for(int next = start + 1 ; next < num.length ; next++)
		{
			if(num[start] < num[next])
			{
				int cand = lis4(next) + 1;
				if(cand > cache[start])
				{
					cache[start] = cand;
					baseNext = next;
				}
			}
		}

		tempChoices[start+1]  =baseNext;
		return cache[start];
	}

	public void reconstruct(int start, int choices[])
	{
		for(int i = 0 ; i < choices.length ; i++)
		{
			if(choices[i] == -1 || (i != 0 && choices[i-1] == choices[i]))
				continue;
			else
				System.out.print(choices[i] + " ");
		}
	}

	public void transition()
	{
		for(int i = 0 ; i < choices.length ; i++)
			choices[i] = tempChoices[i];
	}

	public void CacheAndChoiceClear()
	{
		for(int i = 0 ; i < tempChoices.length ; i++)
		{
			cache[i] = -1;
			tempChoices[i] = -1;
		}
	}
}
