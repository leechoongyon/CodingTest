package codingtest.site.codingInterview.stackAndQueue;

import java.util.EmptyStackException;

/**
 *
 *	min 값도 마찬가지로 stack 을 쓰는 이유는
 *	int 단일 값으로 써버리면, pop 을 했을 때, 계산하는 것이 오래 걸림.
 *	min 값을 stack 으로 해서 pop 을 했을 때, min stack 에 있는 값을 pop 하는거면 빼고 아니면 그냥 냅둠.
 */
public class MinStack
{
	/** 
	 * StackNode 를 내부 클래스로 선언한 이유는 MinStack 의 자료 구조로 사용하기 위함.
	 * StackNode 에 next 가 있는 이유는 다음 변수를 가리키기 위함.
	 * */
	public static class Node<T>
	{
		private T data;
		private Node<T> next;

		public Node(T data)
		{
			this.data = data;
		}

		@Override
		public String toString()
		{
			return "StackNode [data=" + data + ", next=" + next + "]";
		}
	}
	
	private Node<Integer> top;
	private Node<Integer> min;
	
	public void push(int item)
	{
		// top 처리 (top 이 있는데 min 이 없을 순 없음.)
		Node<Integer> s = new Node<Integer>(item);
		if (top == null)
		{
			top = s;
			min = s;
			return ;
		}
		s.next = top;
		top = s;
		
		/** 
		 * min 처리 
		 * temp Node 를 별도로 만드는 이유는 s 가 이미 top 에 들어가있어, 
		 * top 에서 해당 s를 변경하면 min 에도 영향이 감.ㄴ
		 * */
		if (min.data > s.data)
		{
			Node<Integer> temp = new Node<Integer>(item);
			temp.next = min;
			min = temp;
		}
	}
	
	/**
	 *
	 * 	top 에서 pop
	 * 	빠지는 변수가 minNode 에도 존재한다면, 해당 값을 pop
	 */
	public int pop()
	{
		// top 처리
		if (top == null)
			throw new EmptyStackException();
		int item = top.data;
		top = top.next;
		
		// min 처리
		if (min.data == item)
		{
			min.data = null;
			min = min.next;
		}
		
		return item;
	}
	
	public int getMinValue()
	{
		if (min == null)
			throw new EmptyStackException();
		return min.data;
	}

	@Override
	public String toString()
	{
		return "MinStack [top=" + top + ", min=" + min + "]";
	}
}
