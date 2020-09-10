package codingtest.site.solveProblemsExample;

/**
 * @author	: 2013BWG-02
 * @date	: 2014. 8. 20.
 * @desc	: /* 알고리즘
 * 문제의 의도는 어떤 문장을 단어별로 인식한 결과가 주어졌을 때, 원본일 조건부 확률이 가장 높은 문장을 찾아내는
 * 프로그램을 작성하라.
 *
 * P(Q|R) = P(Q) 교집합 P(R) / P(R)
 * P(R)은 모든 것들이 똑같고 Q만 임의니 Q만 최대치로 잡아 계산해주면 답이 나오겠지.
*/	

public class Q18_OCR {
	static double cache[][] = new double[10][10];
	static double nextWordApperanceChance[][] = new double[5][5];
	static double classificationChance[][] = new double[5][5];
	static String R[] = { "I", "am", "a", "buy" };
	static double choices[][] = new double[5][5];

	public static void main(String[] args) {
		new Q18_OCR().init();

		double maxChance = new Q18_OCR().OCR(1, 0);

		System.out.println("MaxChance : " + maxChance);

		System.out.println("Choices[1][0] : " + choices[1][0]);
		System.out.println("Choices[2][1] : " + choices[2][1]);
		System.out.println("Choices[3][2] : " + choices[3][2]);
	}

	public double OCR(int segment, int previousMatch) {
		if (segment == R.length)
			return 0;

		if (cache[segment][previousMatch] != 0)
			return cache[segment][previousMatch];

		for (int thisMatch = 0; thisMatch < R.length; thisMatch++) {
			double cand = Math
					.max(cache[segment][previousMatch],
							OCR(segment + 1, thisMatch)
									+ (nextWordApperanceChance[previousMatch][thisMatch] * classificationChance[thisMatch][segment]));

			if (cand > cache[segment][previousMatch]) {
				cache[segment][previousMatch] = cand;
				choices[segment][previousMatch] = thisMatch;
			}
		}

		return cache[segment][previousMatch];
	}

	public void init() {
		nextWordApperanceChance[0][0] = 0.1;
		nextWordApperanceChance[0][1] = 0.6;
		nextWordApperanceChance[0][2] = 0.1;
		nextWordApperanceChance[0][3] = 0.1;
		nextWordApperanceChance[0][4] = 0.1;

		nextWordApperanceChance[1][0] = 0.1;
		nextWordApperanceChance[1][1] = 0.1;
		nextWordApperanceChance[1][2] = 0.6;
		nextWordApperanceChance[1][3] = 0.1;
		nextWordApperanceChance[1][4] = 0.1;

		nextWordApperanceChance[2][0] = 0.1;
		nextWordApperanceChance[2][1] = 0.1;
		nextWordApperanceChance[2][2] = 0.1;
		nextWordApperanceChance[2][3] = 0.6;
		nextWordApperanceChance[2][4] = 0.1;

		nextWordApperanceChance[3][0] = 0.2;
		nextWordApperanceChance[3][1] = 0.2;
		nextWordApperanceChance[3][2] = 0.2;
		nextWordApperanceChance[3][3] = 0.2;
		nextWordApperanceChance[3][4] = 0.2;

		nextWordApperanceChance[4][0] = 0.2;
		nextWordApperanceChance[4][1] = 0.2;
		nextWordApperanceChance[4][2] = 0.2;
		nextWordApperanceChance[4][3] = 0.2;
		nextWordApperanceChance[4][4] = 0.2;

		classificationChance[0][0] = 0.8;
		classificationChance[0][1] = 0.1;
		classificationChance[0][2] = 0.0;
		classificationChance[0][3] = 0.1;
		classificationChance[0][4] = 0.0;

		classificationChance[1][0] = 0.1;
		classificationChance[1][1] = 0.7;
		classificationChance[1][2] = 0.0;
		classificationChance[1][3] = 0.2;
		classificationChance[1][4] = 0.0;

		classificationChance[2][0] = 0.0;
		classificationChance[2][1] = 0.1;
		classificationChance[2][2] = 0.8;
		classificationChance[2][3] = 0.0;
		classificationChance[2][4] = 0.1;

		classificationChance[3][0] = 0.0;
		classificationChance[3][1] = 0.0;
		classificationChance[3][2] = 0.0;
		classificationChance[3][3] = 0.5;
		classificationChance[3][4] = 0.5;

		classificationChance[4][0] = 0.0;
		classificationChance[4][1] = 0.0;
		classificationChance[4][2] = 0.0;
		classificationChance[4][3] = 0.5;
		classificationChance[4][4] = 0.5;

	}

}
