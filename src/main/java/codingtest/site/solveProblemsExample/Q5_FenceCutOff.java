package codingtest.site.solveProblemsExample;

/**
 * @author	: 2013BWG-02
 * @date	: 2014. 7. 5.
 * @desc	: 
 *  기저사례인 기둥 1개짜리, 가운데 2개 기둥을 기준으로 확장하는 것이 재귀로 구현되있음.
 * While에 들어가는 조건 중요. 저 조건이 무슨말인가 하면 일단 저 조건을 넣음으로써 기둥이 1개씩 추가될 때마다
 * ret를 비교해볼수 있고. hi < u && ( lo < l || h[lo-1] < h[hi+1]) 이 조건을 통해서 기둥1개씩 확장하는걸 비교하는거지.
 */
public class Q5_FenceCutOff
{
	static int h[] = {5,4,7,1};

	public static void main(String[] args)
	{
		int max = new Q5_FenceCutOff().solve(0, h.length - 1);
		System.out.println(max);
	}

	public int solve(int left, int right)
	{
		System.out.println("left : " + left + " right : " + right);

		if(left == right) return h[left];
	
		int mid = (left + right) / 2;

		int ret = max(solve(left, mid), solve(mid+1, right));

		int lo = mid, hi = mid + 1;
		int height = min(h[lo], h[hi]);

		ret = max(ret, height * 2);

		while(left < lo || hi < right)
		{
			if(hi < right && (lo == left || h[lo-1] < h[hi+1])) {
				++hi;
				height = min(height, h[hi]);
			}
			else {
				--lo;
				height = min(height, h[lo]);
			}
			
			ret = max(ret, height * (hi-lo+1));
		}

		return ret;
	}

	public int max(int i, int j)
	{
		if( i >= j)
			return i;
		else
			return j;
				
	}
	
	public int min(int i, int j)
	{
		if( i <= j)
			return i;
		else
			return j;
				
	}
}
