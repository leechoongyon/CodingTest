package codingtest.site.solveProblemsExample;

/**
 * @file		solveProblemsExample.WildCard.java
 * @filetype	java source file
 * @brief
 * @author		lee
 * @version		0.1
 * @history
 * 버전			성명			일자			변경내용
 * 0.1			lee		2015. 7. 15.		신규작성
 *
 *
 *	메모제이션 이용 방법
 *
 *	1. 완전탐색을 짜고 
 *
 *		- 현재 완성된 distinguish 는 wildCard 만큼 돌기 때문에 n , 거기다 * 붙었을 때 n만큼 또 계산하니 시간복잡도 o(n제곱)
 *
 *	2. 메모제이션을 사용 
 *
 *
 */
public class WildCard 
{	
	public static void main(String[] args) {
		
		String wildCard = "ab*c";
		String inStr[] = {"abbbc", "abbbccccc", "abcd"};
		
		for (int i = 0 ; i < inStr.length ; i++) {
			if (distinguish(wildCard, inStr[i])) {
				System.out.println("Accord");
				System.out.print("wildCard : " + wildCard + "  ||  inStr : " + inStr[i]);
			}
		}
	}
	
	public static boolean distinguish(String wildCard, String inStr) {

		int wildCardSize = wildCard.length();
		int inStrSize = inStr.length();
		
		// 1. 기저사례
		if (wildCardSize == 0 || inStrSize == 0) {
			if (wildCardSize == inStrSize) return true;
			else return false;
		}
		
		// 2. '?' 처리 , '알파벳' 처리
		if (wildCard.charAt(0) == '?')
			return distinguish(wildCard.substring(1, wildCardSize), inStr.substring(1, inStrSize));
		
		if (wildCard.charAt(0) == inStr.charAt(0)) 
			return distinguish(wildCard.substring(1, wildCardSize), inStr.substring(1, inStrSize));
		
		// 3. '*' 처리
		if (wildCard.charAt(0) == '*') {
			for (int i = 0 ; i < inStrSize ; i++) {
				if (distinguish(wildCard.substring(1, wildCardSize), inStr.substring(i, inStrSize))) 
					return true;
			}
		}
		return false;
	}
}
