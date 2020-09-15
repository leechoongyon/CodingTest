package codingtest.site.hackerrank;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TheTimeInWords {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int h = Integer.parseInt(in.readLine());
        int m = Integer.parseInt(in.readLine());

        System.out.println(solve(h, m));
    }

    /**
     * 문제 : 시간을 word 시간으로 변환
     * m = 0이면 o' clock
     * 1 <= m <= 30  이면, past 를 사용.
     * m > 30 이면, to를 사용.
     *
     *
     * 1. brute-force
     *  - m 에 대해 비교.
     *  - m = 0 , 1 <= m <= 30, m > 30 이 3개를 비교. 비교해서 to 를 쓸지 past 를 쓸지 결정.
     *  - m = 0 이면 그냥 끝나면 되고.
     *  - 1 <= m <= 30 이면, 문자 맵핑.
     *  - m > 30 이면, 문자 맵핑.
     *
     *  - 시간복잡도 O(1}
     *
     * @param h
     * @param m
     * @return
     */
    public static String solve(int h, int m) {
        return "";
    }
}
