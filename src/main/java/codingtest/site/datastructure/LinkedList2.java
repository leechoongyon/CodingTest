package codingtest.site.datastructure;

import java.util.HashSet;
import java.util.Set;

public class LinkedList2 {
    private Node root;
    private Node tail;
    public static class Node {
        private Node next;
        private Object item;
        public Node(Object item) {
            this.item = item;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "next=" + next +
                    ", item=" + item +
                    '}';
        }
    }
    public void addLast(Node newNode) {
        if (root == null) {
            root = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    @Override
    public String toString() {
        return "LinkedList{" +
                "root=" + root +
                ", tail=" + tail +
                '}';
    }

    public boolean isCycle(Node node) {
        if (node == null) {
            return false;
        } else {
            Node tmp = node;
            Set<Object> set = new HashSet<>();
            while (tmp != null) {
                if (set.contains(tmp.item)) {
                    return true;
                } else {
                    set.add(tmp.item);
                    tmp = tmp.next;
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        LinkedList2 linkedList = new LinkedList2();
        linkedList.addLast(n1);
        linkedList.addLast(n2);
        linkedList.addLast(n3);
//        linkedList.addLast(n1);
        System.out.println(linkedList.isCycle(linkedList.root));
    }
}
