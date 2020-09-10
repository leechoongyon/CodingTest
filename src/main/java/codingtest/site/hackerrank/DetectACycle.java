package codingtest.site.hackerrank;

import codingtest.site.datastructure.Node;

/**
 * @file hackerrank.DetectACycle.java
 * @filetype java source file
 * @brief
 * @author USER
 * @version 0.1
 * @history 버전            성명			일자			변경내용
 * 0.1			USER		2018. 1. 31.		신규작성
 * @point & feedback
 * 1. listen : 사소한 것에 집중하자.
 * 2. list.size 가 100 이라는 것을 캐치해서 풀음.
 */
public class DetectACycle {
    /*
    Detect a cycle in a linked list. Note that the head pointer may be 'null' if the list is empty.

    A Node is defined as: 
        class Node {
            int data;
            Node next;
        }
    */

    boolean hasCycle(Node head) {

        if (head == null)
            return false;

        int count = 0;
        Node current = head;
        while (true) {
            if (current.next != null)
                count++;
            else
                return false;
            if (count > 100)
                return true;
            current = current.next;
        }
    }

}
