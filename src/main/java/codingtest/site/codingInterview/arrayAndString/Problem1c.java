package codingtest.site.codingInterview.arrayAndString;

import java.util.Scanner;

public class Problem1c
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine();
		char chars[] = new char[128];
		int i = 0;
		for (char c : str.toCharArray())
			chars[i++] = c;
		solve(chars, str.length());
	}
	
	private static void solve(char chars[], int realLength)
	{
		/**
		 * sol1. 문자열 for 문 돌며, 새로운 배열에 집어넣기.
		 * 		 공백을 만나면 %20 넣어주기.
		 * 
		 * sol2. 배열안에서만 작업해야한다면.
		 * 		 공백을 만나면 밀어줘야겠지.
		 * 		 앞에서부터 집어넣으면 덮어칠 수 있음.
		 * 		 뒤에서부터 넣는다. 
		 * 		 뒤에서부터 넣기 위해 전체 길이를 알아야 함.
		 * 
		 * 		시간 O(n) / 공간 O(1) - 이미 주어짐.
		 */
		
		int extraSpace = 0;
		for (int i = 0 ; i < realLength ; i++)
		{
			if (chars[i] == ' ')
				extraSpace += 2;
		}
		int index = realLength + extraSpace;
		for (int i = realLength - 1 ; i >= 0 ; i--)
		{
			if (chars[i] == ' ')
			{
				chars[index - 1] = '0';
				chars[index - 2] = '2';
				chars[index - 3] = '%';
				index = index -3;
			}
			else
			{
				chars[index -1] = chars[i];
				index--;
			}
		}
		
		// result
		for (char c : chars)
		{
			if (c == ' ') return ;
			System.out.print(c);
		}
	}
}
