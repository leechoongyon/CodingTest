package codingtest.site.codingInterview.treeAndGraph;

import codingtest.site.datastructure.BinaryTree;

public class Question4dImproved {
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
        return checkHeight(root) != Integer.MIN_VALUE;
    }

    public static int checkHeight(BinaryTree.Node root) {
        if (root == null) return -1;
        int leftHeight = checkHeight(root.left);
        if (leftHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE;
        int rightHeight = checkHeight(root.right);
        if (rightHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE;
        int heightDiff = Math.abs(leftHeight - rightHeight);
        if (heightDiff > 1) return Integer.MIN_VALUE;
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
