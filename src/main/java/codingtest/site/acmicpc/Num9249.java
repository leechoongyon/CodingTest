package codingtest.site.acmicpc;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 문제
 * 문자열 가 문자열 의 부분 문자열이 되려면, 를 만족하는 가 있어야 한다.
 * <p>
 * 두 문자열 와 가 주어졌을 때, 두 문자열의 공통 부분 문자열의 최대 길이와 그 부분 문자열을 구하는 프로그램을 작성하시오.
 * <p>
 * 입력
 * 두 문자열 와 가 한 줄에 하나씩 주어진다. 두 문자열 길이의 합은 20만을 넘지 않는다. 주어지는 문자열은 알파벳 소문자로만 이루어져 있다.
 * <p>
 * 출력
 * 첫째 줄에 두 문자열의 최장 공통 부분 문자열의 길이를 출력한다.
 * <p>
 * 둘째 줄에 해당 부분 문자열을 출력한다.
 * <p>
 * 답이 여러 가지인 경우에는 아무거나 출력한다.
 * <p>
 * 예제 입력 1
 * yeshowmuchiloveyoumydearmotherreallyicannotbelieveit
 * yeaphowmuchiloveyoumydearmother
 * 예제 출력 1
 * 27
 * howmuchiloveyoumydearmother
 * <p>
 * <p>
 * 예외 케이스
 * abcde
 * abcdddd
 */


public class Num9249 {
    private static char[] c1;
    private static char[] c2;
    private static String[][] cache;
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        c1 = in.readLine().toCharArray();
        c2  = in.readLine().toCharArray();
        cache = new String[c1.length][c2.length];

        System.out.println(solve());
    }

    public static String solve() {
        String max = "";

        /** init */
        for (int i = 0 ; i < c1.length ; i++) {
            for (int j = 0 ; j < c2.length ; j++) {
                cache[i][j] = "";
            }
        }

        for (int i = 0 ; i < c1.length ; i++) {
            for (int j = 0 ; j < c2.length ; j++) {
                String s = lcs(i, j);
                if (s == "") {
                    continue;
                } else if (max.length() < s.length()) {
                    max = s;
                }
            }
        }
        return max;
    }

    public static String lcs(int i, int j) {
        if (i < 0 || j < 0) {
            return "";
        }

        if (cache[i][j] != "") {
            return cache[i][j];
        }

        if (c1[i] == c2[j]) {
            cache[i][j] = lcs(i-1, j-1) + c1[i];
        }
        return cache[i][j];
    }
}