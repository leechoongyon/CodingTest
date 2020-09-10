package codingtest.site.codingInterview.recursiveAndDP.Q8_07;

import java.util.ArrayList;
import java.util.List;

public class Question
{
	private static final int ELEMENT_NUM = 4;
	private static boolean visited[] = new boolean[ELEMENT_NUM];
	private static List<String> list = new ArrayList<String>();
	
	public static void main(String [] args)
	{
		String array[] = new String[] {"a", "b", "c", "d"};
		permutation(array);
	}
	
	public static void permutation(String array[])
	{
		for (int i = 1 ; i <= array.length ; i++)
		{
			permutation(array, i);
		}
	}
	
	public static void permutation(String array[], int n)
	{
		/** 기저 사례 */
		if (n == 0) return ;
		int listSize = list.size();
		if ( n == listSize)
		{
			System.out.println(list);
			return ;
		}
		
		for (int i = 0 ; i < array.length ; i++)
		{
			if (visited[i] == false)
			{
				list.add(array[i]);
				visited[i] = true;
				permutation(array, n);
				visited[i] = false;
				list.remove(list.size() - 1);
			}
		}
	}
}
