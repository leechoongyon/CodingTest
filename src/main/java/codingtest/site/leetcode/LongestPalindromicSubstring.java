package codingtest.site.leetcode;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * s 가 주어졌을 때 가장 긴 palindrome 를 찾아라.
 * 최대 길이는 1000
 * <p>
 * Example 1:
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * <p>
 * Example 2:
 * Input: "cbbd"
 * Output: "bb"
 */

public class LongestPalindromicSubstring {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String s = in.readLine();
        System.out.println(new LongestPalindromicSubstring().longestPalindrome(s));
    }

    /**
     * 1. dp 이용
     *  a. 양옆을 비교해 나감.
     *  b. c[i] == c[j] && i-j <= 2 라는 것은 양 옆의 차가 2이하라는 것이니 palindrome 이다.
     *  c. c[i] == c[j] && i-j <= 2 가 아니면, 안 쪽에 있는 문자열을 또 다시 비교해야 함.
     *  d. 그 비교하는 부분을 dp 를 이용하는 것.
     *
     *  시간복잡도 O(n제곱) / 공간복잡도 O(n제곱)
     *
     * @param s
     * @return
     */

    public String longestPalindrome(String s) {
        boolean[][] cache = new boolean[s.length()][s.length()];
        char[] c = s.toCharArray();
        int max = 0;
        String result = "";
        for (int i = 0 ; i < s.length() ; i++) {
            for (int j = i ; j >= 0 ; j--) {
                cache[i][j] = (c[i] == c[j] && (i - j <= 2 || cache[i-1][j+1]));
                if (cache[i][j] && i - j >= max) {
                    max = i - j;
                    result = s.substring(j, i+1);
                }
            }
        }
        return result;
    }
}
