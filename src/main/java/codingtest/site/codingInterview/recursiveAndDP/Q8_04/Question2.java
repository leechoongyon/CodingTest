package codingtest.site.codingInterview.recursiveAndDP.Q8_04;

import java.util.ArrayList;
import java.util.List;

public class Question2
{
	private static List<String> list = new ArrayList<String>();
	
	public static void main(String [] args)
	{
		String array[] = {"a","b","c","d"};
		getSubSet(array);
		for (String subSet : list)
		{
			System.out.println(subSet);
		}
	}
	
	/**
	 * 	1. P(n) 과 p(n-1) 의 관계
	 * 		1.1 P(0) = {''}
	 * 		1.2 P(1) = {'', '1'}
	 * 		1.3 P(2) = {'', '1', '2', '1,2'}
	 * 	2. 
	 */
	public static void getSubSet(String array[])
	{
		for (int i = 0 ; i < array.length ; i++)
		{
			if (list.size() == 0)
			{
				list.add(" ");
				list.add(array[i]);
				continue;
			}
			
			int listLength = list.size();
			for (int j = 0 ; j < listLength ; j++)
			{
				if (list.get(j) == " ") list.add(array[i]);
				else list.add(list.get(j) + "," + array[i]);
			}
		}
	}
}
