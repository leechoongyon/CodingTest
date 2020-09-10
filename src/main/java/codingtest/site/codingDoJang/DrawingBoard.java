package codingtest.site.codingDoJang;

public class DrawingBoard {
	
	public static void main(String[] args) {

		// board 
		int board[][] = 
			{  
					{0,0,0,0,0,0,0,0,0,0},
					{0,0,0,0,0,0,1,0,0,0},
					{0,0,0,0,1,1,0,1,0,0},
					{0,0,1,1,0,0,0,0,1,0},
					{0,1,0,0,0,0,0,0,1,0},
					{0,1,0,0,0,0,0,0,1,0},
					{0,1,0,0,0,0,0,1,0,0},
					{0,0,1,0,0,0,1,0,0,0},
					{0,0,0,1,0,1,1,0,0,0},
					{0,0,0,0,0,0,0,0,0,0} 
			};
	
		// start point
		int x = 5, y = 5;
		
		// color
		int changeColor = 3;
		int beforeColor = board[x][y];
		
		fill(board, x, y, beforeColor, changeColor);
		
		print(board);
	}
	
	private static void fill(int board[][], int x, int y, int beforeColor, int changeColor) {
		
		// 기저사례
	
		if (board[x][y] == beforeColor) 
			board[x][y] = changeColor;
		else return;
		
		if (x-1 != -1)	fill(board, x-1, y, beforeColor, changeColor);
		if (x+1 != board.length) fill(board, x+1, y, beforeColor, changeColor);
		if (y-1 != -1) fill(board, x, y-1, beforeColor, changeColor);
		if (y+1 != board.length) fill(board, x, y+1, beforeColor, changeColor);
	}
	
	private static void print(int board[][]) {
		
		// 정사각형이라 가정
		int width = board.length, height = board.length;
		
		for (int x = 0 ; x < width ; x++) {
			for (int y = 0 ; y < height ; y++)
				System.out.print(board[x][y]);
			System.out.println();
		}
		
	}
}
