package codingtest.site.codingDoJang;

/**
 * @author	: 2013BWG-02
 * @date	: 2014. 11. 10.
 * @desc	: 
 * 1. determineCipher를 통해 n일 때, 몇번째 자리수일 때 , n번째 출력인지 확인.
 * 2. countSymmetryNum을 통해 해당 자리수(cipher)일 때, n번째수는 어떤수가 출력되는지 계산해서 출력. 
 */
public class Problem10_Palindrome {
	
	static int n = 1000000;
		
	public static void main(String[] args) {

		Problem10_Palindrome palinDrome = new Problem10_Palindrome();
		int cipher = palinDrome.determineCipher();

		char result[] = palinDrome.countSymmetryNum(cipher);
	
		for(int i = 0 ;  i < cipher / 2 ; i++)
			result[cipher-i-1] = result[i];
		for(int i = 0 ; i < result.length ; i++)
			System.out.print(result[i]);	
	}

	public int determineCipher() {
		
		int cipher = 1;
		int tempNum = 0;

		// 1자리 수면 바로 Return
		if(n - 10 <= 0)
			return cipher;

		// 1자리수에 0~9이니 count 10임.
		n = n - 10; cipher++;		

		while(true) {
			tempNum = cipher % 2 == 0 ? cipher / 2 : cipher / 2 + 1;
			if(n - ( 9 * (int) Math.pow(10, tempNum - 1)) < 0)
				return cipher;
			else if(n - (9 * (int) Math.pow(10,tempNum -1)) > 0) {
				n = n - ( 9 * (int) Math.pow(10, tempNum-1));
				cipher++;
			} else {
				return cipher;
			}
		}
	}

	public char[] countSymmetryNum(int cipher) {
		//nDigit는 특정 자릿수를 지정, oldNum은 특정 자릿수가
		int nDigit = 0;
		int oldNum = 1;

		char result[] = new char[cipher];
		cipher = cipher % 2 == 0 ? cipher / 2 : (cipher / 2) + 1;
		int quotient = cipher;

		while(true) {
			if(cipher == nDigit)
				break;
			if(n - (int) Math.pow(10, quotient - 1) < 0) {		
			
			// 1) oldNum을 nDigit에 저장.
			// 2) oldNum 0으로 초기화

			result[nDigit++] = Character.forDigit(oldNum, 10);
			oldNum = 0; quotient--;
			} else if(n - (int) Math.pow(10, quotient-1) > 0) {
				n = n - (int) Math.pow(10, quotient-1);
				oldNum++;
			} else {
				result[nDigit++] = Character.forDigit(oldNum,10);
				oldNum = 0; quotient--;
			}
		}

		return result;
	}
}
