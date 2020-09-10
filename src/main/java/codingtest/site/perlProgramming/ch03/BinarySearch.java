package codingtest.site.perlProgramming.ch03;

public class BinarySearch
{
	public static void main(String[] args)
	{
		int t = 9;
	
//		int x[] = {0,1,2,3,4,5,6,7,8,9};
		int x[] = {1,2,5,9,9};
		
		int l = 0;
		int u = x.length - 1;

		int p;

		p = loopBinarySearch(x, l, u, t);
//		p = recursiveBinarySearch(x, l, u, t);

		System.out.println("원하는 인덱스 : " + p);
	}

	// 7번. 
	// 입력 : x,y
	// 출력 : 점을 둘러싸는 두 직선의 a, b 배열
	// 풀이  : x가 주어졌으니 x를 y = ax + b에 대입하면 y값이 쭉 나올 것이다.
	// 이 y값을 이진탐색을 이용해 점 (x,y)를 둘러싸는 직선을 구하는 것.
	// 이 함수는 y값만 입력하면 둘러싼 인덱스 2개를 출력하는 함수임.
	// 완벽하게 만들려면 y = ax + b를 대입해 y값을 쭉 뽑아내는 함수를 하나 더 만들어야함.
	
	public static void findApproximateValue(double x[], int l, int u, double t)
	{
		int m = -1;
	
		while( !(u - l < 0 ))
		{
			m = ( l + u ) / 2;
	
			System.out.println(l + ", " + u + ", " + m);
	
			if(x[m] > t)
				u = m - 1;
			else if(x[m] < t)
				l = m + 1;
			else break;
		}

		if(x[m] > t)
			System.out.println("답 : " + x[m-1] + " , " + x[m]);
		else
			System.out.println("답 : " + x[m] + " , " + x[m+1]);
	}	

	public static int loopBinarySearch(int x[], int l, int r, int target)
	{
		int m;
	
		while( l <= r)
		{
			m = ( l + r ) / 2;

			System.out.println(l + ", " + r + ", " + m);
	
			if( x[m] == target)
			{
				return m;
			}
			else if( x[m] > target)
				r = m - 1;
			else
				l = m + 1;
		}
		
		return -1;
	}

	public static int recursiveBinarySearch(int x[], int l, int u, int t)
	{
		int m = (l + u) / 2;

		int p = -1;
	
		System.out.println(l + ", " + u + ", " + m);

		if(x[m] == t)
			return m;
		else if(x[m] > t)
			p = recursiveBinarySearch(x, l, m-1, t);
		else 
			p = recursiveBinarySearch(x, m+1, u, t);
		if( l  > u )
		{
			return p;
		}	
	
		return p;
	}
}
