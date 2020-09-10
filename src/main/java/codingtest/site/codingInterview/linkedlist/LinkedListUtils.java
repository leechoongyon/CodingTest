package codingtest.site.codingInterview.linkedlist;

import codingtest.site.datastructure.Node;

public class LinkedListUtils {
    public static Node reverse(Node node) {
        Node head = node;
        Node curNode = null;
        Node tail = null;
        while (head != null) {
            curNode = head.next; // 현재 노드 보존
            head.next = tail;    // 뒤집기
            tail = head;    // 위에서 뒤집은걸 누적해서 tail 에 붙임.
            head = curNode;    // 다음에 빼올 값을 head 에 넣어둠.
        }
        return tail;
    }

    public static Node reverseAndClone(Node node) {
        Node head = null;
        while (node != null) {
            Node n = new Node(node.data);
            n.next = head;
            head = n;
            node = node.next;
        }
        return head;
    }


    private static Node solve(Node node) {
        Node curNode = null;
        Node tail = null;
        while (node != null) {
            curNode = node.next;
//			System.out.println("curNode = node.next; : " + curNode);
            node.next = tail;
//			System.out.println("node.next = tail : " + node.next);
            tail = node;
//			System.out.println("tail = node : " + tail);
            node = curNode;
//			System.out.println("node = curNode : " + node);
//			System.out.println();
        }
        return tail;
    }

    private static Node solve1(Node node) {
        Node tail = null;
        while (node != null) {
            Node n = new Node(node.data);
            n.next = tail;
            tail = n;
            node = node.next;
        }
        return tail;
    }

    public static void main(String[] args) {
        Node node = new Node(1);
        node.appendTail(2);
        node.appendTail(3);
        node.appendTail(4);
        node.appendTail(5);
        System.out.println(node);
        System.out.println(solve(node));
//		System.out.println(solve1(node));
    }
}
