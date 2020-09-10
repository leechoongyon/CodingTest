package codingtest.site.algospot;

import java.math.BigInteger;
import java.util.Random;

public class Karatsuba {
	
	public static final String THRESHOLD_PROPERTY_NAME = "eu.javaspecialists.tjsn.math.numbers.BasicKaratsubaThreshold";
		
    public static void main(String[] args) 
    {
    	long start, stop;
        Random random = new Random();
        int N = 3;
        
        // BigInteger 2의 N 자리수 중에 random 으로 뽑아낸다.
        /*BigInteger a = new BigInteger(N, random);
        BigInteger b = new BigInteger(N, random);*/

        BigInteger a = new BigInteger("10000000000000000000000000000000000000000000");
        BigInteger b = new BigInteger("15000000000000000000000000000000000000000000");
        
        System.out.println("a.bitLength : " + a.bitLength());
        System.out.println("b.bitLength : " + b.bitLength());
        
        System.out.println("a : " + a);
        System.out.println("b : " + b);
        
        start = System.currentTimeMillis();
        BigInteger c = karatsuba(a, b);
        stop = System.currentTimeMillis();
        System.out.println(stop - start);

        System.out.println("c : " + c);
        
        start = System.currentTimeMillis(); 
        BigInteger d = a.multiply(b);
        stop = System.currentTimeMillis();
        System.out.println(stop - start);
        
        System.out.println((c.equals(d)));
    }
    
    public static BigInteger karatsuba(BigInteger x, BigInteger y) {

        // cutoff to brute force
    	// bitlength는 말 그대로 bit의 길이
        int N = Math.max(x.bitLength(), y.bitLength());
        if (N <= 2000) return x.multiply(y);                // optimize this parameter

        // number of bits divided by 2, rounded up
        N = (N / 2) + (N % 2);

        // x = a + 2^N b,   y = c + 2^N d
        
        // z2 = a1 * b1
        // z0 = a0 * b0
        // z1 = (a0 + a1) * (b0 + b1) - z0 - z2
        BigInteger a0 = x.shiftRight(N);
        BigInteger a1 = x.subtract(a0.shiftLeft(N));
        BigInteger b0 = y.shiftRight(N);
        BigInteger b1 = y.subtract(b0.shiftLeft(N));

        // compute sub-expressions
        BigInteger z2    = karatsuba(a1, b1);
        BigInteger z0    = karatsuba(a0, b0);
        BigInteger z1  = karatsuba(a1.add(a0), b1.add(b0));

        // (z1 - z2 - z0) shiftLeft(N) 2의 N만큼 밀어버리기
        // return value = z2 + (z1-z2-z0) * 2의 N + z0 * 2의 2N
        return z2.add(z1.subtract(z2).subtract(z0).shiftLeft(N)).add(z0.shiftLeft(2*N));
    }
    
}
    
    
    