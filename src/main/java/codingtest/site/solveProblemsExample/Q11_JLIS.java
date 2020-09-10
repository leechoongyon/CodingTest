package codingtest.site.solveProblemsExample;

public class Q11_JLIS 
{
	static int cache[][] = new int[100][100];
	static int A[] = {1,2,3};
	static int B[] = {4,5,6};
	
	public static void main(String[] args) 
	{
		int sum = new Q11_JLIS().JLis(0,0);
		System.out.println("sum : " + sum);
		
	}
	
	public int JLis(int indexA, int indexB)
	{
		
		
		if(cache[indexA+1][indexB+1] != 0)
			return cache[indexA+1][indexB+1];
		
		cache[indexA+1][indexB+1] = 2;
		
		int maxElement = Math.max(A[indexA], B[indexB]);
		
		for(int nextA = indexA + 1 ; nextA < 3 ; nextA++)
			if(maxElement < A[nextA])
				cache[indexA+1][indexB+1] = Math.max(cache[indexA+1][indexB+1], JLis(nextA, indexB) + 1);
		for(int nextB = indexB + 1 ; nextB < 3 ; nextB++)
			if(maxElement < B[nextB])
				cache[indexA+1][indexB+1] = Math.max(cache[indexA+1][indexB+1], JLis(indexA, nextB) + 1);
		
		return cache[indexA+1][indexB+1];
		
			
	}
}
