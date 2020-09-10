package codingtest.site.algospot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @file		algospot.FENCE.java
 * @filetype	java source file
 * @brief
 * @author		lee
 * @version		0.1
 * @history
 * 버전			성명			일자			변경내용
 * 0.1			lee		2015. 9. 10.		신규작성


예제 입력
3
7
7 1 5 9 6 7 3
7
1 4 4 4 4 1 1
4
1 8 2 2

예제 출력
20
16
8

문제 : 주어진 울타리에서 잘라낼 수 있는 최대 직사각형의 크기를 구하라.


 */

public class FENCE 
{
	private static int max = 0; 
	
	public static void main(String[] args) throws IOException 
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
		int cNum = Integer.parseInt(br.readLine().trim());
		int [] res = new int[cNum];
		for (int i = 0 ; i < cNum ; i++)
		{
			int rectNum = Integer.parseInt(br.readLine().trim());	
			int fence[] = new int[rectNum];
			st = new StringTokenizer(br.readLine().trim(), " ");
			for (int j = 0 ; j < rectNum ; j++)
				fence[j] = Integer.parseInt(st.nextToken());
			res[i] = solve(fence,0, rectNum-1);
		}
		for (int k = 0 ; k < cNum ; k++)
			System.out.println(res[k]);
	}
	
	public static int solve(int fence[], int startIndex, int endIndex)
	{
		int mid = (startIndex + endIndex) / 2;
		int left = mid , right = mid + 1;

		// 기저사례 (fence.length == 1 이면 return fence[0])
		if (startIndex == endIndex)
			return fence[startIndex];
		
		// 왼쪽, 오른쪽이 더 큰 경우 찾기
		max = Math.max(solve(fence, startIndex, mid), solve(fence, mid+1, endIndex));
		
		// 합쳤을 때 큰 부분 찾기
		// 이 부분은 합쳤을 때 시작되는 부분이므로 무조건 가운데부터 시작해서 하나씩 늘려나가는게 무조건 맞다.
		int height = Math.min(fence[left], fence[right]);
		max = Math.max(max, height * (right - left + 1));
		while(left > startIndex || right < endIndex)
		{
			// 높이가 큰 쪽부터 계산해줘야함. 높이가 작은게 하나 들어가는순간 계속 minHeight가 그걸로 잡히기에 제대로 된 계산이 안됨
			if (right < endIndex && (left == startIndex || fence[left-1] < fence[right+1]))
			{
				right++;
				height = Math.min(height,  fence[right]);
			}
			else
			{
				left--;
				height = Math.min(height, fence[left]);
			}
			max = Math.max(max, height * (right - left + 1));
		}
		
		return max;
	}
	
	/*public static int getMinHeight(int fence[], int startIndex, int endIndex)
	{
		int min = 10000;
		
		for (int i = startIndex ; i < endIndex ; i++)
			min = Math.min(min, fence[i]);
		return min;
	}*/
}
