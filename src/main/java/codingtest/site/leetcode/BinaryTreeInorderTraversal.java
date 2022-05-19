package codingtest.site.leetcode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal {
    public static void main(String[] args) {
        // case 1
//        TreeNode treeNode2 = new TreeNode(2);
//        TreeNode treeNode3 = new TreeNode(3);
//        treeNode2.left = treeNode3;
//        TreeNode treeNode = new TreeNode(1, null, treeNode2);
//        List<Integer> result =
//                new BinaryTreeInorderTraversal().inorderTraversal(treeNode);

        // case 2
        TreeNode treeNode = new TreeNode(0, null, null);
        List<Integer> result =
                new BinaryTreeInorderTraversal().inorderTraversal(treeNode);


        // case 3
//        TreeNode treeNode = new TreeNode(1);
//        List<Integer> result =
//                new BinaryTreeInorderTraversal().inorderTraversal(treeNode);


        for (int num : result) {
            System.out.print(num + " ");
        }

    }

    /**
     * 중위순회
     * left --> root --> right
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorderTraversal(root, result);
        return result;
    }

    public void inorderTraversal(TreeNode root, List<Integer> result) {
        if (root != null) {
            inorderTraversal(root.left, result);
            result.add(root.val);
            inorderTraversal(root.right, result);
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
