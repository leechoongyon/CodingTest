package codingtest.site.datastructure;

public class BinaryTree<T>
{
	public BinaryTree<T> root;
	
	public BinaryTree()
	{
		root = null;
	}
	
	public Node makeBT(T item, Node left, Node right)
	{
		Node<Object> newNode = new Node<Object>();
		newNode.item = item;
		newNode.left = left;
		newNode.right = right;
		
		if (left != null) left.parent = newNode;
		if (right != null) right.parent = newNode;
		
		return newNode;
	}
	
	@Override
	public String toString()
	{
		return "BinaryTree [root=" + root + "]";
	}

	public static class Node<T>
	{
		public T item;
		public Node<T> left;
		public Node<T> right;
		public Node<T> parent;

		@Override
		public String toString()
		{
			return "Node [item=" + item + ", left=" + left + ", right=" + right + "]";
		}
	}
	
	public static void main(String[] args)
	{
		BinaryTree<Object> bt = new BinaryTree<Object>();
		Node n1 = bt.makeBT("A", null, null);
		Node n2 = bt.makeBT("B", null, null);
		Node n3 = bt.makeBT("C", null, null);
		Node n4 = bt.makeBT("D", n1, n2);
		System.out.println(n4);
		
	}
	
	
}
