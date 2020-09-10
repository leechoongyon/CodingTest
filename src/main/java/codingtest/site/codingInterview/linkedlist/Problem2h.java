package codingtest.site.codingInterview.linkedlist;

import codingtest.site.datastructure.Node;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Problem2h {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n1 = scan.nextInt();
        Node node = null;
        for (int i = 0; i < n1; i++) {
            if (node == null)
                node = new Node(scan.next());
            else
                node.appendTail(scan.next());
        }

        solve(node);
    }

    private static Node solve(Node node) {
        /**
         * set 에다 집어넣음. 같은 순간 순환되는 부분의 첫째 노드임.
         */

        Set<Node> set = new HashSet<Node>();

        boolean isSingle = false;

        while (node != null) {
            isSingle = set.add(node);
            if (!isSingle)
                return node;
            node = node.next;
        }
        return node;
    }

    private static Node solve1(Node node) {
        Node slow = node;
        Node fast = node;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
                break;
        }

        // 만나는 지점이 없으면 return null
        if (fast == null || fast.next == null)
            return null;

        slow = node;

        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }
}
