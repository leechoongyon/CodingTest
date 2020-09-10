package codingtest.site.codingInterview.linkedlist;

import codingtest.site.datastructure.Node;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 5
 * 3 4 2 1 3
 *
 * @author lee
 */

public class Problem2a {
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
        Node result = solve1(node);
        result.print();
    }

    /**
     * 1. node 를 순회하며, set 에 집어넣음.
     * 2. set 에 있는 것을 순회하며 노드를 만들어서 반환
     */
    private static Node solve(Node node) {
        Set set = new LinkedHashSet();
        Node result = null;
        while (node != null) {
            set.add(node.data);
            node = node.next;
        }

        Iterator iter = set.iterator();
        while (iter.hasNext()) {
            int n = (Integer) iter.next();
            if (result == null)
                result = new Node(n);
            else
                result.appendTail(n);
        }
        return result;
    }

    /**
     * 버퍼 없이 풀기.
     * 1. current 순회
     * 2. runner 기법 사용
     * 3. current 순회하면서, runner 를 이용하여 다음 노드 값을 확인해서 같으면
     * 현재 노드는 다음다음노드를 가리키도록.
     * 4. 만약 while (runner != null) 로 해버리면, runner.next.next 를 했을 때, runner.next = null 이면, 널포인터 발생
     */
    private static Node solve1(Node node) {
        Node current = node;

        while (current != null) {
            Node runner = current;
            while (runner.next != null) {
                if (runner.next.data == current.data)
                    runner.next = runner.next.next;
                else
                    runner = runner.next;
            }
            current = current.next;
        }
        return node;
    }
}

