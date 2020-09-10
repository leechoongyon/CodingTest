package codingtest.site.codingInterview.bitOperation.Q5_Q2;

public class Question
{
	public static void main(String[] args)
	{
		double num = 0.76;
		System.out.println(convertBinaryToString(num));
	}
	
	public static String convertBinaryToString(double num)
	{
		/**
		 * 	1. num * 2 를 함. 
		 * 	2. 정수부를 제외 해서 String 에 붙여넣은 뒤, 다시 소숫점을 곱하기 2 함.
		 * 	3. 소숫점이 1,2 를 반복함.
		 * 	
		 * 	* 문자열의 길이가 32 를 초과하면 return ERROR
		 * 
		 * http://bboy6604.tistory.com/entry/%EC%86%8C%EC%88%98%EC%A0%90-%EC%95%84%EB%9E%98%EC%9D%98-%EC%A7%84%EB%B2%95-%EB%B3%80%ED%99%98
		 */
		
		
		/** 초기 사례 필요 없음. 문제에서 언급됨. */
		StringBuilder sb = new StringBuilder();
		sb.append("0.");
		
		while (num != 0)
		{
			if (sb.length() > 32) return "ERROR";
			num = num * 2;
			if (num >= 1)
			{
				num -= 1;
				sb.append("1");
			}
			else
			{
				sb.append("0");
			}
		}
		return sb.toString();
	}
}
