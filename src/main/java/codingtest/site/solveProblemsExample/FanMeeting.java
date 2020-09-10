package codingtest.site.solveProblemsExample;

import java.util.ArrayList;
import java.util.List;

/**
 * @file		solveProblemsExample.FanMeeting.java
 * @filetype	java source file
 * @brief
 * @author		lee
 * @version		0.1
 * @history
 * 버전			성명			일자			변경내용
 * 0.1			lee		2015. 7. 11.		신규작성
 *
 *
 *	시간복잡도 : while * for => o(n제곱)
 *
 */
public class FanMeeting 
{
	public static void main(String[] args) 
	{
		int n = 4;
		char entainer[] = new char[n];
		List<Character> fanList = new ArrayList<Character>();
		
		// 1. init
		init(entainer, fanList);
		
		// 2. circulate
		int AllHugCount = 0;
		while (fanList.size() >= n)
		{
			for (int i = 0 ; i < n ; i++) 
			{
				if (entainer[i] == 'M' && fanList.get(i) == 'M')
					break;
			}
			AllHugCount++;
			fanList.remove(0);
		}
		
		System.out.println("AllHugCount : " + AllHugCount);
	}
	
	public static void init(char entainer[], List<Character> fanList)
	{
		entainer[0] = 'F'; entainer[1] = 'F'; entainer[2] = 'F'; entainer[3] = 'F';
		fanList.add('F'); fanList.add('F'); fanList.add('F'); fanList.add('F'); fanList.add('F'); fanList.add('F');
	}
}
