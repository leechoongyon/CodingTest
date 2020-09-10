package codingtest.site.acmicpc;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author USER
 *
 *	x 가 0이면 배열에서 가장 작은 값을 출력하고 그 값을 배열에서 제거
 *	x 가 자연수라면 배열에 x라는 값을 넣는 연산
 *
 *	최소힙 정리
 *	1. 부모 노드는 자식 노드보다 작아야 한다.
 *	2. Insert 시 에는 마지막 Index 에 넣고.
 *	3. Delete 시 에는 Root 를 추출. 마지막 Index 에 있는 것을 Root 로

9
0
12345678
1
2
0
0
0
0
32

 */
public class Num1927
{
	
	public static void main(String[] args)
	{
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for (int idx = 0 ; idx < N ; idx++)
		{
			int x = sc.nextInt();
			if (x == 0)
			{
				if (queue.isEmpty()) 
					System.out.println(0);
				else 
					System.out.println(queue.poll());
			}
			else
			{
				queue.offer(x);
			}
		}
	}
}