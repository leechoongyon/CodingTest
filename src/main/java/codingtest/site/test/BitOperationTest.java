package codingtest.site.test;

import java.math.BigInteger;

/**

5 10
1234567890
0987654321
1111111111
1111111111
2222222222

3 6
876543
111111
111111

 */

/**
 * 1 - 123456    (0 ~ 6)
 * 2 - 098765    (10 ~ 16)
 * 3 - 111111    (20 ~ 26)
 */

public class BitOperationTest {
    public static void main(String[] args) {
        String s = "12345678900987654321111111111111111111112222222222";

//        System.out.println(s.substring(0, 6));
//        System.out.println(s.substring(10, 16));
//        System.out.println(s.substring(20, 26));
//
//        System.exit(0);

        String[] pattern = new String[] {"876543", "111111", "111111"};

        int gridRow = 5;
        int gridCol = 10;

        int patternRow = 3;
        int patternCol = 6;

        /**
         * 마지막을 어떻게 판단하지?
         * 23이 마지막이고.
         * (5 - 3) * 10 + (10 - 6) - 1 = 23
         */
        for (int i = 0 ; i <= (gridRow - patternRow) * gridCol + (gridCol - patternCol)  ; i++) {
            int idx = i;
            StringBuilder sb = new StringBuilder();
            for (int k = 0 ; k < patternRow ; k++) {
                sb.append(s.substring(idx, idx + patternCol));
//                System.out.println("start : " + idx + "   end : " + (idx + patternCol) );
                idx += patternCol;
                idx += gridCol - patternCol;
            }
            System.out.println(sb.toString());
        }
    }
}
