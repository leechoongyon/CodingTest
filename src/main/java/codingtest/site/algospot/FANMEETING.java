package codingtest.site.algospot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @file		algospot.FANMEETING.java
 * @filetype	java source file
 * @brief
 * @author		lee
 * @version		0.1
 * @history
 * 버전			성명			일자			변경내용
 * 0.1			lee		2015. 9. 10.		신규작성
 *

예제 입력

4
FFFMMM
MMMFFF
FFFFF
FFFFFFFFFF
FFFFM
FFFFFMMMMF
MFMFMFFFMMMFMF
MMFFFFFMFFFMFFFFFFMFFFMFFFFMFMMFFFFFFF

예제 출력

1
6
2
2


1
FFFFF
FFFFFFFFFF


문제 : 모든 멤버들이 포옹하는 횟수
주의 : 남자끼리는 악수
 	    팬들이 1칸씩 이동

 *
 *	풀이 알고리즘 1 
 *
 *	1. 멤버들 수를 digit라고 하고 팬들을 digit만큼 뽑아내고 비교 시작
 *	2. 한칸씩 밀어버림. 
 *	3. 즉, 재귀함수는    solve(fan[], startIndex, digit)
 *	4. 재귀함수 안에서 startIndex ~ digit+startIndex 만큼 member[] 랑 비교하면 됨.
 *
 *
 *	풀이 알고리즘 2
 *	
 *	1. 멤버의 성별을 1,0으로 표시하고 곱셈으로 처리한다?
 *	2. 카라츠바 공식 알아보기.
 */
public class FANMEETING 
{
	public static void main(String[] args) throws IOException 
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cNum = Integer.parseInt(br.readLine());
		int res[] = new int[cNum];
		for (int i = 0 ; i < cNum ; i++)
		{
			char member[] = br.readLine().toCharArray();
			char fan[] = br.readLine().toCharArray();
			res[i] = hug(member, fan);
		}
		for (int k = 0 ; k < res.length ; k++)
			System.out.println(res[k]);
	}
	
	public static int hug(char member[], char fan[])
	{
		int memberRange = member.length;
		int sum = 0;
		int mPos = 0;
		
		for (int startIndex = 0 ; startIndex <= fan.length - memberRange ; startIndex++)
		{
			for (int fPos = startIndex ; fPos < startIndex + memberRange ; fPos++)
			{
				if ((member[mPos++] == 'M' && fan[fPos] == 'M'))
					break;
				
				if (fPos == startIndex + memberRange -1)
					sum += 1;
			}
			mPos = 0;
		}
		return sum;
	}
}
