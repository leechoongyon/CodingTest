package codingtest.site.codingDoJang;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConvertCamelToPothole {
	public static void main(String[] args) {
		
		// Case 1
		String input = "codingDojang";
		
		// Case 2
		/*String input = "numGoat30";*/
		
		System.out.println("before	: " + input);

		String result = convert(input);
		
		System.out.println("After	: " +  result);
	}
	
	public static String convert(String input) {
		
		// 1. 대문자를 소문자로 바꾸고 앞 글자에 '_' 추가
		int inputSize = input.length();
		
		for (int i = 0 ; i < inputSize ; i++) {
			if (Character.isUpperCase(input.charAt(i))) {
				String str = String.valueOf(input.charAt(i));
				input = input.replace(str, "_" + str.toLowerCase()); 
			}
		}
		
		// 2. 숫자 앞에 '_' 추가
		Pattern p = Pattern.compile("\\d");
		Matcher m = p.matcher(input);
		
		while (m.find()) 
			input = input.replace(m.group(0), "_" + m.group(0));
		
		return input;
	}
}
