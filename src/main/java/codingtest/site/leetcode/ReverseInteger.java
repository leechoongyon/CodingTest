package codingtest.site.leetcode;

/**
 * 
 * @author USER
 *
 *         Example 1. in : 123 out : 321
 *
 *
 *
 *         1111011 101000001
 * 
 */

public class ReverseInteger {
	public static void main(String[] args) {
		/**
		 * brute-force 1. 최대 자리수부터 최소 자리수까지 구함. 2. 최대 자리수를 나눠서 reverse 3. 예외상황 : 뒤집었을 때,
		 * Integer.MAX_VALUE, Integer.MIN_VALUE 를 넘는지 체크
		 * 
		 * O(2n)
		 */
		System.out.println(reverse(-1563847412));
	}

	public static int reverse(int x) {
		int tmp = x;
		if (x == Integer.MIN_VALUE) {
			return 0;
		}

		int digit = getDigit(tmp);
		int frontDigit = 0;
		int backDigit = digit - 1;
		int sum = 0;
		for (int i = digit - 1; i >= 0; i--) {
			int quotient = tmp / (int) Math.pow(10, i);
			sum += quotient * Math.pow(10, frontDigit++);
			tmp -= quotient * Math.pow(10, backDigit--);
		}
		return (sum == Integer.MAX_VALUE || sum == Integer.MIN_VALUE) ? 0 : sum;
	}
	
	private static int getDigit(int x) {
		int digit = 0;
		while (x != 0) {
			x /= 10;
			digit++;
		}
		return digit;
	}

}
