package codingtest.site.codingDoJang;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @file		codingDoJang.TicTacToeGame.java
 * @filetype	java source file
 * @brief
 * @author		lee
 * @version		0.1
 * @history
 * 버전			성명			일자			변경내용
 * 0.1			lee		2015. 7. 3.		신규작성
 *
 *
 *	Simple is best
 *
 *	3 * 3 BingGo
 * 	
 * 	consider expandability
 * 	ex) 4 * 4, 5 * 5 etc...
 *
 */

public class TicTacToeGame {
	
	public static void main(String[] args) {
	
		int width = 3;
		int height = 3;
		
		char board[][] = new char[width][height];
		
		// 1. 입력 값 만들기
		List<String> inputList = init();
		
		// 2. 입력 값 넣기.
		
		char mark = 'O';
		
		for (String in : inputList) {
			String tmp[] = in.split(",");
			int index[] = {Integer.parseInt(tmp[0]), Integer.parseInt(tmp[1])};
			
			board [index[0]][index[1]] = mark;
			
			if (isComplete(board, index[0], index[1], mark)) {
				print(board);
				System.out.println("Winner is : " + mark);
				return;
			}
				
			if (mark == 'O') mark = 'X';
			else mark = 'O';
		}

		/* when logic is reached, result is draw */
		
		/* print board */
		print(board);
		System.out.println("result : draw");
	}
	
	public static void print(char board[][]) {
		for (int i = 0 ; i < 3; i++) {
			for (int j = 0 ; j < 3; j++)
				System.out.print(board[i][j] + "\t");
			System.out.println();
		}
	}
	
	public static boolean isComplete(char board[][], int width, int height, char mark) {
		
		// 경우의 수는 세로, 가로, 대각선이다.
		
		boolean result = true;
		
		// width
		for (int i = 0 ; i < 3; i++) {
			if (board[width][i] != mark) {
				result = false;
				break;
			} else if (i == 2)
				return true;
		}
		
		// height
		for (int i = 0 ; i < 3; i++) {
			if (board[i][height] != mark) {
				result = false;
				break;
			} else if (i == 2)
				return true;
				
		}

		// 
		if (board[0][0] == mark && board[1][1] == mark && board[2][2] == mark)
			return true;
		if (board[0][2] == mark && board[1][1] == mark && board[2][0] == mark)
			return true;
		
		return result; 
	}
	
	public static List<String> init() {
		
		List<String> ranInput = new ArrayList<String>();
		
		// 중복순열 만드는거랑 비슷한데?
		
		ranInput.add("0,0"); ranInput.add("0,1"); ranInput.add("0,2");
		ranInput.add("1,0"); ranInput.add("1,1"); ranInput.add("1,2");
		ranInput.add("2,0"); ranInput.add("2,1"); ranInput.add("2,2");
		
		Collections.shuffle(ranInput);
		
		return ranInput;
	}
	
}

