package codingtest.site.codingInterview.linkedlist;

import codingtest.site.datastructure.Node;

import java.util.Scanner;

public class Problem2b {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int k = scan.nextInt();
        Node node = null;
        for (int i = 0; i < n; i++) {
            if (node == null)
                node = new Node(scan.nextInt());
            else
                node.appendTail(scan.nextInt());
        }
        System.out.println(solve(node, k));
    }

    private static Object solve(Node orginNode, int k) {
        /**
         * runner 기법 사용
         * 연결리스트는 최소 k 이상이라 가정
         */
        Node node1 = orginNode;
        Node node2 = orginNode;

        while (k != 0) {
            node2 = node2.next;
            k--;
        }

        while (node2 != null) {
            node1 = node1.next;
            node2 = node2.next;
        }

        return node1.data;
    }
}
