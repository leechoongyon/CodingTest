package codingtest.site.solveProblemsExample;

/**
 * @author	: 2013BWG-02
 * @date	: 2014. 6. 21.
 * @desc	: Block Cover
 * 
 * 신경써야하는 것 
 * 
 * 1) 중복 제거. 이걸 해결 하기 위해 앞에서 특정한 것들만 세도록 규칙을 만듬. ( ex) false인 맨 앞의 taken을 찾아서 조합에 굴려보기.)
 * 2) 위에 나온대로 false인 맨 처음의 taken index를 찾아 그걸 기준으로 계속해서 맨 처음 것들을 뽑아 조합을 찾아나가기.
 * 3) 내가 실수했던 것은 맨처음 것을 뽑고 그것을 for문으로 돌렸던 것인데 이렇게 할 필요 전혀 없다. 이렇게 하면 중복되는 것까지 싹 뽑아버림.
 * 
 *   
 * 배운점
 * 
 * 1) 재귀란 한가지 동일한 규칙을 계속해서 돌려나가는 것이다. 
 * 2) Index의 범위를 바꿔가면서
 * 3) 단, 종료 조건이 분명해야한다.
 * 
 * 예를 들자면, 이 문제에서 처음 taken의 가장 맨 앞을 고르고 그것을 4가지 조합의 if문에 거는 것은 하나의 동일한 규칙이고
 * taken의 가장 맨 앞을 찾는 것은 Index 범위를 바꾸는 것이며, width = -1, height = -1 이 종료 조건이다.			  
 */
public class Q2_CoveredBlock 
{
	
	
	public static void main(String[] args) 
	{
		boolean taken[][] = new boolean[3][7];
		
		/*boolean taken[][] = new boolean[8][10];*/
		
		assembleBoardData(taken);
		
		System.out.println("sum : " + recursiveCoveredBlock(taken));
	}
	
	public static void assembleBoardData(boolean taken[][])
	{
		
		//TestCase 1
		taken[0][0] = true; taken[0][6] = true;
		taken[1][0] = true; taken[1][6] = true;
		taken[2][0] = true; taken[2][6] = true;
		taken[2][1] = true; taken[2][5] = true; taken[2][4] = true;

		//TestCase 2
		/*taken[0][0] = true; taken[0][1] = true; taken[0][2] = true; taken[0][3] = true; taken[0][4] = true; taken[0][5] = true; taken[0][6] = true; taken[0][7] = true; taken[0][8] = true; taken[0][9] = true;
		taken[1][0] = true; taken[1][9] = true;
		taken[2][0] = true; taken[2][9] = true;
		taken[3][0] = true; taken[3][9] = true;
		taken[4][0] = true; taken[4][9] = true;
		taken[5][0] = true; taken[5][9] = true;
		taken[6][0] = true; taken[6][9] = true;
		taken[7][0] = true; taken[7][1] = true; taken[7][2] = true; taken[7][3] = true; taken[7][4] = true; taken[7][5] = true; taken[7][6] = true; taken[7][7] = true; taken[7][8] = true; taken[7][9] = true;*/
		
		
	}
	
	/**
	 * @param taken
	 * @return
	 */
	public static int recursiveCoveredBlock(boolean taken[][])
	{
		int sum = 0;
		
		// 1. Find Nearest Num
		
		int width = -1, height = -1;
		
		
		for(int i = 0 ; i < taken.length ; i++)
		{
			for(int j = 0 ; j < taken[i].length ; j++)
			{
				
				if(!taken[i][j])
				{
					width = i; height = j;
					break;
				}
			}
			
			if(width != -1 && height != -1)
				break;
		}
		
		// 2. recursive Stopping Criteria
		
		if(width == -1 && height == -1)
		{
			System.out.println("Combination Success.");
			return 1;
		}
		
		
		// 3. recursive Exeutable Section
		
		
				
				/*System.out.println();
				System.out.println("Boolean Status");
				printAllTaken(taken);*/
				
				 
				if(taken[width][height] == false && width+1 != taken.length && height+1 != taken[width].length && taken[width][height+1] == false && taken[width+1][height] == false)
				{
					
					taken[width][height+1] = true; taken[width+1][height] = true; taken[width][height] = true;
					
					sum += recursiveCoveredBlock(taken);
					taken[width][height+1] = false; taken[width+1][height] = false; taken[width][height] = false;
				}
				
				if(taken[width][height] == false && width+1 != taken.length && height+1 != taken[width].length && taken[width+1][height] == false && taken[width+1][height+1] == false)
				{
					
					taken[width+1][height] = true; taken[width+1][height+1] = true; taken[width][height] = true;
					sum += recursiveCoveredBlock(taken);
					taken[width+1][height] = false; taken[width+1][height+1] = false; taken[width][height] = false;
				}
				
				if(taken[width][height] == false && width+1 != taken.length && height+1 != taken[width].length && taken[width+1][height] == false && taken[width+1][height-1] == false)
				{
					
					taken[width+1][height] = true; taken[width+1][height-1] = true; taken[width][height] = true;
					sum += recursiveCoveredBlock(taken);
					taken[width+1][height] = false; taken[width+1][height-1] = false; taken[width][height] = false;
				}
				
				if(taken[width][height] == false && width+1 != taken.length && height+1 != taken[width].length && taken[width][height+1] == false && taken[width+1][height+1] == false)
				{
					
					taken[width][height+1] = true; taken[width+1][height+1] = true; taken[width][height] = true;
					sum += recursiveCoveredBlock(taken);
					taken[width][height+1] = false; taken[width+1][height+1] = false; taken[width][height] = false;
				}
		
		
		return sum;
	}
	
	public static void printAllTaken(boolean taken[][])
	{
		for(int i = 0 ; i < taken.length ; i++)
		{
			for(int j = 0 ; j < taken[i].length ; j++)
			{
				if(taken[i][j] == true)
					System.out.print("#");
				else 
					System.out.print(".");
			}
			System.out.println();
		}
			
	}
}
