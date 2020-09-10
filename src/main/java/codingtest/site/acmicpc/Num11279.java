package codingtest.site.acmicpc;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Num11279
{
	public static void main(String[] args)
	{
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>(
				new Comparator<Integer>() {
					@Override
					public int compare(Integer o1, Integer o2) {
						// TODO Auto-generated method stub
						return o2.compareTo(o1);
					}
		});
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
