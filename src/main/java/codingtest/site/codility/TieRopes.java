package codingtest.site.codility;

public class TieRopes {
    public static void main(String[] args) {
        int[] A = new int[] {1,2,3,4,1,1,3};
        int K = 4;
        System.out.println(new TieRopes().solution(K, A) == 3);

        // 만족하는 값이 없음
        A = new int[] {1,2,3,4,1,1,3};
        K = 100000;
        System.out.println(new TieRopes().solution(K, A) == 0);

        // 전부 만족
        A = new int[] {1,2,3,4,1,1,3};
        K = 1;
        System.out.println(new TieRopes().solution(K, A) == 7);

        // 랜덤
        A = new int[] {5,2,3,4,1,1,6};
        K = 5;
        System.out.println(new TieRopes().solution(K, A) == 4);

        // array length 1 - 조건 불만족
        A = new int[] {1};
        K = 5;
        System.out.println(new TieRopes().solution(K, A) == 0);

        // array length 1 - 조건 만족
        A = new int[] {2};
        K = 1;
        System.out.println(new TieRopes().solution(K, A) == 1);

        // random
        A = new int[] {2, 20000000, 1};
        K = 1;
        System.out.println(new TieRopes().solution(K, A) == 3);

        // random
        A = new int[] {1,2,3,4,5,6,7,8,9,10};
        K = 4;
        System.out.println(new TieRopes().solution(K, A) == 8);
    }

    /**
     * solution 1
     * 순회하면서 k 보다 크거나 같은게 나오면 count.
     *
     * 시간복잡도 O(n), 공간복잡도 O(1)
     *
     * 예외케이스
     *
     * @param K
     * @param A
     * @return
     */
    public int solution(int K, int[] A) {
        int sum = 0;
        int count = 0;
        for (int i = 0 ; i < A.length ; i++) {
            if (isAGreaterThanOrEqualK(A[i], K)) {
                count++;
                sum = 0;
            } else {
                sum += A[i];
            }

            if (isSumGreaterThanOrEqualK(sum, K)) {
                count++;
                sum = 0;
            }
        }
        return count;
    }

    private boolean isAGreaterThanOrEqualK(int aElement, int K) {
        return aElement >= K;
    }

    private boolean isSumGreaterThanOrEqualK(int sum, int K) {
        return sum >= K;
    }
}
