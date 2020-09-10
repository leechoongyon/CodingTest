package codingtest.site.codingDoJang;

/**
 * @author	: 2013BWG-02
 * @date	: 2014. 10. 25.
 * @desc	: 1. 유클리드

				최대공약수 구하는 공식 알기.
				A가 양수면 B는 음수여야겠지.

 */
public class Problem8_EuclideanAlgorithm {
	

		public static void main(String[] args) {
			int a = 4, b = 6;
			int d = 0;
			
			Problem8_EuclideanAlgorithm euclideanAlgorithm = new Problem8_EuclideanAlgorithm();
			d = euclideanAlgorithm.gcd(a,b);

			euclideanAlgorithm.process(a,b,d);
		}

		public void process(int a, int b, int d) {
			

			//y를 double로 쓰는 이유는 나머지를 구하기 위해서. int로 써버리면 나머지가 날라가버리네.
			double y =0 ;

			for(int x = 0; ; x--) {
				y = (double) (d - a*x) / b;
				if(y % 1.0 == 0.0) {
					System.out.println("x : " + x + " \t y : " + y + " \t d : " + d + " \t |A| + |B| = " + Math.abs(x) + Math.abs(y));
					break;
				}
			}
		}

		public int gcd(int p, int q) {
			if(q == 0) return p;
				return gcd(q, p%q);
		}
	}

