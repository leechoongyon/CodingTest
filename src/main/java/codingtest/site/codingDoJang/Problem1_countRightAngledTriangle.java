package codingtest.site.codingDoJang;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Problem1_countRightAngledTriangle {
	public static void main(String[] args) {
		Problem1_countRightAngledTriangle c = new Problem1_countRightAngledTriangle();
		c.answerOne(1000);
	}

	public void answerOne(int n) {

		int a = 0;
		double c = 0.0;
		int p = n/2;    // a+b > c , a+b+c < p,  a<b<c 를 통해 a는 둘레의 절반을 넘을 수 없다.
		
		ArrayList<Double> arrTempList = new ArrayList<Double>();

		while( a < p ) {
			a += 1;
			for(int b = a ; b < p -a ; b++) {
				c = Math.sqrt((a*a + b*b));
				if( c % 1 == 0) {
					arrTempList.add(a+b+c);
				}
			}
		}

		removeDuplicate(arrTempList);

	}

	public void removeDuplicate(ArrayList arrTempList) {
		ArrayList<Double> arrDataList;
		arrDataList = new ArrayList<Double>(new HashSet<Double>(arrTempList));

		int count = 0;
		Double picked = 0.0;
		int max = 0;

		for(int i = 0 ; i < arrDataList.size() ; i++) {
			count = Collections.frequency(arrTempList, arrDataList.get(i));
			if(count > max) {
				max = count;
				picked = arrDataList.get(i);
			}
		}
		System.out.println("picked : " + picked + "\t maxCount : " + max);
	}
}
