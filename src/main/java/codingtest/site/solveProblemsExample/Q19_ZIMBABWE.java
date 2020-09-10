package codingtest.site.solveProblemsExample;

public class Q19_ZIMBABWE 
{
	static String e = "422";
	static String digits = "224";
	
	
	public static void main(String[] args) 
	{
		
		String price = "";
		boolean taken[] = new boolean[5];
		
		new Q19_ZIMBABWE().generate(price, taken);
	}
	
	public void generate(String price, boolean taken[])
	{
		if(price.length() == e.length())
		{
			if(Integer.parseInt(price) <Integer.parseInt(e))
				System.out.println(price);
			return ;
		}
		
		for(int i = 0 ; i < e.length() ; i++)
		{
			if(!taken[i] && (i == 0 || digits.charAt(i-1) != digits.charAt(i) || taken[i-1])) 
			{
				taken[i] = true;
				generate(price + digits.charAt(i), taken);
				taken[i] = false;
			}
		}
	}
}
