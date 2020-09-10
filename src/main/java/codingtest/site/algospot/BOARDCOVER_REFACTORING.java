package codingtest.site.algospot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOARDCOVER_REFACTORING {
	private static final int BLOCK_COUNTER = 4;
	private static int[][][] sBlocks = { { { 0, 1 }, { 1, 1 } }, { { 0, 1 }, { 1, 0 } }, { { 1, 0 }, { 1, 1 } },
			{ { 1, 0 }, { 1, -1 } } };
	private static int sWidth;
	private static int sHeight;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int cNum = Integer.parseInt(br.readLine().trim());
		for (int i = 0; i < cNum; i++) {
			st = new StringTokenizer(br.readLine().trim(), " ");
			sHeight = Integer.parseInt(st.nextToken());
			sWidth = Integer.parseInt(st.nextToken());
			int[][] board = new int[sHeight][sWidth];
			int blankCnt = 0;
			for (int j = 0; j < sHeight; j++) {
				char[] tmpArr = br.readLine().trim().toCharArray();
				for (int k = 0; k < sWidth; k++) {
					if (tmpArr[k] == '.') {
						board[j][k] = 1;
						blankCnt++;
					}
				}
			}
			if (blankCnt % 3 != 0)
				System.out.println("0");
			else
				System.out.println(solve(board, blankCnt / 3, 0, 0));
		}
		br.close();
	}

	private static int solve(int[][] board, int blockCapacity, int x, int y) {
		int ret = 0;
		if (blockCapacity == 0)
			return 1;
		if (sWidth == y) {
			x += 1;
			y = 0;
		}
		if (sHeight == x)
			return 0;
		if (board[x][y] == 0)
			return solve(board, blockCapacity, x, y + 1);
		else if (board[x][y] == 1) {
			for (int i = 0; i < BLOCK_COUNTER; i++) {
				if (x + sBlocks[i][0][0] < 0 || y + sBlocks[i][0][1] < 0 || x + sBlocks[i][0][0] >= sHeight
						|| y + sBlocks[i][0][1] >= sWidth || x + sBlocks[i][1][0] < 0 || y + sBlocks[i][1][1] < 0
						|| x + sBlocks[i][1][0] >= sHeight || y + sBlocks[i][1][1] >= sWidth)
					continue;
				if (board[x + sBlocks[i][0][0]][y + sBlocks[i][0][1]] == 1
						&& board[x + sBlocks[i][1][0]][y + sBlocks[i][1][1]] == 1) {
					board[x + sBlocks[i][0][0]][y
							+ sBlocks[i][0][1]] = board[x + sBlocks[i][1][0]][y + sBlocks[i][1][1]] = board[x][y] = 0;
					ret += solve(board, blockCapacity - 1, x, y + 1);
					board[x + sBlocks[i][0][0]][y
							+ sBlocks[i][0][1]] = board[x + sBlocks[i][1][0]][y + sBlocks[i][1][1]] = board[x][y] = 1;
				}
			}
		}
		return ret;
	}
}
