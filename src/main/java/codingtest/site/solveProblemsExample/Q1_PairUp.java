package codingtest.site.solveProblemsExample;

public class Q1_PairUp 
{
	
	static boolean whoFriend[][];
	
	public static void main(String[] args) 
	{
		boolean taken[] = new boolean[6];
		
		assembleDataWhoFriend();
		System.out.println("sum : " + recursiveFindFriend(taken));
	}
	
	public static void assembleDataWhoFriend()
	{
		whoFriend = new boolean[10][10];
		whoFriend[0][1] = true; whoFriend[0][2] = true; whoFriend[1][2] = true; whoFriend[1][3] = true; whoFriend[1][4] = true; 
		whoFriend[2][3] = true;	whoFriend[2][4] = true; whoFriend[3][4] = true; whoFriend[3][5] = true; whoFriend[4][5] = true;
	}
	
	public static int recursiveFindFriend(boolean taken[])
	{
		
		int  sum = 0;
		
		// 1. Find Nearest Num
		
		int firstFree = -1;
		
		for(int i = 0 ; i < taken.length ; i++)
		{
			if(!taken[i])
			{
				firstFree = i;
				break;
			}
		}
		
		System.out.println("Nearest Num : " + firstFree);
		
		// 2. Recursive Stopping Criteria
		
		if(firstFree == -1)
		{
			System.out.println("Combination Complete");
			return 1;
		}
		
		
		// 3. Recursive Executable Section
		
		for(int pair = firstFree ; pair < taken.length ; pair++)
		{
			if(taken[pair] == false && whoFriend[firstFree][pair] == true)
			{
				System.out.println("pairs : " + firstFree + " / " + pair);
				taken[firstFree] = true; taken[pair] = true;
				sum += recursiveFindFriend(taken);
				taken[firstFree] = false; taken[pair] = false;
			}
		}
		
		
		return sum;
	}
}
