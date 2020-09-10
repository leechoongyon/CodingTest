package codingtest.site.etc;

public class PrimeNumber {
	public static void main(String[] args) {
		System.out.println(isPrime(2));
		System.out.println(isPrime(3));
		System.out.println(isPrime2(21));
	}
	
	/** time complexity : O(n) */
	public static boolean isPrime(int n) {
		if (n == 2) {
			return true;
		}
		for (int i =  2 ; i < n ; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	/** 
	 * 에라토네스의 접근
	 * num / a = b 라 가정
	 * a 와 b 중에 하나는 root num 보다 크거나 작거나 같아야 한다.
	 * 그렇기에 소수라면 root num 이하의 작은 수들에 의해 나누어지면
	 * 안된다.
	 * time complexity : O(root n)
	 **/
	public static boolean isPrime2(int n) {
		if (n == 2) {
			return true;
		}
		for (int i = 2 ; i < Math.sqrt(n) ; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}
}
