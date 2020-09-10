package codingtest.site.codingInterview.linkedlist;

import codingtest.site.datastructure.Node;

import java.util.Scanner;

public class Problem2d {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int x = scan.nextInt();
        Node node = null;
        for (int i = 0; i < n; i++) {
            if (node == null)
                node = new Node(scan.nextInt());
            else
                node.appendTail(scan.nextInt());
        }
        Node result = solve(node, x);
        result.print();
    }

    private static Node solve(Node node, int x) {
        Node result = null;
        Node current = node;

        while (current != null) {
            if ((Integer) current.data < x) {
                if (result == null)
                    result = new Node(current.data);
                else
                    result.appendTail(current.data);
            }
            current = current.next;
        }

        current = node;

        while (current != null) {
            if ((Integer) current.data >= x) {
                if (result == null)
                    result = new Node(current.data);
                else
                    result.appendTail(current.data);
            }
            current = current.next;
        }
        return result;
    }
}
