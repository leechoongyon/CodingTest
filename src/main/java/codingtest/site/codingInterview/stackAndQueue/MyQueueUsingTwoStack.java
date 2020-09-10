package codingtest.site.codingInterview.stackAndQueue;

public class MyQueueUsingTwoStack
{
	private Stack orderedStack;
	private Stack reverseOrderedStack;
	
	public MyQueueUsingTwoStack()
	{
		reverseOrderedStack = new Stack();
	}
	
	public void add(Object item)
	{
		reverseOrderedStack.push(item);
		orderedStack = null;
		reverse(reverseOrderedStack);
	}

	public Object poll()
	{
		/**
		 * 1. reverseOrderedStack 에 값이 없거나.
		 * 2. reverseOrderedStack 에 값이 있거나.
		 */
		if (reverseOrderedStack.isEmpty())
			throw new RuntimeException("Queue is null");
		
		reverseOrderedStack.pop();
		return orderedStack.pop();
	}
	
	private void reverse(Stack reverseOrderedStack)
	{
		Stack temp = reverseOrderedStack.copy();
		orderedStack = new Stack();
		while ( !temp.isEmpty())
		{
			orderedStack.push(temp.pop());
		}
	}
	
	@Override
	public String toString()
	{
		return "MyQueueUsingTwoStack [orderedStack=" + orderedStack + ", reverseOrderedStack=" + reverseOrderedStack
				+ "]";
	}
}
