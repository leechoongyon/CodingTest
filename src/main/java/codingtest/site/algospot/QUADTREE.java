package codingtest.site.algospot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @file		algospot.QUADTREE.java
 * @filetype	java source file
 * @brief
 * @author		lee
 * @version		0.1
 * @history
 * 버전			성명			일자			변경내용
 * 0.1			lee		2015. 9. 7.		신규작성
 * 1. 상하로 뒤집기.
 * 2. 압축하기. 

예제 입력

4
w
xbwwb
xbwxwbbwb
xxwwwbxwxwbbbwwxxxwwbbbwwwwbb

예제 출력

w
xwbbw
xxbwwbbbw
xxwbxwwxbbwwbwbxwbwwxwwwxbbwb 


문제 : 입력이 주어졌을 때 상하 이동한 뒤 쿼드트리 압축한 것을 구해보자.

핵심 포인트 : x가 들어오면 그것을 상하 뒤집은 것을 만들어버린다.

		  따로 나누지 않고 그냥 만들어버림.

정말 잘 짠 코드다.

나는 사분면을 나누고 그것을 상하 뒤집었는데
이 소스는 사분면을 나눌 필요도 없이 그냥 만들어버림.

즉, xwbbw 같은 것은 그냥 들어오면 s3+s4+s1+s2 로 만들어짐.
문제는 xxbwwbbbw 와 같은 값이 들어오면 내부에서 한 번 더 상하 반전이 이루어져야한다.

x를 포착하면 s3+s4+s1+s2 인게 맞는데 s3, s4, s1, s2 안에 x가 또 들어있다면 그것을 한 번 더 reverse 하는거지.


즉, x가 있다면 그것을 사분면으로 나누어서 뒤집는 것이 재귀의 기본 틀


 *
 *
 * 
 *
 */



public class QUADTREE 
{
	private static char[] quad;
	private static int idx;
	
	public static void main(String[] args) throws IOException 
	{
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		int cNum = Integer.parseInt(stdin.readLine());
		String [] res = new String[cNum];
		for (int i = 0 ; i < cNum ; i++)
		{
			quad = stdin.readLine().toCharArray();
			idx = 0;
			res[i] = reverse();
		}
		
		for (String r : res)
			System.out.println(r);
		
	}
	
	public static String reverse()
	{
		char c = quad[idx++];
		StringBuilder sb = new StringBuilder();
		if (c == 'x')
		{
			String s1 = reverse();
			String s2 = reverse();
			String s3 = reverse();
			String s4 = reverse();
			sb.append("x").append(s3).append(s4).append(s1).append(s2);
		}
		else
			sb.append(c);
		
		return sb.toString();
	}
}
