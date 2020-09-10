package codingtest.site.acmicpc;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Num1475
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		String N = scan.next();
		
		System.out.println(solve(N));
	}
	
	public static int solve(String N)
	{
		/**
		 * 	문제 의미 : 다솜이의 방번호가(N) 주어졌을 때, 플라스틱 숫자로 N 을 만들어라.
		 * 	단, 6은 9로 , 9는 6으로 변환 가능 
		 * 	한 세트는 0~9 로 이루어짐.
		 *  0 <= N <= 1,000,000
		 *  
		 *  1. 숫자를 하나씩 순회하며, map 에 집어넣는다. (map 은 총 10개의 key 를 가지게 됨)
		 *  2. 가장 높은 수 만큼 플라스틱 세트가 있으면 됨.
		 *  3. 단, 6 또는 9라면 하나씩 뺴줄 수 있다는 것.
		 *  	- 6과 9에 있는 것을 합침. 그런 뒤 나누기 2를 했을 때, 딱 떨어지면 그게 max. 
		 *  	- 나머지 1이 나오면 sum / 2 + 1 임
		 *  4. 시간 복잡도 O(N) -- N 을 순회하는 것이기에 
		 */
		
		int len = N.length();
		int max = 0;
		Map<Character, Integer> map = new HashMap<>();
		char c;
		for (int i = 0 ; i < len ; i++)
		{
			c = N.charAt(i);
			if (map.containsKey(c))
			{
				map.put(c, map.get(c) + 1);
			}
			else
			{
				map.put(c, 1);
			}
		}
		
		/** max 판별 */
		for (char key : map.keySet())
		{
			if (key == '6' || key == '9') continue;
			max = Math.max(map.get(key), max);
		}
		
		/** 6 과 9 는 별도 판단 */
		int val6 = map.containsKey('6') ? map.get('6') : 0;
		int val9 = map.containsKey('9') ? map.get('9') : 0;
		int temp = val6 + val9;
		if (temp % 2 == 0)
			max = Math.max(max, temp / 2);
		else
			max = Math.max(max, (temp / 2) + 1);

		return max;
	}
}
