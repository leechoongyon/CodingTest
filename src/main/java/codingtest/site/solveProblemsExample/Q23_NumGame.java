package codingtest.site.solveProblemsExample;

import java.util.ArrayList;

//desc : 배열의 홀수 번째의 합이 상대방, 배열의 짝수 번째의 합이 현우
//홀수 합 - 짝수 합 하면 답이겠지.

public class Q23_NumGame {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		int arrNum[] = new int[5];

		Q23_NumGame numGame = new Q23_NumGame();
		numGame.init(list);
		numGame.process(list, arrNum);
		numGame.printAll(arrNum);
	}

	public void init(ArrayList<Integer> list) {
		list.add(-1000);
		list.add(-2000);
		list.add(-3000);
		list.add(-4000);
		list.add(-5000);
	}

	public void process(ArrayList<Integer> list, int arrNum[]) {
		int pos = 0;

		while (list.size() != 0) {
			if (list.get(0) > list.get(list.size() - 1))
				arrNum[pos++] = list.remove(0);
			else
				arrNum[pos++] = list.remove(list.size() - 1);
		}
	}

	public void printAll(int arrNum[]) {
		for (int i = 0; i < arrNum.length; i++)
			System.out.println(arrNum[i]);
	}
}
