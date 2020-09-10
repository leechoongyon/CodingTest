package codingtest.site.codingInterview.stackAndQueue;

import java.util.EmptyStackException;

public class FixedMultiStack
{
	private int numOfStacks = 3;
	private Object values[];
	private int index[];
	private int capacity;
	
	/** 각각의 스택의 크기와 인덱스 크기 결정 */
	public FixedMultiStack(int size)
	{
		values = new Object[numOfStacks * size];
		index = new int[numOfStacks];
		capacity = size;
	}
	/** 스택의 넘버를 받아, 해당 스택에 data 를 집어넣는다. */
	public void push(int stackNum, Object data)
	{
		if (isFull(stackNum))
			throw new RuntimeException("Stack[" + stackNum + "] is full.");
		values[indexOfTop(stackNum)] = data;
		index[stackNum]++;
	}
	 
	/** 스택의 넘버를 받아 해당 스택의 top 을 pop 한다. */
	public Object pop(int stackNum)
	{
		if (isEmpty(stackNum))
			throw new EmptyStackException();
		Object item = values[indexOfTop(stackNum)];
		values[indexOfTop(stackNum)] = null;
		index[stackNum]--;
		return item;
	}
	
	public Object peek(int stackNum)
	{
		if (isEmpty(stackNum))
			throw new EmptyStackException();
		return values[indexOfTop(stackNum)];
	}
	
	private boolean isEmpty(int stackNum)
	{
		return index[stackNum] == 0;
	}
	
	private boolean isFull(int stackNum)
	{
		return index[stackNum] >= capacity;
	}
	
	private int indexOfTop(int stackNum)
	{
		int offset = stackNum * capacity;
		return index[stackNum] + offset;
	}
	
	public Object[] getValues()
	{
		return values;
	}
}
