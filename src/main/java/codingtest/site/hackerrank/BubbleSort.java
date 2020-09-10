package codingtest.site.hackerrank;

import java.util.Scanner;

/**
 * @file		hackerrank.BubbleSort.java
 * @filetype	java source file
 * @brief
 * @author		USER
 * @version		0.1
 * @history
 * 버전			성명			일자			변경내용
 * 0.1			USER		2018. 2. 3.		신규작성
 *
 * @point & feedback
 * 1. 버블정렬 후 3줄 찍으면 됨.
 */
public class BubbleSort
{

    public static void main(String[] args)
    {
	Scanner in = new Scanner(System.in);
	int n = in.nextInt();
	int a[] = new int[n];
	for (int a_i = 0; a_i < n; a_i++)
	{
	    a[a_i] = in.nextInt();
	}
	solve(n, a);
    }

    public static void solve(int n, int a[])
    {
	int swapCount = 0;
	for (int i = 0; i < n; i++)
	{
	    for (int j = 0; j < n - 1; j++)
	    {
		// Swap adjacent elements if they are in decreasing order
		if (a[j] > a[j + 1])
		{
		    swap(a, j, j + 1);
		    swapCount++;
		}
	    }
	}
	System.out.println("Array is sorted in " + swapCount + " swaps.");
	System.out.println("First Element: " + a[0]);
	System.out.println("Last Element: " + a[n - 1]);
    }

    public static void swap(int a[], int j, int k)
    {
	int temp = a[j];
	a[j] = a[k];
	a[k] = temp;
    }

}
