package codingtest.site.solveProblemsExample;

/**
 * @author	: 2013BWG-02
 * @date	: 2014. 11. 10.
 * @desc	:
 * 
 * 1. 둘 곳을 선택
 * 2. 이겼는지 Check
 * 3. Cache 사용
 */
public class Q28_TicTacToe {
	public static void main(String[] args) {
		
		char board[][] = new char[3][3];
		
		for(int i = 0 ; i < board.length ; i++)
			for(int j = 0 ; j < board[i].length ; j++)
				board[i][j] = ' ';
		
		Q28_TicTacToe ticTacToe = new Q28_TicTacToe();
		ticTacToe.process(board, 'X');
		
	}
	
	public void process(char board[][], char turn) {
		
		/*
		 *  * 전체적인 원리는 완전 탐색으로 전부 대입해봄.
		 * 
		 *  1. 빈 곳을 체크
		 *  2. 빈 곳에 Player 표시
		 *  3. Status 파악. (이김, 짐, 비김)
		 *  4. 
		 */

		if(check(board))
			
		
		for(int i = 0 ; i < board.length ; i++)
			for(int j = 0 ; j < board[i].length ; j++)
				if(board[i][j] == ' ') {
					board[i][j] = turn;
					
					if(turn == 'X')
						turn = 'O';
					else
						turn = 'X';
					printAll(board);
					process(board, turn);
					board[i][j] = ' ';
				}
		
	}
	
	public void printAll(char board[][]) {
		for(int i = 0 ; i < board.length ; i++) {
			for(int j = 0 ; j < board[i].length ; j++) {
				System.out.print(board[i][j]);
				
			}
			System.out.println();
		}
	}
	
	public boolean check(char board[][]) {
		
		// 한 줄을 만들었는지 반환
		
		return false;
		
	}
}
