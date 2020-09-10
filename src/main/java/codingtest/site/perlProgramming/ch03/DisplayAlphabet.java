package codingtest.site.perlProgramming.ch03;

public class DisplayAlphabet
{
	public static void main(String[] args)
	{
		int alphabet[][][] = new int[26][10][10];
		int i = 0;

		char input = 'a';

		for(char c = 'a' ; c <= 'z' ; c++)
			alphabet[i++][0][0] = (int) c;

		// a Setting
		alphabet[0][0][5] = (int) input;
		alphabet[0][1][4] = (int) input;

		for(int j = 0 ; j < 26 ; j++)
		{
			if((char) alphabet[j][0][0] == input)
			{
				System.out.println("출력 : " + input);
			}	
		}
	}
}
