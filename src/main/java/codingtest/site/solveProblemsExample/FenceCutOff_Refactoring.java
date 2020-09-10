package codingtest.site.solveProblemsExample;

/**
 * @file		solveProblemsExample.FenceCutOff_Refactoring.java
 * @filetype	java source file
 * @brief
 * @author		lee
 * @version		0.1
 * @history
 * 버전			성명			일자			변경내용
 * 0.1			lee		2015. 7. 10.		신규작성
 *
 *	여기서 알아야 할 점은 분할정복이 여기서 왜 좋은가?
 *      
 *  - 주어진 n 크기의 배열을 n/2 크기의 배열 두 개로 나눈 뒤 이들을 각각 해결
 *    재귀 호출 외에 함수 내에서 하는 일은 두 부분에 걸쳐 있는 사각형을 찾는 작업밖에 없음. 이 작업의 시간 복잡도가 전체 시간 복잡도 결정
 *    너비가 2인 사각형에서 시작해서 너비가 n인 사각형까지를 하나하나 검사하므로 시간 복잡도 o(n)이 됨.
 *    문제를 항상 절반으로 나누어서 재귀 호출하고, o(n)의 시간의 후처리를 하는 알고리즘이 병합 정렬이며, o(nlgn)을 갖음. 
 *      
 *    좀 더 구체적으로 파고들면 각 문제를 n/2로 나누니까 이 작업들은  o(lgn) 이 됨.
 *    (왜 o(lgn) 이냐면 n/2씩 나누니까 1번 넣을 때마다 n/2씩 감소되니
 *    두 부분에 걸쳐 있는 작업들이 while 문을 통해  o(n) 이라는 것을 알 수 있음. 그러니 둘 을 곱하니 o(lgn) * o(n) = o(nlgn)
 *  
 * 	Hint
 * 
 * 	양 옆이 합쳐진 부분은 반드시 가운데를 포함한다.
 * 
 * 
 * 	전체 알고리즘 방향
 * 
 * 	Low, High, Mid 이 세 부분에 대한 Max 값을 구해야한다.
 * 
 */
public class FenceCutOff_Refactoring 
{
	public static void main(String[] args) 
	{
		int n = 9;
		
		int fence[] = new int[n];
		
		// 1. init
		init(fence);
		
		
		// 2. getMaxSquareArea
		
		int low = 0;  
		int high = fence.length -1;
		int max = 0;
		max = getMaxSquareArea(fence, low, high);
		
		/*System.out.println("Max SquareArea : " + max);*/
	}
	
	public static int getMaxSquareArea(int fence[], int low, int high)
	{
		System.out.println();
		if (low == high) {
			/*System.out.println("(low == high) -> return : " + fence[low]);
			System.out.println("low : " + low + "\t\thigh : " + high);*/
			return fence[low];
		}
		
		int max = 0;
		int mid = (low + high) / 2;
		/*System.out.print("low : " + low + "\t\thigh : " + high + "\tmid : " + mid);*/
		max = Math.max(getMaxSquareArea(fence, low, mid), getMaxSquareArea(fence, mid+1, high));
		/*System.out.println("getMaxSquareArea : " + max);*/
		max = Math.max(max, getMaxSquareAreaContainsMidIndex(fence, low, high));
		/*System.out.println("final max : " + max);*/
		return max;
	}
	
	public static int getMaxSquareAreaContainsMidIndex(int fence[], int low, int high)
	{
		/*System.out.println("================================");
		System.out.println("getMaxSquareAreaContainsMidIndex");
		System.out.println("================================");
		System.out.print("low : " + low + "\t\thigh : " + high);
		System.out.println();*/
		
		int max = 0;
		int mid = (low + high) / 2;
		int left = mid;
		int right = mid;
		
		while (!(left == low && right == high))
		{
			/*System.out.print("left : " + left +"\tright : " + right);
			System.out.println();*/
			
			if (left != low)
				left--;
			else if (right != high)
				right++;
			
			max = Math.max(getMinHeight(fence,left,right) * (right - left + 1), max);
		}
		
		return max;
	}
	
	public static int getMinHeight(int fence[], int left, int right)
	{
		/*System.out.println("=================================");
		System.out.println("getMinHeight");
		System.out.println("=================================");
		System.out.print("left : " + left + "\tright : " + right);
		System.out.println();*/
		int min = Integer.MAX_VALUE;
		for (int i = left ; i <= right ; i++)
			min = Math.min(fence[i], min);
		/*System.out.println("min : " + min);*/
		return min;
	}
	
	public static void init(int fence[])
	{
		fence[0] = 6; fence[1] = 5; fence[2] = 4; fence[3] = 4;
		fence[4] = 4; fence[5] = 4; fence[6] = 5; fence[7] = 7;
	}
}
