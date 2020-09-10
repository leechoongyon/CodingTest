package codingtest.site.algospot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @file		algospot.PICNIC.java
 * @filetype	java source file
 * @brief
 * @author		lee
 * @version		0.1
 * @history
 * 버전			성명			일자			변경내용
 * 0.1			lee		2015. 10. 14.		신규작성

예제 입력

3 
2 1 
0 1 
4 6 
0 1 1 2 2 3 3 0 0 2 1 3 
6 10 
0 1 0 2 1 2 1 3 1 4 2 3 2 4 3 4 3 5 4 5

예제 출력

1
3
4


내가 이 문제를 접근한 방식은 친구쌍의 조합으로만 문제를 푸는 것이였다.
친구쌍의 조합을 List에 넣어놓고 그 조합을 for문을 이중으로 돌려 완전탐색을 하는 방식이다.
이 방법은 시간복잡도가 n제곱이다.

처음에 선택한 방식은 친구쌍을 


이 소스는 일단 친구쌍의 조합만을 비교하는 것까지는 나랑 생각이 똑같다.
단, List에 저장장소를 안두고 Int에 저장함으로써 List에 넣다 뺏다 하는 공간을 없앴다.
int 에 저장하기 위해 입력 값을 받을 때 Shift 연산을 시도해 계산하였으며, 

결국 for문을 이중으로 돌린 것은 맞으나 List를 제거해 저장공간 절약을 가져왔다.


** 배울점 **
여기서 배울점은 List를 사용하지 않고 int를 사용해서 값 을 저장한 방식이다.

 */


public class PICNIC 
{
	private static int pairs[][];
	
    public static void main(String[] args) throws IOException 
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int cNum = Integer.parseInt(br.readLine().trim());
        for (int i = 0; i < cNum; i++) 
        {
        	st = new StringTokenizer(br.readLine().trim(), " ");
        	int numPeople = Integer.parseInt(st.nextToken());
        	int numPossiblePairs = Integer.parseInt(st.nextToken());
        	pairs = new int[numPossiblePairs][2];
        	st = new StringTokenizer(br.readLine().trim(), " ");
        	for (int j=0; j<numPossiblePairs; j++)
        	{
        		pairs[j][0] =(1<<Integer.parseInt(st.nextToken()));
        		pairs[j][1] =(1<<Integer.parseInt(st.nextToken()));
        	}
            System.out.println(solve(0, numPeople, 0));
        }
        br.close();
    }
    
    private static int solve(int start, int num, int total)
    {
    	if (num == 0) return 1;
    	int size = pairs.length;
    	int cnt = 0;
    	for (int i = start ; i < size ; i++)
    	{
    		if ((pairs[i][0] & total) == 0 && ((pairs[i][1] & total) == 0))
    				cnt += solve(i+1, num - 2, total + pairs[i][0] + pairs[i][1]);  
    	}
    	return cnt;
    }
}