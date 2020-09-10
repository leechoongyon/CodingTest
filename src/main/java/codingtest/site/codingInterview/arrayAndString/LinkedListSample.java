package codingtest.site.codingInterview.arrayAndString;

import codingtest.site.datastructure.Node;

public class LinkedListSample {
    public static void main(String[] args) {
        Node node = new Node(1);
        node.appendTail(2);
        node.appendTail(3);
        node.appendTail(4);
        node.appendTail(5);
        node.print();
        Node deleteNode = node.deleteNode(node, 4);
        deleteNode.print();
    }
}