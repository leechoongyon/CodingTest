package codingtest.site.algospot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @file		algospot.QUANTIZE.java
 * @filetype	java source file
 * @brief
 * @author		lee
 * @version		0.1
 * @history
 * 버전			성명			일자			변경내용
 * 0.1			lee		2015. 9. 29.		신규작성
 
 
예제 입력

2
10 3
3 3 3 1 2 3 2 2 2 1
9 3
1 744 755 4 897 902 890 6 777

1
10 3
3 3 3 1 2 3 2 2 2 1

1 1 2 2 2 2 3 3 3
1 4 6 744 755 777 890 897 902

예제 출력

0
651
 
입력의 첫 줄에는 테스트 케이스의 수 C (1 <= C <= 50)
각 테스트 케이스의 첫 줄에는 수열의 길이 N (1 <= N <= 100), 
사용할 숫자의 수 S (1 <= S <= 10) 이 주어진다. 

 
 문제 : 수열과 S가 주어질 때, 가능한 오차 제곱의 합의 최소값을 구하는 프로그램을 작성
 
 
 알고리즘 :
 
 1) 완전탐색으로 맨 앞에 숫자부터 재귀로 호출하여 최소 오차를 찾아내는 방식
    quantize(a) = a 이런식이 되겠지. 이렇게 진행을 한다면 나누는 숫자가 정해져있기에 숫자를 초과해버린다.
      즉, S를 넣어야된다는거지.
    quantize(a, s) 이런식으로 현재까지 사용한 s를 재귀호출
    cache를 cache[start][s] 로 사용한건 둘 다 재귀에 사용되는 값이며, 이 값에 따라 그 구간의 min  값이 결정되기 때문이다.
     그리고 minError 의 식을 증명해야하는게 그 구간의 최소 값을 구해야하는 것이기에 미분 값을 구한 것이다.
     이렇게 오차를 구하는 과정까지 어떻게 조금씩 접근해야 도달할 수 있는지 생각해야한다. 반드시
 
 2) 내가 생각을 못한 점
 
 	종료조건을 
 	
 	if (start == N || s == 0)
		{
			if (start != N || s != 0)
				return INF;
			else
				return 0;
		}
		
		
	이렇게 걸었는데 if (start == N) 이렇게만 걸어도 된다.
			  if (s == 0) return INF;
	
   3) 캐쉬의 크기는 입력 값의 제한에 따라 (1 ~ 100) ( 1 ~ 10) 크기 설정
			
   4) MinError 계산 시 매끄럽지 않은 부분 수정
 
   5) 왜 INF 987654321 일까?
 
 */

public class QUANTIZE 
{
	private static int progression[];
	private static int N;
	private static int S;
	private static int cache[][] = new int[101][11];
	private static final int INF = 987654321;
	
	public static void main(String[] args) throws IOException 
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int cNum = Integer.parseInt(br.readLine().trim());
		int res[] = new int[cNum];
		for (int i = 0 ; i < cNum ; i++)
        {
			st = new StringTokenizer(br.readLine().trim(), " ");
			N = Integer.parseInt(st.nextToken());
			S = Integer.parseInt(st.nextToken());
			progression = new int[N];
			st = new StringTokenizer(br.readLine().trim(), " ");
			for (int j = 0 ; j < N ; j++)
				progression[j] = Integer.parseInt(st.nextToken());
			Arrays.sort(progression);
			for (int j = 0 ; j < 101 ; j++)
				Arrays.fill(cache[j], -1);
			res[i] = solve(0, S);
        }
		
		for (int k = 0 ; k < cNum ; k++)
			System.out.println(res[k]);
	}
	
	private static int solve(int start, int parts)
	{
		if (start == N)	return 0;
		if (parts == 0) return INF;
		
		if (cache[start][parts] != -1)
			return cache[start][parts];
		
		int ret = INF;
		
		for (int size = 1 ; start + size <= N ; size++)
			ret = Math.min(ret, MinError(start, start + size) + solve(start + size , parts-1));
	
		return cache[start][parts] = ret;
	}
	
	private static int MinError(int start, int end)
	{
		float sum = 0;
		for (int i = start ; i < end ; i++)
			sum += progression[i];
		
		int num = Math.round(sum / (end - start));
		
		int ret = 0;
		for (int i = start ; i < end ; i++)
		{
			int error = Math.abs(progression[i] - num);
			ret += error * error;
		}
		return ret;
	}
}
