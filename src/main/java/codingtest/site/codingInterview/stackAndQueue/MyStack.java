package codingtest.site.codingInterview.stackAndQueue;

import java.util.EmptyStackException;

public class MyStack
{
	public static class StackNode
	{
		private Object data;
		private StackNode next;
		public StackNode(Object data)
		{
			this.data = data;
		}
	}
	
	private StackNode top;
	
	public Object pop()
	{
		if (top == null)
			throw new EmptyStackException();
		
		Object item = top.data;
		top = top.next;
		return item;
	}
		
	public void push(Object item)
	{
		StackNode stack = new StackNode(item);
		stack.next = top;
		top = stack;
	}
		
	public Object peek()
	{
		return top.data;	
	}
}
