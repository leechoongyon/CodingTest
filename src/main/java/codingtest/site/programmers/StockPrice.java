package codingtest.site.programmers;

import java.util.Stack;

public class StockPrice {
    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 2, 3};
        int[] answers = new StockPrice().solution(prices);
        for (int i = 0; i < answers.length; i++) {
            System.out.print(answers[i] + " ");
        }
    }

    public int[] solution(int[] prices) {


        /**
         * 1. brute-force
         *      - for 문 2번 돌리면서 확인 O(n제곱)
         *
         * 2. Stack 이용
         *      - for 문 돌리면서 스택에 한개 씩 넣기.
         *      - 스택에 넣는 조건은 스택에 있는 top 보다 작을 경우 넣는다.
         *      - 스택에서 빼낸 것은 계산을 해준다.
         *      - 위에처럼 돌리고 마지막까지 스택에 남아있는 것은 뒤에 있는 것들이 작다는 것이니 stack 에서 빼서 계산.
         *      - 2 3 4 5 1
         *      - 시간복잡도가 최악의 경우 O(n제곱) 이 나올 수 있는건가? 나올 수 있음. 구조상
         *      - 일단 최선의 경우 O(n) 이 나옴.
         *      - 최악의 경우 O(n) < x < O(n제곱) 사이에 있을거 같음.
         */

        Stack<Integer> startIdxs = new Stack<>();
        int[] answers = new int[prices.length];

        startIdxs.push(0);
        for (int i = 1; i < prices.length; i++) {
            while (!startIdxs.empty() && prices[i] < prices[startIdxs.peek()]) {
                int beginIdx = startIdxs.pop();
                answers[beginIdx] = i - beginIdx;
            }
            startIdxs.push(i);
        }
        while (!startIdxs.empty()) {
            int beginIdx = startIdxs.pop();
            answers[beginIdx] = prices.length - beginIdx - 1;
        }

        return answers;
    }
}
