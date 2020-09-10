package codingtest.site.codingDoJang;

/**
 * @author	: 2013BWG-02
 * @date	: 2014. 10. 25.
 * @desc	: /*
 * 정말 좋은 방법... 완전 탐색인데 그냥 처음부터 시작과 끝에서 비교하는거임.
 * 내가 한 방법은 조합을 만들어서 진행하는거라 정말 답이 없었다...
 */
public class Problem5_kPalindrome {

	public static void main(String[] args) {
			String s[] = {"a","b","x","a","c","b","l"};

			int k = 1;

			System.out.println(new Problem5_kPalindrome().isKPalin(s,k,0,s.length-1));
		}

	public boolean isKPalin(String s[], int k, int firstIndex, int lastIndex) {
		if (k < 0)
			return false;

		if (firstIndex >= lastIndex)
			return true;

		boolean result = false;

		if (s[firstIndex] == s[lastIndex])
			result = isKPalin(s, k, firstIndex + 1, lastIndex - 1);
		else
			result = isKPalin(s, k - 1, firstIndex + 1, lastIndex)
					|| isKPalin(s, k - 1, firstIndex, lastIndex - 1);
		return result;
	}
}
