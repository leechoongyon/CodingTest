package codingtest.site.codingDoJang;

/**
 * @author : 2013BWG-02
 * @date : 2014. 10. 6.
 * @desc : 정수들을 전부 boolean 타입에 저장. 그런 뒤 그 boolean을 처음부터 1개씩 굴려 true가 연속적인 것 중 제일
 *       큰 것을 찾기. 도중에 false나오면 skip하고 넘어가고 시작인덱스와 count는 반드시 해야겠지. 시간복잡도 n
 */
public class Problem3_LargestSubset {
	public static void main(String[] args) {

		boolean isNum[] = new boolean[11];
		int max = 0;

		Problem3_LargestSubset largestSubset = new Problem3_LargestSubset();
		largestSubset.init(isNum);
		max = largestSubset.process(isNum);

		System.out.println("max : " + max);
	}

	public void init(boolean isNum[]) {
		isNum[1] = true;
		isNum[4] = true;
		isNum[5] = true;
		isNum[6] = true;
		isNum[7] = true;
		isNum[9] = true;
		isNum[10] = true;
	}

	public int process(boolean isNum[]) {

		int count = 0;
		int max = 0;

		for (int i = 0; i < isNum.length; i++) {
			if (isNum[i] == true) {
				count++;
			} else {
				if (count > max)
					max = count;
				count = 0;
			}
		}

		return max;
	}
}
