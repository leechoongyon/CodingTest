package codingtest.site.hackerrank;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigInteger;

import static org.hamcrest.Matchers.is;

public class AVeryBigSumTest {

    @Test
    public void aVeryBigSumTest() {
        BigInteger[] bigIntegers = new BigInteger[3];
        bigIntegers[0] = new BigInteger("100");
        bigIntegers[1] = new BigInteger("200");
        bigIntegers[2] = new BigInteger("300");
        Assert.assertThat(AVeryBigSum.solve(bigIntegers), is(new BigInteger("600")));
    }
}