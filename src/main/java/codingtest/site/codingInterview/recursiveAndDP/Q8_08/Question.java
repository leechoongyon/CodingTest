package codingtest.site.codingInterview.recursiveAndDP.Q8_08;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Question
{
	private static final int ELEMENT_NUM = 5;
	private static boolean visited[] = new boolean[ELEMENT_NUM];
	private static List<String> list = new ArrayList<String>();
	private static Set<String> set = new HashSet<String>();
	
	public static void main(String [] args)
	{
		String array[] = new String[] {"a", "a", "a", "b", "a"};
		permutation(array);
		for (String s : set)
			System.out.println(s);
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
			set.add(list.toString());
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
