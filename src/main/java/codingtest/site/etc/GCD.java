package codingtest.site.etc;

public class GCD
{
	public static void main(String [] args)
	{
		System.out.println(gcd(101, 50));
		System.out.println(lcm(100, 50));
	}

	private static int gcd(int a, int b)
	{
		if (b == 0) return a;
		else return gcd(b, a % b);
	}
	
	public static int lcm(int a, int b)
	{
		return (a * b) / gcd(a,b);
	}
}
