package codingtest.site.solveProblemsExample;

import java.util.Scanner;

/**
 * @author	: 2013BWG-02
 * @date	: 2014. 11. 11.
 * @desc	:
 * 
 * 1. 먹는 시간 오름차순 정렬
 * 2. 오름차순 순으로 데우는 순서 결정
 * 3. 결정된 순서대로 Max 시간을 메겨봄. (이 때, Max 시간은 총 데우는 시간을 넘어서면 Max값이 바뀌는 로직이다.)
 *  
 */
public class Q29_LunchBox {

	static int cases = 0;
	static int n = 0;
	
	static int heatingTime[] = new int[10000];
	static int eatingTime[] = new int[10000];
	
	public static void main(String[] args) {
	
		Q29_LunchBox lunchBox = new Q29_LunchBox();
		
		Scanner scan = new Scanner(System.in);
		
		cases = scan.nextInt();
		
		for(int cc = 0 ; cc < cases; cc++) {
			n = scan.nextInt();
			
			for(int i = 0 ; i < n ; i++) heatingTime[i] = scan.nextInt();
			for(int i = 0 ; i < n ; i++) eatingTime[i] = scan.nextInt();
			
			lunchBox.sorting(heatingTime, eatingTime);
			lunchBox.solve();
		}
		
	}
	
	public void init(int heatingTime[], int eatingTime[]) {
		
		heatingTime[0] = 3; heatingTime[1] = 2; heatingTime[2] = 1;
		eatingTime[0] = 1; eatingTime[1] = 2; eatingTime[2] = 3;
		
	}
	
	public void solve() {
	
		int totalHeatingTime = 0;
		int intermediateState = 0;
		int max = 0;
		
		for(int i = 0 ; i < heatingTime.length ; i++)
			totalHeatingTime += heatingTime[i];
		
		for(int i = 0 ; i < eatingTime.length ; i++) {
			
			intermediateState += heatingTime[i];
			
			max = Math.max(max, intermediateState + eatingTime[i]);
		}
		
		System.out.println("max : " + max);
	}
	
	public void sorting(int heatingTime[], int eatingTime[]) {
		for (int i=0; i< eatingTime.length ; i++) {
			boolean changed = false;
			
			for (int j=0; j< eatingTime.length-1-i ; j++) {
				if (eatingTime[j] < eatingTime[j+1]) { //버블정렬이 적용되는 조건문
					int temp = eatingTime[j];
					eatingTime[j] = eatingTime[j+1];
					eatingTime[j+1] = temp;
					
					temp = heatingTime[j];
					heatingTime[j] = heatingTime[j+1];
					heatingTime[j+1] = temp;
					changed = true;
				} //end if
			} // end for j
			
			if (!changed) break; // 자리바꿈이 없으면 반복문을 벗어난다.
			
		} //end for i
	}
}