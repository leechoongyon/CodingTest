 package codingtest.site.solveProblemsExample;

/**
 * @file		solveProblemsExample.Bino.java
 * @filetype	java source file
 * @brief
 * @author		lee
 * @version		0.1
 * @history
 * 버전			성명			일자			변경내용
 * 0.1			lee		2015. 7. 13.		신규작성
 *
 *	동적계획법 정의 :
 *
 *	두 번 이상 반복 계산되는 부분 문제들의 답을 미리 저장함으로써 속도의 향상을 꾀하는 알고리즘 설계 기법을
 *	계획법이라고 합니다.
 *  
 *
 *	동적계획법을 사용하는 이유 :
 *
 *	중복된 계산을  없앤다. 메모제이션과 같은 Cache를 사용해서 중복을 없앰.
 *	이게 동적계획법의 목적이다.
 *
 *	메모제이션 정의 :
 *	Cache 같은 것을 이용해 값을 저장(중복을 피하기 위해)
 *
 *	메모제이션 전제 사항 :
 *	함수의 반환 값이 그 입력 값만으로 결정되야됨. 외부 요소에 의해 Cache 값이 변경되면 안됨. (이를 참조적 투명성 이라 함.)
 *
 *	메모제이션 구현 패턴 :
 *
 *	1. 기저 사례 먼저 처리 (입력이 범위를 벗어난 경우 등)
 *	2. 함수의 반환 값이 항상 0 이상이라는 점을 이용 ( ex. if (cache[n][r] != 0) return cache[n][r]) )
 *	3. 실제 계산 첨부 (return cache[n][r] = cache[n-1][r-1] + cache[n-1][r] ;
 *
 */
public class Bino 
{
	public static void main(String[] args) 
	{
		int n = 5; 
		int r= 3; 
		int cache[][] = new int[30][30];
		
		System.out.println("bino(5,3) : " + bino_original(n, r));
		System.out.println("cache bino(5,3) : " + bino(cache, n, r));
		
	}
	
	public static int bino(int cache[][], int n, int r)
	{
		if (r == 0 || n == r) return 1;
		
		if (cache[n][r] != 0)
			return cache[n][r];
		return cache[n][r] = bino(cache, n-1, r-1) + bino(cache, n-1, r);
	}
	
	public static int bino_original(int n, int r)
	{
		if (r == 0 || n == r) return 1;
		
		return bino_original(n-1, r-1) + bino_original(n-1, r);  
	}
}
