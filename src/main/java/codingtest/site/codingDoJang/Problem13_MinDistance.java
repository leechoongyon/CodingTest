package codingtest.site.codingDoJang;

public class Problem13_MinDistance {
	public static void main(String[] args) {
		int s[] = {1,3,4,8,13,17,20,25,29,30,32,35,38,41,100};
		
		Problem13_MinDistance minDistance = new Problem13_MinDistance();
		minDistance.process(s);
	}
	
	public void process(int s[]) {
		
		int min = Integer.MAX_VALUE;
		int picked = 0;
		
		for(int i = 0 ; i < s.length - 1  ; i++) {
			if(s[i+1] - s[i] < min) {
				min = s[i+1] - s[i];
				picked = i;
			}
		}
		
		System.out.println("min : " + min);
		System.out.println("picked [" + s[picked] + "," + s[picked+1] + "]");
	}
}
