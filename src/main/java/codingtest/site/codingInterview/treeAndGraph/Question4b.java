package codingtest.site.codingInterview.treeAndGraph;

/**
 *
 * 오름차순으로 정렬된 배열이 있다. 이 배열 안에 들어 있는 원소는 정수이며 중복된 값이 없다고 했을 때, 
 * 높이가 최소가 되는 이진 탐색 트리를 만드는 알고리즘 작성
 *
 *	1. 이진 탐색 트리란?
 *		- 모든 왼쪽 자식들 <= n < 모든 오른쪽 자식들

 */
public class Question4b
{
	private static Tree root = null;
	
	public static class Tree
	{
		int item;
		Tree left;
		Tree right;
		
		public Tree()
		{
			
		}
		
		public Tree(int item)
		{
			this.item = item;
		}
		
		public void addChild(Tree tree, int item)
		{
			
		}

		@Override
		public String toString()
		{
			return "Tree [item=" + item + ", left=" + left + ", right=" + right + "]";
		}
		
		
	}
	
	public static void main(String [] args)
	{
		int arr[] = new int[] {1,2,3,4,5,6,7};
		System.out.println(solve(arr));
	}
	
	
	public static Tree solve(int arr[])
	{
		return solve(arr, 0, arr.length - 1);
	}
	
	public static Tree solve(int arr[], int start, int end)
	{
		if (start > end)
			return null;
		int mid = (start + end) / 2;
		Tree tree = new Tree(arr[mid]);
		tree.left = solve(arr, start, mid - 1);
		tree.right = solve(arr, mid + 1, end);
		return tree;
	}
}
