package codingtest.site.algospot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @file		algospot.CLOCKSYNC.java
 * @filetype	java source file
 * @brief
 * @author		lee
 * @version		0.1
 * @history
 * 버전			성명			일자			변경내용
 * 0.1			lee		2015. 9. 7.		신규작성

예제 입력

2
12 6 6 6 6 6 12 12 12 12 12 12 12 12 12 12 
12 9 3 12 6 6 9 3 12 9 12 9 12 12 6 6

예제 출력

2
9




Ex1

1
12 12 12 6 9 9 12 3 12 6 12 6 12 12 9 9


Ex2)
1
3 3 3 9 9 9 6 12 6 9 6 3 6 6 3 3

0번 3  (0,1,2)
1번 3  (3 7 9 11)
4번 2  (6 7 8 10 12)
7번 3  (4 5 7 14 15)
9번 2  (3 4 5 9 13)

13

조합
3  3  0  0  2  0  0  3 0 2


 0  1  2  3  4  5  6  7  8  9 10 11 12 13 14 15

12 12 12 12 12 12 12 12 12 12 12 12 12 12 12 12
-9 -9 -9 -9       -6 -9    -9    -9
                     -6 -6    -6    -6
            -9 -9    -9                   -9 -9
         -6 -6 -6          -6          -6


 3  3  3  9  9  9  6 12  6  9  6  3  6  6  3  3

 9  9  9  9           9     9     9
                   6  6  6     6     6
             9  9     9                    9  9
          6  6  6           6           6

 */
public class CLOCKSYNC 
{
	private static final int switchNum = 10; 
	private static int min = Integer.MAX_VALUE;
	
	static int watch[] = new int[16];
	static int [][] switchList = {{0,1,2}, {3,7,9,11}, {4, 10, 14, 15}, {0, 4, 5, 6, 7}, {6, 7, 8, 10, 12}, {0, 2, 14, 15}, {3, 14, 15}, {4, 5, 7, 14, 15}, {1, 2, 3, 4, 5}, {3, 4, 5, 9, 13}}; 
	static int [] tempWatch; 
	
	public static void main(String[] args) throws IOException 
	{
		List<Integer> picked = new ArrayList<Integer>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int cNum = Integer.parseInt(br.readLine().trim());
        for (int i = 0; i < cNum; i++) {
        	st = new StringTokenizer(br.readLine().trim(), " ");
        	for (int j = 0 ; j < 16 ; j++)
        		watch[j] = Integer.parseInt(st.nextToken());
        	tempWatch = watch.clone();
        	solve(picked);
        	if (min == Integer.MAX_VALUE) System.out.println(-1);
        	else System.out.println(min);
        	min = Integer.MAX_VALUE; tempWatch = watch.clone();
        }
        br.close();
	}

	public static void solve(List<Integer> picked)
	{
		if (picked.size() == switchNum)
		{
			int tempMin = 0;
			
			for (int i = 0 ; i < picked.size() ; i++)
			{
				tempMin += picked.get(i);
				for (int j = 0 ; j < switchList[i].length ; j++)
				{
					tempWatch[switchList[i][j]] += 3 * picked.get(i);
				}
			}
			
			for (int i = 0 ; i < tempWatch.length ; i++)
			{
				if (tempWatch[i] % 12 != 0)
				{
					tempWatch = watch.clone();					
					return ;
				}
			}
				
			min = Math.min(min, tempMin);

			return ;
		}
		
		
		for (int next = 0 ; next < 4 ; next++)
		{
			picked.add(next);
			solve(picked);
			picked.remove(picked.size() - 1);
		}
	}
}
