package codingtest.site.algospot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @file		algospot.JLIS.java
 * @filetype	java source file
 * @brief
 * @author		lee
 * @version		0.1
 * @history
 * 버전			성명			일자			변경내용
 * 0.1			lee		2015. 9. 23.		신규작성
 *
 *
예제 입력

3
3 3
1 2 4
3 4 7
3 3
1 2 3
4 5 6
5 3
10 20 30 1 2
10 20 30

예제 출력
5
6
5
 
 *
 *	핵심
 *	A, B 인덱스의 [0] 번째를 Min.Value로 설정해둠.
 *	이렇게 하는 이유는 A, B를 둘 다 비교할 때 가장 작은 부분을 먼저 비교하기 위해 이렇게 하는 것임.
 *	예를 들면,
 *	4,5,6
 *`	1,2,3 인데 아래 로직을 타면 먼저 4,5,6이 찍힐 것이다.
 *	4,5,6이 끝난 뒤에 1,2,3이 돌텐데 이 때, 1,2,3 돌고 4,5,6이 돌아서 최종 답이 나오는 형태임.
 *	cache는 [n][m] 으로 설정해서 각 인덱스의 값을 가져옴.
 */
public class JLIS 
{
	private static int A[];
	private static int B[];
	private static int cache[][];
	private static int n;
	private static int m;
	
	public static void main(String[] args) throws IOException 
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
        int cNum = Integer.parseInt(br.readLine().trim());
        int res[] = new int[cNum];
        for (int i = 0 ; i < cNum ; i++)
        {
        	st = new StringTokenizer(br.readLine().trim(), " ");
        	n = Integer.parseInt(st.nextToken());
        	m = Integer.parseInt(st.nextToken());
        	n++; m++;
        	A = new int[n];
        	A[0] = Integer.MIN_VALUE;
        	st = new StringTokenizer(br.readLine().trim(), " ");
        	for (int j = 1 ; j < n ; j++)
        		A[j] = Integer.parseInt(st.nextToken());
        	
        	B = new int[m];
        	B[0] = Integer.MIN_VALUE;
        	st = new StringTokenizer(br.readLine().trim(), " ");
        	for (int k = 1 ; k < m ; k++)
        		B[k] = Integer.parseInt(st.nextToken());

        	cache = new int[n][m];
        	for (int c = 0 ; c < n ; c++)
        		for (int d = 0 ; d < m ; d++)
        			cache[c][d] = -1;
        	
        	res[i] = solve(0,0);
        }
        
        for (int i = 0 ; i < cNum ; i++)
        	System.out.println(res[i]);
	}
	
	private static int solve(int a, int b)
	{
		if (cache[a][b] != -1)
			return cache[a][b];
		
		int ret = 2;
		int max = Math.max(A[a], B[b]);
		
		for (int nextA = a + 1 ; nextA < n ; nextA++)
			if (A[nextA] > max)
				ret = Math.max(ret, solve(nextA,b) + (a == 0 ? 0:1));
		
		for (int nextB = b + 1 ; nextB < m ; nextB++)
			if (B[nextB] > max)
				ret = Math.max(ret, solve(a, nextB) + (b == 0 ? 0:1));
		
		cache[a][b] = ret;
		return cache[a][b];
	}
}
