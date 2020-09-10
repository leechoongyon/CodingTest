package codingtest.site.solveProblemsExample;

public class Q22_BlockGame {
	public static void main(String[] args) {
		boolean taken[][] = new boolean[5][5];

		Q22_BlockGame blockGame = new Q22_BlockGame();
		blockGame.init(taken);
		blockGame.process(taken, 0);
	}

	public void init(boolean taken[][]) {
		for(int i = 0 ; i < taken.length ; i++)
			for(int j = 0 ; j < taken[i].length ; j++)
				taken[i][j] = true;

		//TestCase 1
		taken[0][1] = false;
		taken[0][2] = false;
		taken[1][2] =false;
		taken[2][2] = false;
		taken[3][1] = false;
		taken[3][2] = false;
		taken[3][3] =false;
		taken[4][2] = false;
	}

	public void process(boolean taken[][], int sum) {
		
		// 1. Find Nearest Num
		int width = -1, height = -1;

		for(int i = 0; i < taken.length ; i++) {
			for(int j = 0 ;  j < taken[i].length ; j++) {
				if(!taken[i][j]) {
					width = i; height = j;
					break;
				}
			}

			if(width != -1 && height != -1)
				break;
		}

		// 2. recursive Stopping Criteria
		// # desc : 'Sum % 2 == 1' means HyunWoo Win  

		if(width == -1 && height == -1) {
			if(sum % 2 == 1) {
				System.out.println("WIN");
				System.exit(1); 
			}
		}

		System.out.println("width : " + width + " \t height : " + height);

		// 3. recursive Executable Section

		if(taken[width][height] == false && height + 1 != taken[width].length && taken[width][height+1] == false) {
			taken[width][height] = true; taken[width][height+1] = true;
			process(taken, sum + 1);
			taken[width][height] = false; taken[width][height+1] = false;
		}

		if(taken[width][height] == false && width+1 != taken.length && taken[width+1][height] == false) {
			taken[width][height] = true; taken[width+1][height] = true;
			process(taken, sum+1);
			taken[width][height] = false; taken[width+1][height] = false;
		}

		if(taken[width][height] == false && width+1 != taken.length && height+1 != taken[width].length && taken[width][height+1] == false && taken[width+1][height] == false)
		{
			
			taken[width][height+1] = true; taken[width+1][height] = true; taken[width][height] = true;
			
			process(taken, sum + 1);
			taken[width][height+1] = false; taken[width+1][height] = false; taken[width][height] = false;
		}
		
		if(taken[width][height] == false && width+1 != taken.length && height+1 != taken[width].length && taken[width+1][height] == false && taken[width+1][height+1] == false)
		{
			
			taken[width+1][height] = true; taken[width+1][height+1] = true; taken[width][height] = true;
			process(taken, sum + 1);
			taken[width+1][height] = false; taken[width+1][height+1] = false; taken[width][height] = false;
		}
		
		if(taken[width][height] == false && width+1 != taken.length && height+1 != taken[width].length && taken[width+1][height] == false && taken[width+1][height-1] == false)
		{
			
			taken[width+1][height] = true; taken[width+1][height-1] = true; taken[width][height] = true;
			process(taken, sum + 1);
			taken[width+1][height] = false; taken[width+1][height-1] = false; taken[width][height] = false;
		}
		
		if(taken[width][height] == false && width+1 != taken.length && height+1 != taken[width].length && taken[width][height+1] == false && taken[width+1][height+1] == false)
		{
			
			taken[width][height+1] = true; taken[width+1][height+1] = true; taken[width][height] = true;
			process(taken, sum + 1);
			taken[width][height+1] = false; taken[width+1][height+1] = false; taken[width][height] = false;
		}

		taken[width][height] = true;

	}
}	
