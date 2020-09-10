package codingtest.site.hackerrank;

import java.util.Scanner;

/**
 * @author lee
 * @point 1. use memory
 * 
 */
public class ArraysLeftRotation
{
    public static void main(String[] args)
    {
	Scanner in = new Scanner(System.in);
	int n = in.nextInt();
	int k = in.nextInt();
	int a[] = new int[n];
	for (int a_i = 0; a_i < n; a_i++)
	{
	    a[a_i] = in.nextInt();
	}
	int res[] = solve(a, n, k);
	for (int i = 0; i < res.length; i++)
	    System.out.print(res[i] + " ");
    }

    public static int[] solve(int a[], int n, int k)
    {
	int res[] = new int[n];
	int index;
	for (int i = 0; i < n; i++)
	{
	    index = i - k;
	    if (index < 0)
		index = index + n;
	    res[index] = a[i];
	}
	return res;
    }
}
