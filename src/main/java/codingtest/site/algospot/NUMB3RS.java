package codingtest.site.algospot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @file		algospot.NUMB3RS.java
 * @filetype	java source file
 * @brief
 * @author		lee
 * @version		0.1
 * @history
 * 버전			성명			일자			변경내용
 * 0.1			lee		2015. 11. 9.		신규작성

입력
2
5 2 0
0 1 1 1 0
1 0 0 0 1
1 0 0 0 0
1 0 0 0 0
0 1 0 0 0
3
0 2 4


5 : 마을의 수
2 : 탈출 후 지금까지 지난 일수
0 : 교도소가 있는 마을의 번호
n * n : 각 마을에서 서로 연결된 마을
3 : 3개 마을로 올 확률
0 2 4 : 이 마을로 올 확률

8 2 3
0 1 1 1 0 0 0 0
1 0 0 1 0 0 0 0
1 0 0 1 0 0 0 0
1 1 1 0 1 1 0 0
0 0 0 1 0 0 1 1
0 0 0 1 0 0 0 1
0 0 0 0 1 0 0 0
0 0 0 0 1 1 0 0
4
3 1 2 6 


출력
0.83333333 0.00000000 0.16666667
0.43333333 0.06666667 0.06666667 0.06666667


문제가 묻는 것은 각 마을에 두니발 박사가 숨어 있을 확률  

 */
public class NUMB3RS 
{
	public static void main(String[] args) throws NumberFormatException, IOException 
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cNum = Integer.parseInt(br.readLine());
		double res[][] = new double[cNum][];
		int numTown;
		int spendDate;
		int prisonNum;
		int townBoard[][];
		int getChangeToTheseViliages[] = null;
		int numOfViliages;
		
		StringTokenizer st = null;
		
		for (int i = 0 ; i < cNum ; i++)
		{
			st = new StringTokenizer(br.readLine().trim(), " ");
			numTown = Integer.parseInt(st.nextToken());
			spendDate = Integer.parseInt(st.nextToken());
			prisonNum = Integer.parseInt(st.nextToken());
			
			townBoard = new int[numTown][numTown];
			for (int j = 0 ; j < numTown ; j++)
			{	
				st = new StringTokenizer(br.readLine().trim(), " ");
				for (int k = 0 ; k < numTown ; k++)
				{
					townBoard[j][k] = Integer.parseInt(st.nextToken());
				}
			}
			
			numOfViliages = Integer.parseInt(br.readLine());
			
			st = new StringTokenizer(br.readLine().trim(), " ");
			
			for (int m = 0 ; m < numOfViliages ; m++)
			{
				getChangeToTheseViliages[m] = Integer.parseInt(st.nextToken());
			}
			
			res[cNum] = new double[numOfViliages];
			
			for (int n = 0 ; n < numOfViliages ; n++)
				res[i] = solve(prisonNum);
		}
		for (int k = 0 ; k < res.length ; k++)
			System.out.println(res[k]);	
	}
	
	
	public static double[] solve(int nowPos)
	{
		return null;
		// 1. 기저사례
		// 소요된 날짜 = spendDate 이면 return
		// 등록된 마을인지 체크 -> 등록된 마을이면 특정 배열에 확률 저장 1/n 의 소요된 날짜 제곱
		
		// 2. 로직
		/*
		 * for (int i = 0 ; i < n ; i++)
		 * {
		 * 		if (마을[nowPos][i] == 1)
		 * 			재귀(i)
		 * }
		 */
	}

}
