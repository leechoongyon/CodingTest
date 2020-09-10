package codingtest.site.perlProgramming.ch02;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternCount
{
	public static String PatternCount(String str)
	{
		str = str.toLowerCase();
		
		StringBuilder strBuilder = new StringBuilder();

		char alphabet = 'a';

		for (alphabet = 'a' ; alphabet <= 'z' ; alphabet++)
		{
			Pattern p = Pattern.compile(Character.toString(alphabet));
			Matcher m = p.matcher(str);

			int count = 0;
		
			for (int i = 0 ; m.find(i) ; i = m.end())
				count++;
			
			if(count != 0)
				strBuilder.append((alphabet + "" + count));
		}

		return strBuilder.toString();
	}
}
