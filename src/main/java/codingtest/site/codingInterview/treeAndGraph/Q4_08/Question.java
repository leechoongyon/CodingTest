package codingtest.site.codingInterview.treeAndGraph.Q4_08;

import codingtest.site.datastructure.BinaryTree;

public class Question {
    public static void main(String[] args) {
		/*BinaryTree<Object> bt = new BinaryTree<Object>();
		Node n1 = bt.makeBT(7, null, null);
		Node n2 = bt.makeBT(5, null, null);
		Node n3 = bt.makeBT(3, null, null);
		Node n4 = bt.makeBT(1, null, null);
		Node n5 = bt.makeBT(6, n2, n1);
		Node n6 = bt.makeBT(2, n4, n3);
		Node n7 = bt.makeBT(4, n6, n5);*/

        BinaryTree<Object> bt = new BinaryTree<Object>();
        BinaryTree.Node n0 = bt.makeBT(1, null, null);
        BinaryTree.Node n1 = bt.makeBT(8, null, null);
        BinaryTree.Node n2 = bt.makeBT(9, n1, null);
        BinaryTree.Node n3 = bt.makeBT(4, null, null);
        BinaryTree.Node n4 = bt.makeBT(2, n0, null);
        BinaryTree.Node n5 = bt.makeBT(7, null, n2);
        BinaryTree.Node n6 = bt.makeBT(3, n4, n3);
        BinaryTree.Node n7 = bt.makeBT(5, n6, n5);

        System.out.println(getCommonAncestor(n0, n4));
        System.out.println(getCommonAncestor(n0, n1));
        System.out.println(getCommonAncestor(n0, n3));
    }

    /**
     * 부모 노드가 있다고 가정해서 풀기.
     * 1. n1, n2 가 만날 때까지 수행.
     * 2. n1, n2 의 높이를 맞춰줌.
     * 3. 그런 뒤, 하나씩 올라 감.
     */
    public static BinaryTree.Node getCommonAncestor(BinaryTree.Node n1, BinaryTree.Node n2) {
        int d1 = getDepth(n1);
        int d2 = getDepth(n2);
        int depthDiff = d1 - d2;
        if (depthDiff > 0) n1 = goUpBy(n1, depthDiff);
        else if (depthDiff < 0) n2 = goUpBy(n2, depthDiff);

        /** 높이를 맞춘 뒤, 같을 경우 */
        if (n1 == n2) return n1;

        while (n1 != n2) {
            n1 = n1.parent;
            n2 = n2.parent;
        }
        return n1;
    }

    public static BinaryTree.Node goUpBy(BinaryTree.Node node, int depthDiffCount) {
        while (depthDiffCount != 0) {
            node = node.parent;
            depthDiffCount--;
        }
        return node;
    }

    public static int getDepth(BinaryTree.Node node) {
        int depth = 0;
        BinaryTree.Node temp = node;
        while (temp.parent != null) {
            temp = temp.parent;
            depth++;
        }
        return depth;
    }
}

