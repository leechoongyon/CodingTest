package codingtest.site.algospot.ch06;

import java.util.Scanner;


/**

1
URLPM
XPRET
GIAET
XTNZY
XOQRS
6
PRETTY
GIRL
REPEAT
KARA
PANDORA
GIAZAPX

1
NNNNN
NEEEN
NEYEN
NEEEN
NSNNN
1
YES
 */

public class Boggle
{
	private static int cache[][][]; 
	private static char findWord[] = null;
	private static char board[][] = null;
	private static final int[] dx = {1, 1, 1, -1, -1, -1, 0, 0};
    private static final int[] dy = {0, -1, 1, 0, -1, 1, 1, -1}; 
	
	public static void main(String [] args)
	{
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		for (int i = 0 ; i < t ; i++)
		{
			board = new char[5][5];
			/** board 입력 */
			for (int r = 0 ; r < 5 ; r++)
			{
				String s = scan.next();
				board[r][0] =  s.charAt(0);
				board[r][1] =  s.charAt(1);
				board[r][2] =  s.charAt(2);
				board[r][3] =  s.charAt(3);
				board[r][4] =  s.charAt(4);
			}
			
			/** find word */
			int k = scan.nextInt();
			for (int j = 0 ; j < k ; j++)
			{
				findWord = scan.next().toCharArray();
				cache = new int[5][5][findWord.length + 1];
				System.out.println(new String(findWord) + " " + (hasWord() ? "YES" : "NO"));
			}
		}
	}

	private static boolean hasWord()
	{
		for (int r = 0 ; r < 5 ; r++)
		{
			for (int c = 0 ; c < 5 ; c++)
			{
				if (hasWord(r,c,0)) return true;
			}
		}
		return false;
	}
	
	private static boolean hasWord(int r, int c, int pos)
	{
		int x, y;
		
		/** validate */
		if (r < 0 || r >= 5 || c < 0 || c >= 5) return false;

		/** 기저 사례 */
		if (findWord.length == pos) return true;
		
		if (board[r][c] != findWord[pos]) return false;
		
		/** cache */
		if (cache[r][c][pos] != 0) return cache[r][c][pos] > 0;
		
		for (int i = 0 ; i < dx.length ; i++)
		{
			x = r + dx[i];
			y = c + dy[i];
			if (hasWord(x, y, pos + 1)) 
			{
				cache[r][c][pos] = 1;
				return true;
			}
		}
		cache[r][c][pos] = -1;
		return false;
	}
}	