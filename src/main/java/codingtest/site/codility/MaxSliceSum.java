package codingtest.site.codility;

public class MaxSliceSum {
    public static void main(String[] args) {
        int[] A = new int[] {3,2,-6,4,0};
        System.out.println(new MaxSliceSum().solution2(A));
    }

    /**
     * 부분합 구하기
     * A 베열 내에서 2개를 골라서 해당 2개의 연속되는 값들을 더함.
     * (0,2) --> 3+2-6 = -1
     *
     * 1. brute-force
     *  - 2개씩 고르는게 O(n제곱)
     *
     * 2. 한 번 순회하면서 메모리 이용
     *  - 순회하면서 더해나간다.
     *  - 더 해나가다가 max 값보다 작다면 sum 을 0 으로 초기화 시키고 다시 구해야 함.
     *
     *   sum 3 --> 5 --> -1 이니 초기화 0 -->
     *   globalMax 3 --> 5 --> 5
     *
     *
     *
     *   solution 1
     *   - 한 번 순회해서 max 값 구함. 양수가 1개라도 있는지.
     *   - 전부 음수면 음수중 제일 작은 값을 고르면 됨.
     *   - 한 번 더 순회해서 sum 을 구해나감. 양수가 1개라도 있으면 음수가 나올 경우 sum 초기화.
     *   - 이런식으로 양수만 더해서 globalMax 를 구함. O(2n)
     *
     *   solution 2
     *   1. 한 번 순회하면서 양수면 계속 더하고, 음수면 skip 함.
     *   2. 1번 반복하면서 max 값 구하기.
     *   3. max 값이 0이라면 전부 음수라는 것이고, 이 때, 순회해서 max 값 구해서 return
     *   4. 최악이 O(2n) 이지만, 전부 0이하일 때만 시도를 하니 solution 1 보다는 괜찮음.
     *
     *   예외 케이스
     *   1 --> 2 --> 3 --> -3 --> 4 이렇게 되버리면 내가 짠 알고리즘은 6이 return 되지만 답은 7 임.
     *   언제 slice 할지를 판단하는게 중요하네.
     *
     * @param A
     * @return
     */
    public int solution(int[] A) {
        int sum = A[0];
        int max = 0;
        for (int i = 1 ; i < A.length ; i++) {
            if (A[i] > 0) {
                sum += A[i];
                max = Math.max(sum, max);
            } else {
                sum = 0;
            }
        }
        return max == 0 ? max(A) : max;
    }

    /**
     * 첫번째 포인트
     * slice 하는 기준
     * slice 를 하는 기준이 sum 한 것보다 안한 것이 클 때가 맞네.
     * 왜냐하면 sum 한 것이 음수일 경우 양수를 더하는게 그냥 양수 홀로 존재하는 것보다 작기 때문
     * 그렇기에 앞에꺼를 고집할 필요 없이 새로 slice 하는거지.
     *
     * 두번째 포인트
     * 순회할 때마다 전역변수에 최대 값을 넣어놓는다. 이렇게 하면 slice 를 해도
     * 이전 부분합 중 최대 값은 저장하고 있음.
     *
     * 이것이 카데인 알고리즘임.
     * 카데인 알고리즘은 뒤에서부터 array 의 부분합을 구할 때, A[3] 은 A[2] 까지의 sum + A[3] 이라는 말이지.
     * 그럼 A[2] 까지 순회하면서 나온 값이 음수라면 slice 를 하는 기준이고.
     * 순회하면서 부분합을 계속구할 것이며, 그 부분합중 최대 값을 구하는것이지.
     *
     * @param A
     * @return
     */
    public int solution2(int[] A) {
        if (A.length == 1) {
            return A[0];
        }

        int localMaxSum = A[0];
        int globalMaxSum = A[0];

        for (int i = 1 ; i < A.length ; i++) {
            localMaxSum = Math.max(A[i], localMaxSum + A[i]);
            globalMaxSum = Math.max(globalMaxSum, localMaxSum);
        }
        return globalMaxSum;
    }

    private int max(int[] A) {
        int max = Integer.MIN_VALUE;
        for (int i = 0 ; i < A.length ; i++) {
            max = Math.max(max, A[i]);
        }
        return max;
    }
}
