package codingtest.site.codingDoJang;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * @file		codingDoJang.Sudoku.java
 * @filetype	java source file
 * @brief
 * @author		lee
 * @version		0.1
 * @history
 * 버전			성명			일자			변경내용
 * 0.1			lee		2015. 7. 7.		신규작성
 *
 *	
 *	스도쿠 규칙
 *
 *	1. 어떤 가로줄에도 같은 숫자가 나타나지 않는다. 바꿔 말하면, 어떤 가로줄에도 1부터 9까지 아홉 개의 숫자가 모두 나타난다.
 *	2. 어떤 세로줄에도 같은 숫자가 나타나지 않는다. 즉, 어떤 세로줄에도 아홉 개의 숫자가 모두 나타난다.
 *	3. 굵은 테두리를 두른, 가로 세로 3칸인 작은 정사각형에도 같은 숫자가 나타나지 않는다. 즉, 아홉 개의 숫자가 모두 나타난다.
 *	
 * 	* 가로, 세로 합이 45
 * 	* horizontal line, vertical line number sum = 45
 * 	* but, Each diagonal line sum not same.
 * 
 * 
 * 	순서
 *  
 *  1. 파일을 읽어 들여 Model로 변환 (어떤 Model을 사용하지?)
 *  2. 
 *  
 *  
 *  현재 이 로직은 답이 1개가 아니라 여러개가 나올 경우 무한 루프를 돌아버린다.
 *  
 *  내가 임의로 랜덤 값을 넣어서 처리할 수 있으나 그럴경우 로직이 너무 지저분해진다.
 *  
 *  
>>>>>>> branch 'master' of https://github.com/leechoongyon/Passion.git
 *
 */
public class Sudoku 
{
	public static void main(String[] args) 
	{
		int n = 9;
		int board[][] = new int[n][n];
		
		// 1. unmarshal (file -> object)
		String filePath = System.getProperty("user.dir") + "/file/input";
		String fileName = "sample01";
		File file = new File(filePath, fileName);
		board = unmarshal(file);
		

		
		// 2. init ( board[i][j] == 0 -> Each mapList.add(1~9) )
		Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
		init(board, map);
		
		while(isComplete(board))
		{   
			// 3. board[i][j] value check
			// if (board[i][j] == 0) -> search candidate 
			searchCandidate(board, map);
			
			// 4. search candidate
			// width, height, small square
			
			
			// 5. determines the value 
			// cacndidate.length == 1 -> board[i][j] = candidate
			List<Integer> numList = new ArrayList<Integer>();
			TreeMap<Integer, List<Integer>> treeMap = new TreeMap<Integer, List<Integer>>(map);
			Iterator<Integer> treeMapIter = treeMap.keySet().iterator();
			Integer i; 
			
			while (treeMapIter.hasNext())
			{
				i = treeMapIter.next();
				numList = map.get(i);
				if (numList.size() == 1) 
					board[i/10][i%10] = numList.get(0);
			}
		}
		
		System.out.println("### result ###");
		print(board);
	}

	public static boolean isComplete(int board[][])
	{
		int boardSize = board.length;
		
		for (int width = 0 ; width < boardSize ; width++)
		{
			for (int height = 0 ; height < boardSize ; height++)
			{
				if (board[width][height] == 0)
					return true;
			}
		}
		
		return false;
	}
	
	public static void searchCandidate(int board[][], Map<Integer, List<Integer>> map)
	{
		int boardSize = board.length;
		List<Integer> list;
		for (int x = 0 ; x < boardSize ; x++)
		{
			for (int y = 0 ; y < boardSize ; y++)
			{
				if (board[x][y] == 0)
				{
					list = map.get(10 * x + y);
					// height
					for (int height = 0 ; height < boardSize ; height++)
					{
						if (board[x][height] != 0) 
						{
							list.remove((Integer) board[x][height]);
						}
					}
					
					// width
					for (int width = 0 ; width < boardSize ; width++)
					{
						if (board[width][y] != 0)
						{
							list.remove((Integer) board[width][y]);
						}
					}
					
					// small square
					for (int width = (x / 3) * 3 ; width < ((x / 3) + 1) * 3 ; width++)
					{
						for (int height = (y / 3) * 3 ; height < ((y / 3) + 1) * 3 ; height++)
						{
							if (board[width][height] != 0)
							{
								list.remove((Integer) board[width][height]);
							}
						}
					}
					
					
					
				}
					
				
					
			}
		}
	}
	
	public static void init(int board[][], Map<Integer, List<Integer>> mapList)
	{
		int boardSize = board.length;
		
		for (int x = 0 ; x < boardSize ; x++)
		{
			for (int y = 0 ; y < boardSize ; y++)
			{
				List<Integer> list = new ArrayList<Integer>();
				for (int t = 1 ; t < 10 ; t++)
					list.add(t);
				if (board[x][y] == 0)
					mapList.put(10 * x + y, list);
			}
		}
	}
	
	
	public static int[][] unmarshal(File file)
	{
		int board[][] = new int[9][9];
		BufferedReader in = null;
		int boardSize = board.length;
		int x = 0;
		String oneLine;
		try 
		{
			in = new BufferedReader(new FileReader(file));
			while ((oneLine = in.readLine()) != null)
			{
				if (oneLine.length() == 9) 
				{
					for (int y = 0 ; y < boardSize ; y++) 
						board[x][y] =  Character.getNumericValue(oneLine.charAt(y));
				}
				else 
					throw new RuntimeException("read one line length : " + oneLine.length() + "\nsudoku one line length : 9", null);
				// width++ , x = width / y = height
				x++;
			}
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally 
		{
			try { in.close(); } catch (IOException e) {	e.printStackTrace();}
		}
		return board;
	}
	
	public static void print(int board[][])
	{
		int boardSize = board.length;
		for (int i = 0 ; i < boardSize ; i++)
		{
			for (int j = 0 ; j < boardSize ; j++)
				System.out.print(board[i][j]);
			System.out.println();
		}
	}
}