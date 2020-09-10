package codingtest.site.codingInterview.stackAndQueue;

public class Stack<T>
{
	public static class Node<T>
	{
		private T data;
		private Node next;
		public Node(T item)
		{
			this.data = item;
		}
		@Override
		public String toString()
		{
			return "Node [data=" + data + ", next=" + next + "]";
		}
	}
	
	private Node top;
	private int size;
	
	public void push(T item)
	{
		Node newNode = new Node(item);
		if (top == null)
		{
			top = newNode;
		}
		else
		{
			newNode.next = top;
			top = newNode;
		}
		size++;
		
	}
	
	public T pop()
	{
		if (top == null)
			return null;
		T item = (T) top.data;
		top = top.next;
		size--;
		return item;
	}

	public T peek()
	{
		if (top == null)
			return null;
		T item = (T) top.data;
		return item;
	}
	
	public Stack copy()
	{
		Stack reverse = this.reverse();
		Stack copy = new Stack();
		
		while (reverse.top !=  null)
		{
			copy.push(reverse.pop());
		}
		return copy;
	}
	
	public Stack reverse()
	{
		Node temp = top;
		Stack reverseStack = new Stack();
		while (temp != null)
		{
			reverseStack.push(temp.data);
			temp = temp.next;
		}
		return reverseStack;
	}
	
	public boolean isEmpty()
	{
		return size == 0;
	}
	
	public int getSize()
	{
		return size;
	}
	
	public boolean isFull(int capacity)
	{
		return size >= capacity;
	}
	
	@Override
	public String toString()
	{
		return "Stack [top=" + top + "]";
	}

	public static void main(String[] args)
	{
		Stack s = new Stack();
		s.push(1);
		s.push(2);
		s.push(3);
		
		System.out.println(s.copy());
	}
}
