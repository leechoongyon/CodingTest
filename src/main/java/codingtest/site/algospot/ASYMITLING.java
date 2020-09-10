package codingtest.site.algospot;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @file		algospot.ASYMITLING.java
 * @filetype	java source file
 * @brief
 * @author		lee
 * @version		0.1
 * @history
 * 버전			성명			일자			변경내용
 * 0.1			lee		2015. 10. 7.		신규작성
 *
 *
 
예제 입력
3
2
4
92

예제 출력
0
2
913227494
 

각 테스트 케이스마다 한 줄에 비대칭 타일링 방법의 수를 1,000,000,007 로 나눈 나머지를 출력합니다.

 *
 */
public class ASYMITLING 
{
	private static int cache[] = new int[101];
	private static int n;
	private static List<Integer> picked = new ArrayList<Integer>();
	
	public static void main(String[] args) throws Exception 
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cNum = Integer.parseInt(br.readLine().trim());
		int res[] = new int[cNum];
		for (int i = 0 ; i < cNum ; i++)
        {
			n = Integer.parseInt(br.readLine().trim());
			Arrays.fill(cache, -1);
			res[i] = solve(0);
        }
		
		for (int i = 0 ; i < cNum ; i++)
			System.out.println(res[i]);
	}
	
	/*public static int solve(int width)
	{
		if (width <= 1)
		{
			
			return 1;
		}
		
		int ret = cache[width];
		if (ret != -1) return ret;
		
		ret = solve(width-1) + solve(width-2);
		
		return cache[width] = ret;
	}*/
	
	public static int solve(int start)
	{
		if (start == n)
		{
			if (!isBilateralSymmetry())
				return 1;
			else
				return 0;
		} 
		if (start > n) return 0;
		
		int sum = 0;
		
		for (int i = 1 ; i <= 2 ; i ++)
		{
			picked.add(i);
			sum += solve(start + i);
			picked.remove(picked.size() - 1);
		}
		
		return sum;
	}
	
	public static boolean isBilateralSymmetry()
	{
		/*System.out.println(picked);*/
		int end = picked.size();
		/*System.out.println(end);*/
		for (int i = 0 ; i < end / 2 ; i++)
		{
			if (picked.get(i) != picked.get(end - i - 1))
				return false;
		}
		return true;
	}
}
