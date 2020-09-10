package codingtest.site.codingDoJang;

/**
 * @author	: 2013BWG-02
 * @date	: 2014. 11. 10.
 * @desc	:
 * 
 * 전체적인 원리는 width(가로) 0부터 시작하여 완전탐색을 시작하는 것임.
 * 퀸을 놓을수 없는 것을 int [][]로 표시한 이유는 boolean표시했다간 이전 정보가 싹 다 날라가버림.
 * 그러니 숫자로 +1씩 count하여 계산.
 * 
 */
public class Problem11_Eightqueens {

	static int n = 8;

	public static void main(String[] args) {
		int board[][] = new int[n][n];
		Problem11_Eightqueens eightQueens = new Problem11_Eightqueens();
		int count = eightQueens.Eightqueens(board,0);

		System.out.println("count : " + count);
	}

	public int Eightqueens(int board[][], int width) {

		int count = 0;

		if(width == board.length)
			return 1;
		for(int height = 0 ; height < board[width].length ; height++) {
			if(board[width][height] >= 1)
				continue;
			markStatus(board,width,height);
			count += Eightqueens(board,width+1);
			unMarkStatus(board,width,height);
		}
		return count;
	}

	public void markStatus(int board[][], int i, int j) {
		
		for(int k = 0 ; k < board.length ; k++) {
			board[i][k] += 1; board[k][j] += 1;
		}

		for(int k = 0; k < board.length ; k++) {
			if(i+k == board.length || j+k == board.length)
				break;
			board[i+k][j+k] += 1;
		}

		for(int k = 0 ; k < board.length ; k++) {
			if(i-k == -1 || j-k == -1)
				break;
			board[i-k][j-k] += 1;
		}

		for(int k = 0 ; k < board.length ; k++) {
			if(i+k == board.length || j-k == -1)
				break;
			board[i+k][j-k] += 1;
		}
		
		for(int k = 0 ; k < board.length ; k++) {
			if(i-k == -1 || j+k == board.length)
				break;
			board[i-k][j+k] += 1;
		}
		
//		System.out.println("board[" + i + "][" + j + "] : " + board[i][j]);
//		printAll(board);
	}

	public void unMarkStatus(int board[][], int i, int j) {

		for(int k = 0 ; k < board.length ; k++) {
			board[i][k] -= 1; board[k][j] -= 1;
		}

		for(int k = 0; k < board.length ; k++) {
			if(i+k == board.length || j+k == board.length)
				break;
			board[i+k][j+k] -= 1;
		}

		for(int k = 0 ; k < board.length ; k++) {
			if(i-k == -1 || j-k == -1)
				break;
			board[i-k][j-k] -= 1;
		}

		for(int k = 0 ; k < board.length ; k++) {
			if(i+k == board.length || j-k == -1)
				break;
			board[i+k][j-k] -= 1;
		}
		
		for(int k = 0 ; k < board.length ; k++) {
			if(i-k == -1 || j+k == board.length)
				break;
			board[i-k][j+k] -= 1;
		}
		
//		System.out.println("board[" + i + "][" + j + "] : " + board[i][j]);
//		printAll(board);
	}

	public void printAll(int board[][]) {
		for(int i = 0 ; i < board.length ; i++) {
			for(int j = 0 ; j < board[i].length ; j++) {
				if(board[i][j] >= 1)
					System.out.print("#");
				else
					System.out.print("-");
			}
			System.out.println();
		}
	}
}

