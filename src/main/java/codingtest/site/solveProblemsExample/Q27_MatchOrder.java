package codingtest.site.solveProblemsExample;

import java.util.ArrayList;


/**
 * @author	: 2013BWG-02
 * @date	: 2014. 10. 25.
 * @desc	: //지금 이건 내가 생각하는 탐욕적 알고리즘을 구현해본 것이다. 즉, 최고의 답은 아니라는 것이다.
 * 			  //소스를 간략히 설명하면 한국팀을 정렬해놓고 순서대로 비교해서 러시아팀보다 레이팅이 높지만 한국팀에서 가장 작은애를 배열에 저장
 *
 */
public class Q27_MatchOrder {
	ArrayList<Integer> arrListKorean = new ArrayList<Integer>();

	public static void main(String[] args) {
		int arrRussia[] = new int[6];
		int arrKorean[] = new int[6];

		Q27_MatchOrder matchOrder = new Q27_MatchOrder();
		matchOrder.init(arrRussia);
		matchOrder.process(arrRussia, arrKorean);
		matchOrder.printAll(arrKorean);
	}

	public void init(int arrRussia[]) {
		arrRussia[0] = 3000; arrRussia[1] = 2700; arrRussia[2] = 2800; arrRussia[3] = 2200; arrRussia[4] = 2500;
		arrRussia[5] = 1900;
		arrListKorean.add(1800); arrListKorean.add(2000); arrListKorean.add(2600); arrListKorean.add(2750);
		arrListKorean.add(2800); arrListKorean.add(2995);
	}

	public void process(int arrRussia[], int arrKorean[]) {
		
		int minValue = Integer.MAX_VALUE;
	
		for(int i = 0 ; i < arrRussia.length ; i++) {
			for(int j = 0 ; j < arrListKorean.size() ; j++) {
				if(arrRussia[i] < arrListKorean.get(j)) {
					arrKorean[i] = arrListKorean.get(j);
					arrListKorean.remove(j);
					break;
				}
			}
		}
	}

	public void printAll(int arrKorean[]) {
		for(int i = 0 ; i < arrKorean.length ; i++) 
			System.out.println(arrKorean[i]);
	}
}

