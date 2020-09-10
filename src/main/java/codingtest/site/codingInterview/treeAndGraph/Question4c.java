package codingtest.site.codingInterview.treeAndGraph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Question4c
{
	private static Map<Integer, LinkedList<Integer>> map = new HashMap<Integer, LinkedList<Integer>>();
	
	public static class BinaryTree
	{
		private int item;
		private BinaryTree left;
		private BinaryTree right;
		
		public BinaryTree()
		{
			
		}
		@Override
		public String toString()
		{
			return "BinaryTree [item=" + item + ", left=" + left + ", right=" + right + "]";
		}
	}
	
	public static void main(String[] args)
	{
		BinaryTree root = new BinaryTree();
		root.item = 1;
		BinaryTree left = new BinaryTree();
		left.item = 2;
		BinaryTree right = new BinaryTree();
		right.item = 3; 
		root.left = left;
		root.right = right;
		solve(root, 0);
		System.out.println(map);
	}
	
	/**
	 * 	1. 트리를 탐색하는 방법에 3가지가 있음.
	 * 	2. 전위, 후위, 중위
	 * 	3. 전위 순위로 탐색하며, 각 노드들을 연결리스트에 담음.
	 * @param tree
	 */
	private static void solve(BinaryTree tree, int depth)
	{
		if ( !map.containsKey(depth))
		{
			LinkedList<Integer> linkedList = new LinkedList<Integer>();
			map.put(depth, linkedList);
		}
		LinkedList<Integer> linkedList = map.get(depth);
		
		// 전위
		if (tree.item != 0)
			linkedList.add(tree.item);
		
		// left 
		if (tree.left != null)
			solve(tree.left, depth + 1);
		// right
		if (tree.right != null)
			solve(tree.right, depth + 1);
	}
}