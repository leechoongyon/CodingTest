package codingtest.site.solveProblemsExample;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Q30_StrJoin {
	
	
	public static void main(String[] args) {
		
		Q30_StrJoin strJoin = new Q30_StrJoin();
		
		Scanner scan = new Scanner(System.in);
		
		int cases = scan.nextInt();
		
		int n = 0;
		
		
		for(int cc = 0 ; cc < cases; cc++) {
			n = scan.nextInt();
			int strLength[] = new int[n];
			for(int i = 0 ; i < n ; i++) 
				strLength[i] = scan.nextInt();
			/*Arrays.sort(strLength);
			strJoin.printAll(strLength);*/
			System.out.println("value : " + strJoin.greedAlgorithm(strLength));
			
		}
	}
	
	public void printAll(int strLength[]) {
		for(int i = 0 ; i < strLength.length ; i++)
			System.out.println(strLength[i]);
	}
	
	public int greedAlgorithm(int strLength[]) {
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>();
		
		int min1 = 0;
		int min2 = 0;
		int ret = 0;
		
		for(int i = 0 ; i < strLength.length ; i++)
			priorityQueue.add(strLength[i]);
		while(priorityQueue.size() > 1) {
			min1 = priorityQueue.poll();
			min2 = priorityQueue.poll();
			priorityQueue.add(min1+min2);
			ret += min1 + min2;
		}
			
		return ret;
	}
}
