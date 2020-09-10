package codingtest.site.solveProblemsExample;

public class Q20_KLis {

	static int cacheLen[] = new int[10];
	static int num[] = { 5, 1, 6, 4, 3, 2, 8, 7 };
	static int cacheCnt[] = new int[10];
	static int order = 0;
	static int k = 2;
	static int choices[] = new int[10];

	public static void main(String[] args) {
		new Q20_KLis().start();
	}

	public void start() {
		int max = 0;

		int count = 0;
		
		for (int i = 0; i < num.length; i++) {
			max = Math.max(max, lis(i));
		}
		for (int i = 0; i < num.length; i++) {
			count += count(i, 1, max);
		}
	}

	public int lis(int start) {
		if (cacheLen[start] != 0)
			return cacheLen[start];
		cacheLen[start] = 1;

		for (int next = start + 1; next < num.length; next++)
			if (start == -1 || num[start] < num[next])
				cacheLen[start] = Math.max(cacheLen[start], lis(next) + 1);

		return cacheLen[start];
	}

	public int count(int start, int count, int lisValue)
	{

		if(lis(start) == 1 && count == lisValue) return count;

		for(int next = start+1 ; next < num.length ; next++)
		{
			if(num[start] < num[next] && (lis(start) == (lis(next) + 1)))
			{
				count = count(next, count+1, lisValue);
				choices[start] = next;
				if(count ==lisValue)
					order++;
				count--;
				if(k == order)
				{
					printAll();
				}
			}
		}
		return count;
	}

	public void printAll() {
		for (int i = 0; i < choices.length; i++)
			System.out.print(choices[i] + " , ");
	}
}
