package codingtest.site.codingInterview.treeAndGraph;

import codingtest.site.datastructure.BinarySearchTree;

public class Question4f {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
		
		/*tree.insert(tree.root, 4);
		tree.insert(tree.root, 2);
		tree.insert(tree.root, 6);
		tree.insert(tree.root, 1);
		tree.insert(tree.root, 3);
		tree.insert(tree.root, 5);
		tree.insert(tree.root, 7);
		System.out.println(getNextNode(tree.root));
		System.out.println(getNextNode(tree.root.left));
		System.out.println(getNextNode(tree.root.right));
		System.out.println(getNextNode(tree.root.left.left));
		System.out.println(getNextNode(tree.root.left.right));
		System.out.println(getNextNode(tree.root.right.left));
		System.out.println(getNextNode(tree.root.right.right));*/

        tree.insert(tree.root, 5);
        tree.insert(tree.root, 3);
        tree.insert(tree.root, 7);
        tree.insert(tree.root, 2);
        tree.insert(tree.root, 4);
        tree.insert(tree.root, 9);
        tree.insert(tree.root, 1);
        tree.insert(tree.root, 8);
        System.out.println(getNextNode(tree.root));
        System.out.println(getNextNode(tree.root.left));
        System.out.println(getNextNode(tree.root.right));
        System.out.println(getNextNode(tree.root.left.left));
        System.out.println(getNextNode(tree.root.left.right));
        System.out.println(getNextNode(tree.root.right.right));
        System.out.println(getNextNode(tree.root.left.left.left));
        System.out.println(getNextNode(tree.root.right.right.left));
    }

    /**
     * 1. 오른쪽 확인
     * 1.1 오른쪽 진입. 왼쪽 확인.
     * 1.2 왼쪽이 존재하면, 왼쪽 끝까지 진입
     * 1.3 왼쪽이 없으면, temp 리턴
     * 2. 오른쪽 없으면 부모로 이동
     * 3. 부모에서 right 갔을 때, 자식 노드와 같다면 right 에 위치해 있으므로, 한 번 더 부모를 탐.
     * 4. 3번을 반복하고, null 이 나오면 root 라는 얘기므로 root 리턴
     * 5. 3번을 수행했는데, 서로 다른 노드라면 left 에서 올라온 것이므로 return 부모
     */
    public static BinarySearchTree.Node getNextNode(BinarySearchTree.Node node) {
        if (node.right != null) {
            BinarySearchTree.Node temp = node.right;
            if (temp.left != null) {
                while (temp.left != null) {
                    temp = temp.left;
                }
                return temp;
            } else {
                return temp;
            }
        } else {
            BinarySearchTree.Node parent = node.parent;
            BinarySearchTree.Node temp = node;
            while (parent != null) {
                if (parent.right != null && parent.right.equals(temp)) {
                    temp = parent;
                    parent = parent.parent;
                } else {
                    return parent;
                }
            }
            return parent;
        }

    }
}
