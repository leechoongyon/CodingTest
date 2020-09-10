package codingtest.site.codingDoJang;

import java.util.ArrayList;

public class Problem4_Josephus_Problem {
	public static void main(String[] args) {
		
		int k = 3;

		ArrayList<Integer> arrList = new ArrayList<Integer>();

		// 1. Initial

		for(int i = 1; i <= 10; i++)
			arrList.add(i);
		
		// 2. process

		int arrListSize = arrList.size();
		int pos = 0;

		while(arrListSize > 1) {
			System.out.println(arrList);
			if(((pos + k) % arrListSize) - 1 < 0)
				pos = arrListSize - 1;
			else
				pos = ((pos + k) % arrListSize)  - 1;
			System.out.println(arrList.remove(pos));
			arrListSize--;
		}
	}
}
