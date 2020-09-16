package codingtest.site.test;

import java.math.BigInteger;

/**

1234567890
0987654321
1111111111
1111111111
2222222222

876543
111111
111111

 */


public class BitOperationTest {
    public static void main(String[] args) {
        String s = "12345678900987654321111111111111111111112222222222";

        String[] pattern = new String[] {"876543", "111111", "111111"};

        int gridCol = 10;
        int gridRow = 10;

        int patternRow = 3;
        int patternCol = 6;

        for (int i = 0 ; i <= s.length() - 6 ; i++) {
            for (int k = 0 ; k < patternRow ; k++) {
                BigInteger b1 = new BigInteger(s.substring(k * (gridCol - patternCol) + i, i + 6));
            }
//            BigInteger b1 = new BigInteger(s.substring(i, i + 6) + s.substring(i + 6 + gridCol - patternCol, ));

        }
    }
}
