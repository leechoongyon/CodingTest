package codingtest.site.leetcode;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PalindromeNumber {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String s = in.readLine();
        int input = Integer.parseInt(s.trim());
        System.out.println(new PalindromeNumber().isPalindrome(input));
    }

    public boolean isPalindrome(int x) {
        /**
         * PalindromeNumber 인지 판단하는 문제
         *
         * 1. brute-force
         *    - 숫자만 입력받을 수 있음.
         *    - 양 끝에서부터 하나씩 비교해 나감.
         *    - 절반만 비교하면 돼니 O(n/2)
         *    - 짝수, 홀수 구분 할 필요 없음. 가운데 수는 비교 x
         *    - 음수는 무조건 false 인가?
         */

        if (x < 0) {
            return false;
        }

        char[] chars = String.valueOf(x).toCharArray();
        int left = 0;
        int right = chars.length - 1;
        int mid = (left + right) / 2;
        while (left <= mid && mid <= right) {
            if (chars[left] != chars[right]) {
                return false;
            }
            left++; right--;
        }
        return true;
    }
}
