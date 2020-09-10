package codingtest.site.datastructure;

public class Node
{
	public Node next;
	public Object data;
	
	public Node(Object d)
	{
		data = d;
	}
	
	public void appendTail(Object d)
	{
		Node end = new Node(d);
		Node node = this;
		
		while (node.next != null)
		{
			node = node.next;
		}
		node.next = end;
	}
	
	public Node deleteNode(Node originNode, Object d)
	{
		Node node = originNode;
		if (node.data == d)
			return node.next;
		while (node.next != null)
		{
			if (node.next.data == d)
			{
				node.next = node.next.next;
				return originNode;
			}
			node = node.next;
		}
		return originNode;
	}
	
	public void print()
	{
		Node node = this;
		while (node.data != null)
		{
			System.out.print(node.data + " ");
			if (node.next == null)
				break;
			node = node.next;
		}
		System.out.println();
	}
	
	@Override
	public String toString()
	{
		return "Node [next=" + next + ", data=" + data + "]";
	}
}
