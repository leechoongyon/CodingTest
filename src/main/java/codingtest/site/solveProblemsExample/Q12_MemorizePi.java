package codingtest.site.solveProblemsExample;

public class Q12_MemorizePi
{
	static String str = "123456";
	static int INF = 123456;
	static int cache[] = new int[10];
	
	public static void main(String[] args) 
	{
		System.out.println("result : " + new Q12_MemorizePi().MemorizePi(0));
	}

	
	
	public int MemorizePi(int begin)
	{
		if(begin == str.length()) return 0;
		
		if(cache[begin] != 0) return cache[begin];
		
		cache[begin] = INF;
		
		for(int L = 3 ;  L <=5 ; L++)
			if(begin + L <= str.length())
				cache[begin] = Math.min(cache[begin], MemorizePi(begin + L) + determineLevelOfDifficulty(str.substring(begin, L + begin)));
		
		return cache[begin];
	}
	
	
	
		
	public int determineLevelOfDifficulty(String str)
	{
		char inputStart = str.charAt(0);
		
		//case 1 	Level of Difficulty : 1
		for(int i = 1 ; i < str.length() ; i++)
		{
			if(inputStart != str.charAt(i))
					break;
			return 1;
		}
				
		//case 2	Level of Difficulty : 2
		for(int i = 1; i < str.length() ; i++)
		{
			if ((int)inputStart + 1 != str.charAt(i))
				break;
			return 2;
		}
		
		return 10;
		
	}
	
}
