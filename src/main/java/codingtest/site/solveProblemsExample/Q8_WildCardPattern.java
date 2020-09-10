package codingtest.site.solveProblemsExample;

/**
 * @author : 2013BWG-02
 * @date : 2014. 9. 22.
 * @desc : //주석 추가 //Pos를 도입한 이유는 w,s를 index 하나씩 ++해 재귀로 날리는 순간 이전 것들이 * 로직을 타기에
 *       Pos를 도입해 바로바로 처리해서 '*' 로직만 타게 만드는 것이다. 로직의 핵심은 완전탐색을 통해서 s의 값들을 *만큼 넘겨서
 *       다 체크하는 것이지. 전체적인 로직은 같은거 , ? 제거 -> 종료 조건 도입 -> * 처리 이게 순환하면서 처리되는 로직이다.
 */
public class Q8_WildCardPattern {
	static int cache[] = new int[10];

	public static void main(String[] args) {
		String w = "ab*d";
		String s = "abdd";

		System.out.println(new Q8_WildCardPattern().wildCardPatternmatch(w, s));
		System.out.println(new Q8_WildCardPattern().wildCardPatternMatchWithMemorization(w, s, 1));
	}

	public boolean wildCardPatternmatch(String w, String s) {
		int pos = 0;

		while (pos < s.length() && pos < w.length()
				&& (w.charAt(pos) == '?' || w.charAt(pos) == s.charAt(pos)))
			pos++;

		if (pos == w.length())
			return pos == s.length();

		if (w.charAt(pos) == '*') {
			for (int skip = 0; pos + skip <= s.length(); skip++)
				if (wildCardPatternmatch(w.substring(pos + 1),
						s.substring(pos + skip)))
					return true;
		}

		return false;
	}

	public int wildCardPatternMatchWithMemorization(String w, String s,
			int cachePos) {
		int pos = 0;

		// 1.비교
		while (pos < s.length() && pos < w.length()
				&& (w.charAt(pos) == '?' || w.charAt(pos) == s.charAt(pos)))
			pos++;

		// 2. 종료 조건
		if (pos == w.length() && pos == s.length()) {
			cache[cachePos] += 1;
			return cache[cachePos];
		}

		// 3. 캐쉬 체크
		if (w.charAt(pos) == '*') {
			for (int skip = 0; pos + skip <= s.length(); skip++) {
				if (cache[pos + skip] != 0)
					return cache[pos + skip];
				else {
					cache[pos + skip] = wildCardPatternMatchWithMemorization(
							w.substring(pos + 1), s.substring(pos + skip), pos
									+ skip);
					if (cache[pos + skip] != 0)
						return cache[pos + skip];
				}
			}
		}

		return 0;
	}

}
