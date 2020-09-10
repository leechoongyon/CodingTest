package codingtest.site.hackerrank;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.Matchers.is;

public class BiggerIsGreaterTest {

    @Test
    public void solveTest() {
        Assert.assertThat(BiggerIsGreater.solve("abcde"), is("abced"));
        Assert.assertThat(BiggerIsGreater.solve("abced"), is("abdce"));
        Assert.assertThat(BiggerIsGreater.solve("abdce"), is("abdec"));
        Assert.assertThat(BiggerIsGreater.solve("abdec"), is("abecd"));
        Assert.assertThat(BiggerIsGreater.solve("abecd"), is("abedc"));
        Assert.assertThat(BiggerIsGreater.solve("abedc"), is("acbde"));

        Assert.assertThat(BiggerIsGreater.solve("aaa"), is("no answer"));

        Assert.assertThat(BiggerIsGreater.solve("fvincndjrurfh"), is("fvincndjrurhf"));
    }
}