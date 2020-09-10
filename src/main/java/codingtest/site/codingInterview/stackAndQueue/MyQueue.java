package codingtest.site.codingInterview.stackAndQueue;

public class MyQueue
{
	public static class QueueNode
	{
		private Object data;
		private QueueNode next;
		public QueueNode(Object data)
		{
			this.data = data;
		}
	}
	
	private QueueNode first;
	private QueueNode last;
	
	public void add(Object data)
	{
		QueueNode t = new QueueNode(data);
		
		if (last != null)
			last.next = t;
		
		last = t;
		if (first == null)
			first = last; 
	}
	
	public Object remove()
	{
		if (first == null)
			throw new RuntimeException("Empty");
		
		Object item = first.data;
		
		first = first.next;
		
		if (first == null)
			last = null;
		
		return item;
	}
	
	public Object peek()
	{
		return first.data;
	}
}

