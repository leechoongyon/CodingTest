package codingtest.site.codingInterview.treeAndGraph.Q4_10;

import codingtest.site.datastructure.BinaryTree;

public class Question {
    public static void main(String[] args) {
        BinaryTree<String> tree = new BinaryTree<String>();
        BinaryTree.Node n1 = tree.makeBT("7", null, null);
        BinaryTree.Node n2 = tree.makeBT("6", null, null);
        BinaryTree.Node n3 = tree.makeBT("5", null, null);
        BinaryTree.Node n4 = tree.makeBT("4", null, null);
        BinaryTree.Node n5 = tree.makeBT("3", n2, n1);
        BinaryTree.Node n6 = tree.makeBT("2", n4, n3);
        BinaryTree.Node n7 = tree.makeBT("1", n6, n5);
        BinaryTree.Node n8 = tree.makeBT("0", null, null);
        System.out.println(isSubTree(n7, n1)); // true
        System.out.println(isSubTree(n7, n8)); // false
    }

    public static boolean isSubTree(BinaryTree.Node t1, BinaryTree.Node t2) {
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();

        preOrder(s1, t1);
        preOrder(s2, t2);

        return (s1.indexOf(s2.toString()) != -1);
    }

    public static void preOrder(StringBuilder sb, BinaryTree.Node tree) {
        if (tree == null) {
            sb.append("X");
            return;
        }

        sb.append(tree.item);
        preOrder(sb, tree.left);
        preOrder(sb, tree.right);
    }
}
