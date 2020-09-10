package codingtest.site.algospot;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.List;
import java.util.Vector;
import java.util.regex.Pattern;

/**
 * @file		algospot.WildCardUsingPatternMatch.java
 * @filetype	java source file
 * @brief
 * @author		lee
 * @version		0.1
 * @history
 * 버전			성명			일자			변경내용
 * 0.1			lee		2015. 9. 22.		신규작성
 * 
 * 1. Pattern Match로 푼 방법 (정말 머리가 좋다)
 */
public class WildCardUsingPatternMatch {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws Exception {
		int t = Integer.parseInt(in.readLine());
		
		while (t -- > 0){
			String w = in.readLine();
			int n = Integer.parseInt(in.readLine());
			
			w = w.replace('?', '.');
			w = w.replace("*", "\\w?");
			w = w.replace('?', '*');
			w = '^' + w + '$';
			Pattern p = Pattern.compile(w);
			
			List<String> v = new Vector<String>();
			for (int i = 0; i < n; i ++){
				String s = in.readLine();
				if (p.matcher(s).matches()){
					v.add(s);
				}
			}
			
			Collections.sort(v);
			for (int i = 0; i < v.size(); i ++)
				out.write(v.get(i) + '\n');
		}
		out.flush();
	}
}
