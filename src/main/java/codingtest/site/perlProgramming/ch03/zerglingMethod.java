package codingtest.site.perlProgramming.ch03;

public class zerglingMethod 
{
	
	public static void main(String[] args) 
	{
		final int input[] = {0,1,2,3,4,5,6,7,8,9,10,11,12};
		int temp[] = new int[13];
		int i = 3;
		int n = input.length;

		for (int k = 0; k < n ; k++) 
		{
			if(k+i < n)
				temp[k] = input[k+i];
			else
				temp[k] = input[k+i-n];
		}
		
	}
	
}
