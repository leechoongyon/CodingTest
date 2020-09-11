package codingtest.site.hackerrank;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class AVeryBigSum {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(in.readLine());
        BigInteger[] bigIntegers = new BigInteger[num];
        String[] str = in.readLine().split(" ");

        for (int i = 0 ; i < str.length ; i++) {
            bigIntegers[i] = new BigInteger(str[i]);
        }

        BigInteger result = solve(bigIntegers);
        System.out.println(result);
    }

    public static BigInteger solve(BigInteger[] bigIntegers) {
        BigInteger sum = BigInteger.ZERO;
        for (BigInteger bigInteger : bigIntegers) {
            sum = sum.add(bigInteger);
        }
        return sum;
    }
}