package codingtest.site.codingInterview.treeAndGraph.Q4_11;

import codingtest.site.datastructure.BinaryTree;


/**
 * 1. 시간복잡도 ROOT 부터 시작해서, 재귀적으로 내려오는 문제임.
 */
public class Question {
    public static void main(String[] args) {
        BinaryTree<Integer> bt = new BinaryTree<Integer>();
        BinaryTree.Node n1 = bt.makeBT(5, null, null);
        BinaryTree.Node n2 = bt.makeBT(7, null, null);
        BinaryTree.Node n3 = bt.makeBT(3, null, null);
        BinaryTree.Node n4 = bt.makeBT(1, null, null);
        BinaryTree.Node n5 = bt.makeBT(6, n1, n2);
        BinaryTree.Node n6 = bt.makeBT(2, n4, n3);
        BinaryTree.Node n7 = bt.makeBT(4, n6, n5);
        System.out.println(countTargetSumRoute(n7, 5));
        System.out.println(countTargetSumRoute(n7, 4));
        System.out.println(countTargetSumRoute(n7, 7));
    }

    /**
     * Brute-force
     * 1. ROOT 부터 시작해서 맨 밑에까지 내려가면서 targetSum 이 맞는지 계산
     * 2. ROOT.left, ROOT.right 로 재귀적으로 1번을 반복
     */
    public static int countTargetSumRoute(BinaryTree.Node<Integer> node, int targetSum) {
        /** 초기 사례 */
        if (node == null) return 0;

        int targetSumRouteCount = 0;

        /** 1. ROOT 부터 계산 해서 모든 경우의 수를 탐색한다.
         * 	2. 모든 경우의 수를 탐색하며, targetSum 과 비교하고,
         * 	3. 같으면 targetSumRouteCount++ 함. */
        targetSumRouteCount = countTargetSumRouteFromRoot(node, 0, targetSum);

        /** 4. left, right 재귀 호출 수행. 각각의 left, right 에서의 countTargetSumRoute 를 수행
         * 	5. 모든 targetSumRouteCount 를 계산해서 반환 */
        targetSumRouteCount += countTargetSumRoute(node.left, targetSum);
        targetSumRouteCount += countTargetSumRoute(node.right, targetSum);

        return targetSumRouteCount;
    }

    public static int countTargetSumRouteFromRoot(BinaryTree.Node<Integer> node, int runningSum, int targetSum) {
        int targetSumRouteCount = 0;
        /** 초기 사례 */
        if (node == null)
            return 0;
        runningSum += node.item;
        if (runningSum == targetSum)
            targetSumRouteCount++;

        /** left 재귀 */
        targetSumRouteCount += countTargetSumRouteFromRoot(node.left, runningSum, targetSum);
        targetSumRouteCount += countTargetSumRouteFromRoot(node.right, runningSum, targetSum);

        return targetSumRouteCount;
    }
}
