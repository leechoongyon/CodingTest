package codingtest.site.solveProblemsExample;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*desc : 글자의 갯수를 세서 HashMap을 통해 해당 값의 글자수를 비교해서 최소의 필요 
글자수를 출력해냄.
1. Q21_RestoreData.java

1) restore 함수 : used는 next 숫자를 사용했는지의 여부 판단 변수, 해당 변수를 << 시프트해서 & 했을 시 And 조건이 됬는지 체크

int cand는 마지막 단어, 다른 단어 나올 시 겹치는 갯수 + 다음 단어, 현재 사용되는 단어를 넘겨 몇 개 겹치는가를 Cache에 저장.*/


public class Q21_RestoreData {
	
	static int k = 2;
	static int cache[][] = new int[16][16];
	static int overlap[][] = new int[16][16];
	static String word[] = new String[k+1];
	
	public static void main(String[] args) {

		Q21_RestoreData q21 = new Q21_RestoreData();
		
		
		word[0] = "abc"; word[1] = "cde"; word[k] = "";
		
		
		/*ArrayList<String> listInputData = new ArrayList<String>();
			
		q21.init(listInputData);
		q21.process(listInputData);*/
		
//		System.out.println(word[0].substring(1));
		
		q21.process_ver2(word,k);
		
		
	}

	public void process_ver2(String word[], int k) {
		
		for(int i = 0 ; i <= k ; i++)
			for(int j = 0 ; j<= k ; j++) 
				overlap[i][j] = getOverlap(word[i], word[j]);
		restore(k,0);
		System.out.println(reconstruct(k,0));
	}
	
	public String reconstruct(int last, int used) {
		// 기저 사례
		if(used == (1<<k)-1) return "";
		for(int next = 0; next < k; ++next)
			if((used & (1<<next)) == 0 && restore(last, used) == overlap[last][next] + restore(next, used + (1<<next)))
				return word[next].substring(overlap[last][next]) + reconstruct(next, used + (1<<next));
		return "_oops_";
	}
	
	public int getOverlap(String a, String b) {
		for(int len = Math.min(a.length(),b.length()); len > 0 ; --len) {
			if(a.substring(a.length()-len).equals(b.substring(0,len)))
				return len;
		}
		return 0;
	}
	
	// 마지막 단어인 last가 들어오고 이전 단어인 used가 들어왔을 때 몇개를 겹치게 할 수 있는가?
	// 이게 restore의 역할이다.
	
	public int restore(int last, int used) {
		
		if(used == (1 << k) - 1 ) return 0;
		
		if(cache[last][used] != 0) return cache[last][used];
		cache[last][used] = 0;
		
		for(int next = 0; next < k; next++)
			if((used & (1<<next)) == 0) {
				int cand = overlap[last][next] +
					restore(next, used + (1<<next));
				cache[last][used] = Math.max(cache[last][used], cand);
			}
		return cache[last][used];
	}
	
	public void init(ArrayList<String> listInputData) {
		listInputData.add("geo");
		listInputData.add("oji");
		listInputData.add("jing");
	}

	public void process(ArrayList<String> list) {
		HashMap <Character, Integer> inputDataMap = new HashMap<Character, Integer>();
		HashMap <Character, Integer> storeDataMap = new HashMap<Character, Integer>();
		
		for(int i = 0 ; i < list.size() ; i++) {
			inputDataMap = countCharacter(list.get(i));
			Set set = inputDataMap.keySet();
			Iterator<Character> iter = set.iterator();

			while(iter.hasNext()) {
				Character c = iter.next();
				if(inputDataMap.get(c).compareTo(storeDataMap.get(c).valueOf(0)) == 1)
					storeDataMap.put(c, inputDataMap.get(c));
			}

			System.out.println(storeDataMap.keySet());
		}
	}

	public HashMap<Character, Integer> countCharacter(String s) {
		/*String sortedStr = BubbleSort.BubbleSorting(s, s.length());
		return PatternCount(sortedStr);*/
		return null;
	}		

	
	public HashMap<Character, Integer> PatternCount(String str)	{
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();

		str = str.toLowerCase();

		char alphabet = 'a';

		for (alphabet = 'a'; alphabet <= 'z' ; alphabet++) {
			Pattern p = Pattern.compile(Character.toString(alphabet));
			Matcher m = p.matcher(str);

			int count = 0;

			for (int i = 0 ; m.find(i); i = m.end())
				count++;
			if(count != 0)
				map.put(alphabet, count);
		}

		return map;
	}

	class DataSet {
		char ch;
		boolean bool;
	}
}



