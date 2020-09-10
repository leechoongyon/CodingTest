package codingtest.site.codingInterview.sort.Q10_02;

import java.util.Arrays;
import java.util.Comparator;

public class Question
{
	public static void main(String [] args)
	{
		String array[] = {"acb", "def", "fejq", "wfkj", "abkw"};
		Arrays.sort(array, new AnggramComparator());
		for (String s : array)
			System.out.print(s + " ");
	}
	
	public static class AnggramComparator implements Comparator<String>
	{
		public String sortChars(String s)
		{
			System.out.println("input : " + s);
			char content[] = s.toCharArray();
			Arrays.sort(content);
			for (char c : content)
				System.out.print(c + " ");
			System.out.println();
			return new String(content);
		}
		
		public int compare(String s1, String s2)
		{
			return sortChars(s1).compareTo(sortChars(s2));
		}
	}
}
