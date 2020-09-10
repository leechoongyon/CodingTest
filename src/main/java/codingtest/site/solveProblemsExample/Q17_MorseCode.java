package codingtest.site.solveProblemsExample;

import java.util.ArrayList;

/**
 * @author	: 2013BWG-02
 * @date	: 2014. 9. 22.
 * @desc	:
 * // 전체갯수가 (n+m) C  (n)  인 이유는 장점 n개, 단점 m개 에서 
// n+m에서 n개를 선택해서 줄세우면 되기 때문이다. 
// 즉, n=m=4라고 하면 8개의 의자에 남자 4명을 앉히는 것과 똑같다. 즉, 8P4인데 남자 4명은 동일한 성별이므로 4!을 나눠주면 8C4를 구하는것과 같지. 즉, 순서에 상관없이 8명중 4명을 뽑는것이지.
// 문제에서 설명한 맨앞이 장점이면 뒤에 나올수 있는 가짓수는 n+m-1 개의 의자중 n-1개의 장점을 선택하는 이항계수
	가짓수이다.

// 밑에꺼 설명
// 처음 무조건 장점이 와야됨. 장점이 단점보다 작기때문에 장점 하나가 오면 n+m-1 C n-1 가 나머지 가짓수고
// 처음 단점이 오면 n+m-1 C n 이 나머지 가짓수겠지. 
// 이 때, 장점과 단점의 순서가 없다면 이 식은 의미가 없다. 순서구분이 없으므로.
// 처음 조건인 skip < bino2(n+m+1, n-1) 이면 계속해서 장점을 넣어주고 skip보다 작은순간
// 단점에서는 해당 skip - bino2(n+m+1, n-1) 만큼만 줘버리면 나머지 단점이 맨앞에 있을 때 나머지 가짓수들을 구할수 있겠지. 

// 이 재귀 호출의 핵심은 장점이 순서대로 오다가 skip이 나머지 가짓수보다 크다고 판단되는순간 
// 장점이 오는 대신 단점이 오고 skip만큼 넘어가는거지. 즉, 장점이 오면 뒤에 가짓수만큼 계산하는 중간과정을 없애버리고
// 미리 단점이 와서 뒤에 중간과정을 없애는게 이 알고리즘의 핵심이다. 정말 좋은 알고리즘이다.
// 중간과정을 생략해버리네.
// 그렇게 중간과정을 생략하고 다시 장점이 오나 단점이 오나 조건을 달고 skip만큼 빼주고 재귀로 돌리다보면 답나옴.

 */
public class Q17_MorseCode 
{
	// 이 문제를 좀 변형해보면 결국 1이 단점, 2가 장점이 되며, 정렬된 순서대로 순열을 돌리는 것이다. 단, 중복은 
		// 않는다. 이렇게 간단히 개념을 변경해 모스코드 k번째를 구할 수 있다.

		

		static int morseCode[] = {1,1,2,2};
		static int k = 3; // k는 내가 찾고자하는 morseCode 순서
		static int tempCount = 0;
		static int n = 4;

		public static void main(String[] args)
		{
			ArrayList<Integer> picked = new ArrayList<Integer>();
			boolean isPick[] = new boolean[10];

			new Q17_MorseCode().findMorseCodeOrder(picked, isPick);
		}
		
		public void findMorseCodeOrder(ArrayList<Integer> picked, boolean isPick[])
		{
			if(picked.size() == n)
			{
				tempCount++;
				if(tempCount == k)
					System.out.println(picked);
				return ;
			}

			for(int next = 0 ; next < n ; next++)
			{
				if(isPick[next])
					continue;
				picked.add(morseCode[next]);
				isPick[next] = true;

				findMorseCodeOrder( new ArrayList<Integer>(picked), isPick);

				picked.remove(picked.size() - 1);
				isPick[next]  = false;
			}

		}
}
