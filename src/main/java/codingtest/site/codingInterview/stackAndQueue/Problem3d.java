package codingtest.site.codingInterview.stackAndQueue;

/**
 * @author lee
 *
 *	1. s1, s2 스택이 있음.
 *	2. s1 은 큐를 쌓는 장소. s2 는 역순으로 쌓는 장소
 *	3. 값이 들어오면 일단 s2 에 집어넣음.
 *	4. s2 에 있는 것을 s1 으로 옮김.
 *	5. 그럼 s1 은 큐가 되는거임.
 *	---------------- 여기까지가 push O(n) -----------------
 *	
 *
 *	1. pop 은 s2 에서 그냥 뺴기만 하면 됨. O(1)
 */
public class Problem3d
{
	public static void main(String[] args)
	{
		MyQueueUsingTwoStack2 queue = new MyQueueUsingTwoStack2();
		queue.add(1);
		queue.add(2); 
		queue.add(3);
		System.out.println(queue.remove());
		System.out.println(queue.remove());
		System.out.println(queue.remove());
	}
}
