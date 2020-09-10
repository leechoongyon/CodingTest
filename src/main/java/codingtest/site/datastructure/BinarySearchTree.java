package codingtest.site.datastructure;

public class BinarySearchTree
{
	public Node root;
	
	public BinarySearchTree()
	{
		root = new Node();
	}
	
	public void insert(Node root, int item)
	{
		/** 초기 사례 */
		if (root.item == Integer.MIN_VALUE)
		{
			root.item = item;
			return ;
		}
		
		/** root 와 비교 */
		if (root.item > item)
		{
			if (root.left == null)
			{
				root.left = new Node();
				root.left.parent = root;
			}
			insert(root.left, item);
		}
		else if (root.item < item)
		{
			if (root.right == null)
			{
				root.right = new Node();
				root.right.parent = root;
			}
			insert(root.right, item);
		}
	}
	
	@Override
	public String toString()
	{
		return "BinarySearchTree [root=" + root + "]";
	}

	public static class Node
	{
		public Node()
		{
			item = Integer.MIN_VALUE;
		}
		
		public int item;
		public Node left;
		public Node right;
		public Node parent;
		
		@Override
		public String toString()
		{
			return "Node [item=" + item + ", left=" + left + ", right=" + right + "]";
		}
	}
	
	public static void main(String[] args)
	{
		BinarySearchTree tree = new BinarySearchTree();
		tree.insert(tree.root, 4);
		tree.insert(tree.root, 3);
		tree.insert(tree.root, 6);
		tree.insert(tree.root, 1);
		tree.insert(tree.root, 2);
		tree.insert(tree.root, 5);
		tree.insert(tree.root, 7);
		System.out.println(tree);
		
	}
}
