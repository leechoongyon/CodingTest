package codingtest.site.codingInterview.stackAndQueue;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

public class SetOfStacks
{
	private List<Stack> stacks;
	private int capacity = 0;

	public SetOfStacks (int defaultSize)
	{
		capacity = defaultSize;
	}
	
	public void push(Object item)
	{
		Stack stack = getLastStack();
		if (stack == null)
		{
			Stack newStack = new Stack();
			newStack.push(item);
			if (stacks == null)
				stacks = new ArrayList<Stack>();
			stacks.add(newStack);
		}
		else
		{
			if (stack.isFull(capacity))
			{
				Stack newStack = new Stack();
				newStack.push(item);
				stacks.add(newStack);
			}
			else
			{
				stack.push(item);
			}
		}
	}		
	
	public Object pop()
	{
		/**
		 * 	1. lastStack 에 이미 데이터가 있는 경우
		 * 		- 있는 데이터를 pop 하면 됨.
		 * 	2. lastStack 이 null 
		 */
		Stack lastStack = getLastStack();
		Object item = null;
		if (lastStack == null)
			throw new EmptyStackException();
		else
		{
			item = lastStack.pop();
			if (lastStack.getSize() == 0)
			{
				removeLastStack();
			}
		}
		return item;
	}
	
	public Stack getLastStack()
	{
		if (stacks == null || stacks.size() == 0)
			return null;
		return stacks.get(stacks.size() - 1);
	}
	
	public Object popAt(int stackNum)
	{
		/**
		 * 	1. 특정 Stack 이 null 인 경우
		 * 	2. 특정 Stack 에 데이터가 있는 경우
		 * 		- pop 시킴.
		 * 		- [TEST] 중간 Stack pop 시킨 뒤, 중간 stack 이 나올 때까지 pop 테스트
		 */

		Stack lastStack = getLastStack();
		if (lastStack == null)
			throw new EmptyStackException();
		Object item = lastStack.pop();
		return item;
	}
	
	public List<Stack> getStacks()
	{
		return stacks;
	}
	
	private void removeLastStack()
	{
		stacks.remove(stacks.size() - 1);
	}
}
