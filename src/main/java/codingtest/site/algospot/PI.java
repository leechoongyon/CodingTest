package codingtest.site.algospot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @file		algospot.PI.java
 * @filetype	java source file
 * @brief
 * @author		lee
 * @version		0.1
 * @history
 * 버전			성명			일자			변경내용
 * 0.1			lee		2015. 9. 28.		신규작성
 *

예제 입력

5 
12341234 
11111222 
12122222 
22222222 
12673939 

예제 출력

4
2
5
2
14


1
11111222

이 때, 각 조각들의 난이도는 다음과 같이 정해집니다:

1. 모든 숫자가 같을 때 (예: 333, 5555) 난이도: 1
2. 숫자가 1씩 단조 증가하거나 단조 감소할 때 (예: 23456, 3210) 난이도: 2
3. 두 개의 숫자가 번갈아 가며 출현할 때 (예: 323, 54545) 난이도: 4
4. 숫자가 등차 수열을 이룰 때 (예: 147, 8642) 난이도: 5
5. 그 외의 경우 난이도: 10
 

문제 : 원주율의 일부가 입력으로 주어질 때, 난이도의 합을 최소화하도록 숫자들을 3자리에서 5자리까지 끊어 읽고 싶습니다. 최소의 난이도를 계산하는 프로그램을 작성하세요.



Feedback

	1) String -> Int를 사용 (입력 값)
	2) 마찬가지로 입력 파라미터를 String -> int 로
	3) Cache의 최소 값인 ret를 for 문 다 돌린 뒤에 return을 한다면 ret에는 최소 값이 남아있겠지.
	4) *** 가장 핵심은 ret를 통해 가장 min 값을 구한 뒤 cache[3] , cache[4] 에 집어넣는다.
		즉, 내가 맨 처음에 생각한 cache[8], cache[9]에 ret를 집어넣어서 못쓰게 하는건 맞는데 
		여기선 cache[3], cache[4], cache[5] 라는 것은 각 index에서 min 값을 집어넣어서 처리한다는 의미
		메모라이제이션을 사용할 때 구하고자 하는 것을 cache에 집어넣고 구하는 연습을 하자.
		여기선 구하고자 하는 것이 min 값이겠지.
	5) String 보단 int[] 가 낫다. String은 parsing 과정에서 많이 잡아먹음.
 *
 */
public class PI 
{
	private static int arrayNum[];
	private static int cache[] = new int[10002];
	
	public static void main(String[] args) throws IOException 
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int cNum = Integer.parseInt(br.readLine().trim());
        int res[] = new int[cNum];
        for (int i = 0 ; i < cNum ; i++)
        {
        	String line = br.readLine().trim();
        	arrayNum = new int[line.length()];
        	for (int j = 0 ; j < line.length() ; j++)
        		arrayNum[j] = Integer.parseInt(line.substring(j, j+1));
        	Arrays.fill(cache, -1);
        	res[i] = memorize(0);
        }
        
        for (int k = 0 ; k < cNum ; k++)
        	System.out.println(res[k]);
	}
	
	private static int memorize(int index)
	{
		int size = arrayNum.length;
		if (index == size)  return 0;
		if (cache[index] != -1) return cache[index];
		int ret = 987654321;
		for (int i = 3 ; i < 6 ; i++)
			if (index + i <= size)
				ret = Math.min(ret, memorize(index + i) + classify(Arrays.copyOfRange(arrayNum, index, index+i)));
		
		return cache[index] = ret;
	}
	
	private static int classify(int num[])
	{
		int size = num.length;
		
		boolean equal = true;
		for (int i = 1 ; i < size ; i++)
		{
			if (num[i] != num[0])
			{
				equal = false;
				break;
			}
		}
		
		if (equal == true) return 1;
		
		boolean progresive = true;
		for (int i = 0 ; i < size - 1 ; i++)
			if (num[i+1] - num[i] != num[1] - num[0])
				progresive = false;
		if (progresive && Math.abs(num[1] - num[0]) == 1)
			return 2;
		
		boolean alternating = true;
		for (int i = 0 ; i < size ; i++)
			if (num[i] != num[i%2])
				alternating = false;
		if (alternating) return 4;
		if (progresive) return 5;
		return 10;
	}
	
	
}
