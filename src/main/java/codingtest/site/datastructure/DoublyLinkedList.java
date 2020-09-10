package codingtest.site.datastructure;

public class DoublyLinkedList
{
	Node top;
	Node tail;
	
	public static class Node
	{
		int data;
		Node next;
		Node prev;
		public Node(int data)
		{
			this.data = data;
		}
		@Override
		public String toString()
		{
			return "Node [data=" + data + ", next=" + next + ", prev=" + prev + "]";
		}
	}
	
	public void addLast(int data)
	{
		Node newNode = new Node(data);
		if (top == null)
		{
			top = newNode;
			tail = top;
		}
		else
		{
			tail.next = newNode;
			newNode.prev = tail;
			tail = newNode;
		}
	}
	
	@Override
	public String toString()
	{
		return "DoublyLinkedList [top=" + top + ", tail=" + tail + "]";
	}



	public static void main(String[] args)
	{
		DoublyLinkedList list = new DoublyLinkedList();
		list.addLast(1);
		list.addLast(2);
		list.addLast(3);
		System.out.println(list.top.data);
		System.out.println(list.top.next.data);
		System.out.println(list.top.next.next.data);
		System.out.println(list.top.next.next.prev.data);
		System.out.println(list.top.next.next.prev.prev.data);
	}
}

