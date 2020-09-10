package codingtest.site.perlProgramming.ch03;

public class FindWordRule
{
	public static void main(String[] args)
	{
		String str = "clinicclinic";
		String [] rule = {"n-ic", "t-ic", "i-cc"};

	for(int i = 0 ; i < str.length() ; i++)
	{
		if(str.charAt(i) == 'c' && i != 0)
		{
			for(int j = 0 ; j < rule.length ; j++)
			{
				if(compareSpecificWord(str, rule[j], i).equals("discord"))
					System.out.println("규칙 불일치");
				else
					System.out.println("규칙 일치");
			}
		}
	}
}

	public static String compareSpecificWord(String input, String specificWord, int offset)
	{
		specificWord = deleteSpecificWord(specificWord, '-');

		if(input.substring(offset - specificWord.length() +1, offset + 1).compareTo(specificWord) == 0)
			return specificWord;

		return "discord";
	}

	public static String deleteSpecificWord(String str, char deleteWord)
	{
		String newStr = "";
	
		for (int i = 0 ; i < str.length() ; i++)
		{
			if(!(str.charAt(i) == deleteWord))
			{
				newStr += str.charAt(i);
			}
		}
	
		return newStr;
	}
}
