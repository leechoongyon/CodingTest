package codingtest.site.codingInterview.linkedlist;

import codingtest.site.datastructure.Node;

import java.util.Scanner;
import java.util.Stack;

/**
 * 9
 * 1 2 3 4 5 4 3 2 1
 *
 * @author lee
 */

public class Problem2f {
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
        boolean result = solve(node);
        System.out.println(result);
    }

    /**
     * 1. 가운데를 기점으로 a1, a2 로 나눔.
     * 2. a2 를 거꾸로 뒤집은다음에 a1 과 비교
     */
    private static boolean solve(Node node) {
        Node head = node;
        Node temp = node;
        Node midNode = node;
        Node reverse;
        int len = 0;
        while (temp != null) {
            len++;
            temp = temp.next;
        }

        int mid = 0;
        if (len % 2 == 1)
            mid = len / 2 + 1;
        else
            mid = len / 2;


        while (mid > 0) {
            midNode = midNode.next;
            mid--;
        }


        reverse = LinkedListUtils.reverseAndClone(midNode);

        while (reverse != null) {
            if (!head.data.equals(reverse.data))
                return false;
            reverse = reverse.next;
            head = head.next;
        }
        return true;
    }

    private static boolean solve1(Node node) {
        System.out.println("node : " + node);
        Stack stack = new Stack();

        Node temp = node;
        int len = 0;
        while (temp != null) {
            temp = temp.next;
            len++;
        }

        // 홀수
        /**
         * 1 2 3 2 1
         */
        int mid = 0;
        Node midNode = node;
        if (len % 2 == 1) {
            mid = len / 2;


            while (mid != 0) {
                stack.add(midNode.data);
                midNode = midNode.next;
                mid--;
            }

            midNode = midNode.next;

            while (midNode != null) {
                Object obj = stack.pop();
                if (!obj.equals(midNode.data))
                    return false;

                midNode = midNode.next;
            }
        }
        // 짝수
        /**
         * 1 2 2 1
         */
        else {
            mid = len / 2;

            while (mid != 0) {
                stack.add(midNode.data);
                midNode = midNode.next;
                mid--;
            }

            while (midNode != null) {
                Object obj = stack.pop();
                if (!obj.equals(midNode.data))
                    return false;

                midNode = midNode.next;
            }
        }
        return true;
    }

}
