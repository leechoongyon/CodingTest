package codingtest.site.codingInterview.linkedlist;

import codingtest.site.datastructure.Node;

import java.util.Scanner;

public class Problem2c {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        Node node = null;
        for (int i = 0; i < n; i++) {
            if (node == null)
                node = new Node(scan.nextInt());
            else
                node.appendTail(scan.nextInt());
        }
        solve(node);
    }

    private static Node solve(Node node) {
        Node result = node;
        result.data = node.next.data;
        result.next = node.next.next;
        return result;
    }
}
