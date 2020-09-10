package codingtest.site.datastructure;

public class Queue<T>
{
	public static class Node<T>
	{
		private T data;
		Node<T> next;
		
		public Node(T data)
		{
			this.data = data;
		}

		@Override
		public String toString()
		{
			return "Node [data=" + data + ", next=" + next + "]";
		}
	}
	
	private Node<T> first;
	private Node<T> last;
	
	public void add(T item)
	{
		Node<T> n = new Node<T>(item);
		if (first == null)
		{
			first = n;
			last = first;
			return ;
		}
		else
		{
			last.next = n;
			last = n;
		}
	}
	
	public T poll()
	{
		if (first == null)
			throw new RuntimeException("Queue is null.");
		T item = first.data;
		first = first.next;
		return item;
	}
	
	public void addFirst(T item)
	{
		Node<T> n = new Node<T>(item);
		if (first == null)
		{
			first = n;
			last = first;
		}
		else
		{
			n.next = first;
			first = n;
		}
	}

	public T peek()
	{
		return first.data;
	}
	
	public boolean isEmpty()
	{
		return first == null;
	}
	
	@Override
	public String toString()
	{
		return "Queue [first=" + first + ", last=" + last + "]";
	}

	public static void main(String [] args)
	{
		Queue<Integer> queue = new Queue<Integer>();
		queue.add(1);
		queue.add(2);
		queue.add(3);
		System.out.println(queue);
		queue.addFirst(4);
		System.out.println(queue);
		queue.add(5);
		queue.addFirst(10);
		System.out.println(queue);
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println(queue.poll());
//		System.out.println(queue.poll());
		System.out.println(queue.isEmpty());
	}
	
}
