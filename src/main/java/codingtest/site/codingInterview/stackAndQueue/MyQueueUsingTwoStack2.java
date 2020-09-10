package codingtest.site.codingInterview.stackAndQueue;

/**
 *
 *	1. 내가 처음 푼 방식은 push 할 때는 newStack 에 넣어주고
 *	2. remove 할 때는, old 에 있는 것을 제거하는 방식이다.
 *	3. 그런데 위 방법에서 병목지점을 해결하는 방법이 있다.
 *	4. 뒤집는 연산을 매번 수행하지 않으면 된다.
 *	5. 즉, push 할 때는 newStack 에만 집어넣음.
 *	6. remove 할 때는 oldStack 에서 제거하는데. 만약 stack 이 비었으면, 
 *	   newStack 에서 가져와서 뒤집음.
 *		
 */
public class MyQueueUsingTwoStack2
{
	private Stack newStack;
	private Stack oldStack;
	
	public MyQueueUsingTwoStack2()
	{
		newStack = new Stack();
		oldStack = new Stack();
	}
	
	/**
	 * newStack 은 새로 들어오는 값을 넣어줌.
	 */
	public void add(Object item)
	{
		newStack.push(item);
	}
	
	/**
	 * oldStack 에 있는 맨 마지막 값을 제거. 
	 * 만약 oldStack 에 값이 없다면, newStack 에 있는 것을 가져와서 뒤집는다.
	 * 그럼 oldStack 에는 뒤집힌 값들이 들어있다.  
	 */
	public Object remove()
	{
		Object item = null;
		if (oldStack.isEmpty())
		{
			reverse();
		}
		item = oldStack.pop();
		return item;
	}
	
	private void reverse()
	{
		if (newStack.isEmpty())
			throw new RuntimeException("Queue is null.");
		
		while ( !newStack.isEmpty())
		{
			oldStack.push(newStack.pop());
		}
	}
}
