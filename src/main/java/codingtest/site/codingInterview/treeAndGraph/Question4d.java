package codingtest.site.codingInterview.treeAndGraph;

import codingtest.site.datastructure.BinaryTree;

/**
 * 1. ROOT 부터 시작해서 height 계산.
 * 1.1 재귀적으로 호출하면서 높이 계산
 * 2. ROOT.left, ROOT.right 가 균형잡혔는지 재귀적으로 확인
 */

public class Question4d {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        BinaryTree.Node n1 = tree.makeBT("G", null, null);
        BinaryTree.Node n2 = tree.makeBT("F", null, null);
        BinaryTree.Node n3 = tree.makeBT("E", null, null);
        BinaryTree.Node n4 = tree.makeBT("D", null, null);
        BinaryTree.Node n5 = tree.makeBT("C", n2, n1);
        BinaryTree.Node n6 = tree.makeBT("B", n4, n3);
        BinaryTree.Node n7 = tree.makeBT("A", n6, n5);
        System.out.println(isBalance(n7));
    }

    public static boolean isBalance(BinaryTree.Node root) {
        /** 초기 사례 */
        if (root == null) return true;

        int heightDiff = Math.abs(getHeight(root.left) - getHeight(root.right));
        if (heightDiff > 1) return false;

        return isBalance(root.left) && isBalance(root.right);
    }

    public static int getHeight(BinaryTree.Node node) {
        if (node == null) return -1;
        return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
    }
}
