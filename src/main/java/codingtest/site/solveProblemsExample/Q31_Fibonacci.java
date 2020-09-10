package codingtest.site.solveProblemsExample;

public class Q31_Fibonacci {
	public static void main(String[] args) {
		Q31_Fibonacci fibonacci = new Q31_Fibonacci();
		int answer = fibonacci.fib(5);
		System.out.println("answer : " + answer);
	}
	
	// 윈도우 기법을 이용함.
	// 어차피 seq[n]만 계산하면 되니 나머지를 저장해둘필요 없이 2개의 값만 저장해두면 됨.
	// 이렇게 함으로써 메모리 절약을 할 수 있음.
	
	public int fib(int n) {
		if( n <= 1) return n;
		int seq[] = new int[3];
		seq[0] = 0;
		seq[1] = 1;
		for(int i = 2 ; i <= n ; i++)
			seq[i % 3] = (seq[(i - 1) % 3] + seq[(i - 2) % 3]) % 100000;
		return seq[n % 3];
	}
}
