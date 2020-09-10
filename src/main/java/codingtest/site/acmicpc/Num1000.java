package codingtest.site.acmicpc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.StringTokenizer;

/**
 * @author lee
 *
 * 문제 : 두 수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램 작성
 * 
 * 0 < A , B < 10
 */
public class Num1000
{
	public static void main(String [] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine().trim(), " ");
		BigDecimal A = new BigDecimal(st.nextToken());
		BigDecimal B = new BigDecimal(st.nextToken());
		System.out.println(A.add(B));
	}
}
