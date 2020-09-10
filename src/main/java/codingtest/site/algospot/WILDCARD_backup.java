package codingtest.site.algospot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @file		algospot.WILDCARD.java
 * @filetype	java source file
 * @brief
 * @author		lee
 * @version		0.1
 * @history
 * 버전			성명			일자			변경내용
 * 0.1			lee		2015. 9. 22.		신규작성

입력
2
he?p
4
help
heap
helpp
swkjfwklfjwlkfja
*p*
4
help
papa
hello
pppppppppppppppppppppppppppppppppppppppp


1
*p*
3
help
papa
hello

1
*p*
1
hello

1
*p*
3
help
papa
swkjfwklfjwlkfja


예제 출력
heap
help
help
papa

 */

public class WILDCARD_backup 
{
	private static String[] fileName;
	private static int cache[];
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		int cNum = Integer.parseInt(stdin.readLine());
		for (int i = 0 ; i < cNum ; i++)
		{
			String w = stdin.readLine();
			int N = Integer.parseInt(stdin.readLine());
			fileName = new String[N];
			for (int j = 0 ; j < N ; j++)
			{
				fileName[j] = stdin.readLine();
				cache = new int[2 * fileName[j].length()];
				
				/*if (wildCardWithMemorization(w, fileName[j], 0) != 0) 
					System.out.println(fileName[j]);*/
				if(wildCard(w, fileName[j]))
					System.out.println(fileName[j]);
			}
		}
	}
	
	public static int wildCardWithMemorization(String w, String s, int cachePos) 
	{
		int pos = 0;

		// 1.비교
		while (pos < s.length() && pos < w.length() && (w.charAt(pos) == '?' || w.charAt(pos) == s.charAt(pos)))
			pos++;

		// 2. 종료 조건
		if (pos == w.length() && pos == s.length()) {
			cache[cachePos] += 1;
			return cache[cachePos];
		}

		// 3. 캐쉬 체크
		if (w.charAt(pos) == '*') {
			for (int skip = 0; pos + skip <= s.length(); skip++) {
				if (cache[pos + skip] != 0)
					return cache[pos + skip];
				else {
					cache[pos + skip] = wildCardWithMemorization(w.substring(pos + 1), s.substring(pos + skip), pos + skip);
					if (cache[pos + skip] != 0)
						return cache[pos + skip];
				}
			}
		}

		return 0;
	}
	
	public static boolean wildCard(String w, String s)
	{
		
		int pos = 0;

		while (pos < s.length() && pos < w.length()
				&& (w.charAt(pos) == '?' || w.charAt(pos) == s.charAt(pos)))
			pos++;

		if (pos == w.length())
			return pos == s.length();

		if (w.charAt(pos) == '*') {
			for (int skip = 0; pos + skip <= s.length(); skip++)
				if (wildCard(w.substring(pos + 1),s.substring(pos + skip)))
					return true;
		}

		return false;
	}
}
