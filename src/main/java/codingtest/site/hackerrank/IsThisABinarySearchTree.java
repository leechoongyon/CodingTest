package codingtest.site.hackerrank;

/**
 * @author lee
 * @point & feedback
 * 	1. 문제가 묻고자 하는 것은 이 trees 가 binary search 조건을 만족하는가이다.
 * 	2. 결론만 말하면 난 이걸 무식하게 풀었다. ROOT.data 는 left 노드 전체 값 보다 커야하고 ROOT.data 는 right 노드 전체 값 보다 작아야 한다.
 * 	3. 2번이 내가 이해한 것이고 이에 따라 ROOT.data 부터 전체 탐색을 해야하고 재귀적으로 각 노드의 root.data 도 2번 조건을 만족하는지를 체크해야 함.
 * 	4. 아래 문제는 전체 탐색을 할 때 범위를 줘서 그 범위안에 들었는지 안들었는지를 체크하는 것이다. 결국 2,3번을 만족하면서 정말 깔끔하게 풀어내는 방법이다.
 * 	
 */
public class IsThisABinarySearchTree
{
	boolean checkBST(Node root)
	{
		return checkBST(root, 0, 100000);
	}

	boolean checkBST(Node root, int min, int max)
	{
		if (root == null)
			return true;

		if (!( min <= root.data ) || !( root.data <= max ))
			return false;

		if (!checkBST(root.left, min, root.data - 1) || !checkBST(root.right, root.data + 1, max))
			return false;

		return true;
	}
}

class Node
{
	int data;
	Node left;
	Node right;
}
