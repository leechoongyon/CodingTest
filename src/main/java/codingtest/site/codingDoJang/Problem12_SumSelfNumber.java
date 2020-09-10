package codingtest.site.codingDoJang;

public class Problem12_SumSelfNumber {
	public static void main(String[] args) {
		
		Problem12_SumSelfNumber sumSelfNumber = new Problem12_SumSelfNumber();
		sumSelfNumber.process();
		
	}
	
	public void process() {
		
		// 1. 제너레이터 다 구하기.
		// 2. 1~5000 - 제너레이터 = 답
		
		boolean selfNum[] = new boolean[5000];
		
		int sum = 0;
		
		for(int i = 1 ; i < 5000 ; i++) {
			for(int j = 1 ; j < 5 ; j++) 
				sum += j;
		}
		
		System.out.println(sum);
	}
}
