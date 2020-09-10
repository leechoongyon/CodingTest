package codingtest.site.algospot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/**
 * @file		algospot.BOARDCOVER.java
 * @filetype	java source file
 * @brief
 * @author		lee
 * @version		0.1
 * @history
 * 버전			성명			일자			변경내용
 * 0.1			lee		2015. 9. 4.		신규작성
 *
 
3 
3 7 
#.....# 
#.....# 
##...## 
3 7 
#.....# 
#.....# 
##..### 
8 10 
########## 
#........# 
#........# 
#........# 
#........# 
#........# 
#........# 
########## 

출력
0
2
1514

1
3 7
#.....# 
#.....# 
##...##

0

1
3 7 
#.....# 
#.....# 
##..### 

2

1
8 10 
########## 
#........# 
#........# 
#........# 
#........# 
#........# 
#........# 
########## 

 */


public class BOARDCOVER 
{
	public static void main(String[] args) throws IOException 
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
        int cNum = Integer.parseInt(br.readLine().trim());
        for (int i = 0 ; i < cNum ; i++)
        {
        	st = new StringTokenizer(br.readLine().trim(), " ");
        	int w = Integer.parseInt(st.nextToken());
        	int h = Integer.parseInt(st.nextToken());
        	char [][] board = new char[w][h];
        	for (int j = 0 ; j < w ; j++)
        	{
        		int index = 0;
        		String line = br.readLine();
        		for (int k = 0 ; k < h ; k++)
        			board[j][k] = line.charAt(index++);
        		
        	}
        	System.out.println(solve(board, w, h));
        }
	}
	
	public static int solve(char [][] board, int widthSize, int heightSize) 
	{
		int sum = 0;
		
		/*print(board, widthSize, heightSize);*/
		
		// 1. find index
		
		int width = -1, height = -1;
		
		for(int i = 0 ; i < widthSize ; i++)
		{
			for(int j = 0 ; j < heightSize ; j++)
			{
				
				if((board[i][j] == '.'))
				{
					width = i; height = j;
					break;
				}
			}
			
			if(width != -1 && height != -1)
				break;
		}
		
		
		// 2. recursive Stopping Criteria
		
		if(width == -1 && height == -1)
		{
			/*System.out.println("Combination Success.");*/
			return 1;
		}

		
		if(width+1 <= widthSize && height+1 <= heightSize && board[width][height+1] == '.' && board[width+1][height] == '.')
		{
			
			board[width][height+1] = '#'; board[width+1][height] = '#'; board[width][height] = '#';
			sum += solve(board, widthSize, heightSize);
			board[width][height+1] = '.'; board[width+1][height] = '.'; board[width][height] = '.';
		}
		
		if(width+1 != widthSize && height+1 != heightSize && board[width+1][height] == '.' && board[width+1][height+1] == '.')
		{
			
			board[width+1][height] = '#'; board[width+1][height+1] = '#'; board[width][height] = '#';
			sum += solve(board, widthSize, heightSize);
			board[width+1][height] = '.'; board[width+1][height+1] = '.'; board[width][height] = '.';
		}
		
		if(width+1 != widthSize && height+1 != heightSize && board[width+1][height] == '.' && board[width+1][height-1] == '.')
		{
			
			board[width+1][height] = '#'; board[width+1][height-1] = '#'; board[width][height] = '#';
			sum += solve(board, widthSize, heightSize);
			board[width+1][height] = '.'; board[width+1][height-1] = '.'; board[width][height] = '.';
		}
		
		if(width+1 != widthSize && height+1 != heightSize && board[width][height+1] == '.' && board[width+1][height+1] == '.')
		{
			board[width][height+1] = '#'; board[width+1][height+1] = '#'; board[width][height] = '#';
			sum += solve(board, widthSize, heightSize);
			board[width][height+1] = '.'; board[width+1][height+1] = '.'; board[width][height] = '.';
		}
		
		return sum;
		
				
	}
	
	public static boolean isCanCoverd(char [][]board, int i, int j)
	{
		return board[i][j] == '.';
	}
	
	public static boolean isCoverd(char [][]board, int i, int j)
	{
		return board[i][j] == '#';
	}
	
	public static boolean isCompleted(char [][] board, int heightSize, int widthSize)
	{
		for (int i = 0 ; i < heightSize ; i++)
		{
			for (int j = 0 ; j < widthSize ; j++)
			{
				if (!isCoverd(board, i, j))
					return false;
			}
		}
		return true;
	}
	
	
	
	public static void print(char [][]board, int height, int width)
	{
		System.out.println("---print start---");
		for (int i = 0 ; i < height ; i++)
		{
			for (int j = 0 ; j < width ; j++)
				System.out.print(board[i][j]);
			System.out.println();
		}
		System.out.println("---print end---");
		System.out.println();
	}
}
