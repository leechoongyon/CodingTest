package codingtest.site.codingInterview.linkedlist;

import codingtest.site.datastructure.Node;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 3 3
 * 1 2 3
 * 1 2 3
 *
 * @author lee
 */

public class Problem2g {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n1 = scan.nextInt();
        int n2 = scan.nextInt();
        Node node1 = null;
        for (int i = 0; i < n1; i++) {
            if (node1 == null)
                node1 = new Node(scan.next());
            else
                node1.appendTail(scan.next());
        }

        Node node2 = null;
        for (int i = 0; i < n2; i++) {
            if (node2 == null)
                node2 = new Node(scan.next());
            else
                node2.appendTail(scan.next());
        }
        solve(node1, node2);
    }

    private static Node solve(Node node1, Node node2) {
        /**
         * 두 개 노드에서 교집합을 찾아라.
         *
         * node1 순회하면서 node2 에 있는 것을 비교한다.
         * O(n2)
         *
         * 주소 값이 같다는건 값이 같다는거고. 뒤에 next 도 같다는 얘기임.
         * 값 비교 또는 주소 비교를 할려면, 전체 비교가 들어가야 됨.
         *
         * 전체 비교를 안하는 방법이 있을까?
         * 1 --> 2 --> 3 --> 4
         * 0 --> 2 --> 3 --> 4
         *
         *
         *
         * 버퍼를 사용해서 처리
         * O(n)
         *
         * 버퍼를 사용안하고 처리하는 방법이 있는가?
         */

        Set<Node> set = new HashSet<Node>();
        boolean isSingle = false;
        while (node1 != null) {
            isSingle = set.add(node1);
            node1 = node1.next;
        }

        while (node2 != null) {
            isSingle = set.add(node2);
            if (!isSingle)
                return node2;
            node2 = node2.next;
        }
        return node2;
    }
}
