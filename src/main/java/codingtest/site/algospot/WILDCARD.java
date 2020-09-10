package codingtest.site.algospot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * @file		algospot.WILDCARD.java
 * @filetype	java source file
 * @brief
 * @author		lee
 * @version		0.1
 * @history
 * 버전			성명			일자			변경내용
 * 0.1			lee		2015. 9. 22.		신규작성

예제 입력
2
he?p
3
help
heap
helpp
*p*
3
help
papa
hello

예제 출력

heap
help
help
papa



1
*p*
1
hel


1
he?p
3
help
heap
helpp


주의점 : resList를 정렬해서 출력해야함.

설명 : 

1. Cache 쓰기 전 (밑에 wildCard 주석 달아놓음)

2. Cache 쓰기 (밑에 Memorization 주석 달음)

	ㄱ. wIdx, sIdx를 이용하여 캐시 설정
	    wIdx, sIdx는 w와 s의 인덱스를 지칭하며, 이를 통해 캐쉬 설정 (중복 값을 메모리를 통해 해결)

3. Pattern Match 쓰는 방법 (진짜 기가막힌다.)

 */


public class WILDCARD 
{
	private static int cache[][];
	private static String w;
	private static String s;
	
	public static void main(String[] args) throws IOException
	{
		List<String> resList = null; 
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		int cNum = Integer.parseInt(stdin.readLine());
		for (int i = 0 ; i < cNum ; i++)
		{
			w = stdin.readLine();
			int N = Integer.parseInt(stdin.readLine());
			resList = new ArrayList<String>();
			for (int j = 0 ; j < N ; j++)
			{
				s = stdin.readLine();
				
				// cache init
				cache=new int[w.length()+1][s.length()+1];

				// 1. No Memorization
				/*if(wildCard(w, fileName))
					resList.add(fileName);
				Collections.sort(resList);*/
				
				// 2. Memorization
				if (wildCardWithMemorization(0,0))
					resList.add(s);
				Collections.sort(resList);
			}
			for (int k = 0 ; k < resList.size() ; k++)
				System.out.println(resList.get(k));
		}
		
	}

	
	public static boolean wildCardWithMemorization(int wIdx, int sIdx)
	{
		// 1. cache (1 : exist, -1 : not exist)
		if (cache[wIdx][sIdx] == 1) return true;
		else if (cache[wIdx][sIdx] == -1) return false;
		
		// 2. normal pattern
		while (wIdx < w.length() && sIdx < s.length() && (w.charAt(wIdx) == '?' || w.charAt(wIdx) == s.charAt(sIdx)))
		{
			wIdx++; sIdx++;
		}
		
		// 3. stopping criteria
		if (wIdx == w.length())
		{
			cache[wIdx][sIdx] = (sIdx == s.length()) ? 1 : -1;
			return (sIdx == s.length());
		}
		
		
		// 4. * pattern
		if (w.charAt(wIdx) == '*') 
		{
			for (int skip = sIdx; skip <= s.length(); skip++)
			{
				if (wildCardWithMemorization(wIdx+1, skip))
				{
					// cache 인덱스를 sIdx로 설정한 이유는 위에 skip을 통해 재귀 호출했을 시 패턴이 일치한다는 것이고
					// 즉, wIdx, sIdx로 선택된 것은 패턴이 exist 하다는거지
					cache[wIdx][sIdx] = 1; 
					return true;
				}
			}
		}
		cache[wIdx][sIdx] = -1;
		return false;
	}
	
	public static boolean wildCard(String w, String s)
	{
		
		int pos = 0;

		// w가 ? 이거나 w의 글자와 s의 글자가 같으면 pos++ 시킴
		while (pos < s.length() && pos < w.length() && (w.charAt(pos) == '?' || w.charAt(pos) == s.charAt(pos)))
			pos++;

		// 종료 조건  
		if (pos == w.length())
			return pos == s.length();

		// '*' 는 완전 탐색이다. pos는 w와 s의 현재 위치이고 pos+skip을 통해 s를 완전 탐색하는 원리이다.
		// 예를 들면, w = *p* 이고 s는 help 이면
		// w의 *를 만났을 때 h, e, l, p가 w의 p와 비교가 들어간다.
		// help의 p가 w의 p와 같으니 pos++를 시켜 pos = 2이 되고 종료조건에 걸리게 되니 return true를 리턴
		// 그럼 help는 최종적으로 true가 되는 것이지.
		if (w.charAt(pos) == '*') 
		{
			for (int skip = 0; pos + skip <= s.length(); skip++)
				if (wildCard(w.substring(pos + 1),s.substring(pos + skip)))
					return true;
		}

		return false;
	}
}
