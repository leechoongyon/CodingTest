package codingtest.site.codingInterview.linkedlist;

import codingtest.site.datastructure.Node;

import java.util.Scanner;

/**
 * 3 3
 * 7 1 6
 * 5 9 2
 * <p>
 * 3 3
 * 6 1 7
 * 2 9 5
 *
 * @author lee
 */

public class Problem2e {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n1 = scan.nextInt();
        int n2 = scan.nextInt();
        Node node1 = null;
        Node node2 = null;

        for (int i = 0; i < n1; i++) {
            if (node1 == null)
                node1 = new Node(scan.nextInt());
            else
                node1.appendTail(scan.nextInt());
        }

        for (int i = 0; i < n2; i++) {
            if (node2 == null)
                node2 = new Node(scan.nextInt());
            else
                node2.appendTail(scan.nextInt());
        }

        Node result = solve1(node1, node2);
        result.print();
    }

    public static Node solve(Node node1, Node node2) {
        /**
         * 	1. node1 을 sum 에 더함.
         * 	2. node2 를 sum 에 더함.
         * 	3. sum 을 node 로 변환하여 반환
         */
        int w1 = 1;
        int w2 = 1;

        int sum = 0;

        Node result = null;

        while (node1 != null) {
            sum += (Integer) node1.data * w1;
            node1 = node1.next;
            w1 *= 10;
        }

        while (node2 != null) {
            sum += (Integer) node2.data * w2;
            node2 = node2.next;
            w2 *= 10;
        }

        int val = 0;
        while (sum != 0) {
            val = sum % 10;
            if (result == null)
                result = new Node(val);
            else
                result.appendTail(val);

            sum /= 10;
        }
        return result;
    }

    private static Node solve1(Node node1, Node node2) {
        int len1 = -1;
        int len2 = -1;

        int sum = 0;

        Node temp1 = node1;
        Node temp2 = node2;

        while (temp1 != null) {
            temp1 = temp1.next;
            len1++;
        }

        while (temp2 != null) {
            temp2 = temp2.next;
            len2++;
        }

        while (node1 != null) {
            sum += (Integer) node1.data * (Math.pow(10, len1));
            len1--;
            node1 = node1.next;
        }

        while (node2 != null) {
            sum += (Integer) node2.data * (Math.pow(10, len2));
            len2--;
            node2 = node2.next;
        }

        String temp = Integer.toString(sum);
        int arr[] = new int[temp.length()];
        for (int i = 0; i < temp.length(); i++)
            arr[i] = temp.charAt(i) - '0';

        Node result = null;

        for (int num : arr) {
            if (result == null)
                result = new Node(num);
            else
                result.appendTail(num);
        }
        return result;
    }
}
