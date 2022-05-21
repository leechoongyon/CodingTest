package codingtest.site.codility;

import java.util.Arrays;

public class MinAbsSumOfTwo {
    public static void main(String[] args) {
        int[] A = new int[]{-8,4,5,-10,3};
        // -10, -8, 3,4,5
        // -9, -7, -5, 0, 2, 4, 7
        System.out.println(new MinAbsSumOfTwo().solution(A) == 3);

//        A = new int[]{1,4,-3};
//        System.out.println(new MinAbsSumOfTwo().solution(A) == 1);
//
//
//        // 음수
//        A = new int[]{-8,-7,-3,-1,0};
//        System.out.println(new MinAbsSumOfTwo().solution(A) == 0);
//
//        // 음수
//        A = new int[]{-8,-7,-3,-1};
//        System.out.println(new MinAbsSumOfTwo().solution(A) == 2);
//
//        // 양수
//        A = new int[]{2,3,5,8,9};
//        System.out.println(new MinAbsSumOfTwo().solution(A) == 4);
    }


    /**
     * 문제 : A 에서 2개를 선택해 더한 후, Absolute 수식을 적용한 것 중 제일 작은 값을 구하라.
     *
     *
     * solution 1
     * brute-force
     * - for 문 2번 돌려서 구하기. O(n제곱)
     *
     * solution 2
     * 정렬한 후, case 뽑아서 처리
     *
     * case 1. 전부 양수인 경우
     *  - 맨 앞 2자리 선택 --> 이건 맞음.
     *  - 0,1,2,3,4,5 --> 0
     *
     * case 2. 음수 양수 섞여있는 경우
     *  - -3, -2 , -1 , 3,4,5
     *  - 한 번 순회할 때, 앞뒤로 diff 비교
     *
     * case 3. 음수만 존재
     *  - -3, -2 , -1, 0
     *  - 맨 뒤에서 2개 선택 --> 이것도 맞음.
     *  - 0 + 0 --> 0
     *
     *
     *  solution 3
     *  절대 값으로 정렬 후, 인접한 것끼리 비교하면 됨. 왜냐하면 그럴 때 diff 가 제일 작은 값이기에
     *
     * @param A
     * @return
     */
    public int solution(int[] A) {
        if (A.length == 1) {
            return Math.abs(A[0] * 2);
        }

        Arrays.sort(A);

        int start = A[0];
        int end = A[A.length - 1];
        if (isPositive(start, end)) {
            return getMinValueWhenPositive(A);
        } else if (isMixPositiveNegative(start, end)) {
            return getMinValueWhenMixPositiveNegative(A);
        } else if (isNegative(start, end)) {
            return getMinValueWhenNegative(A);
        } else {
            throw new IllegalStateException("존재하지 않는 상태.");
        }
    }

    private int getMinValueWhenNegative(int[] A) {
        return Math.abs(A[A.length - 1] * 2);
    }

    private int getMinValueWhenPositive(int[] A) {
        return Math.abs(A[0] + A[0]);
    }

    private int getMinValueWhenMixPositiveNegative(int[] A) {
        int min = Integer.MAX_VALUE;
        int length = A.length;

        // 홀수 일 경우 가운데 구하기.
        if (length % 2 == 1) {
            min = Math.min(min, Math.abs(A[length / 2] * 2));
        }

        for (int i = 0 ; i < length / 2 ; i++) {
            int tmpMin = Integer.MAX_VALUE;
            int start = Math.abs(A[i] * 2);
            int end = Math.abs(A[length - 1 - i] * 2);
            int diff = Math.abs(A[i] + A[A.length - 1- i]);
            tmpMin = Math.min(start, end);
            tmpMin = Math.min(tmpMin, diff);
            min = Math.min(min, tmpMin);
        }
        return min;
    }

    private boolean isNegative(int start, int end) {
        return start <= 0 && end <= 0;
    }

    private boolean isMixPositiveNegative(int start, int end) {
        return start <= 0 && end > 0;
    }

    private boolean isPositive(int start, int end) {
        return start >= 0 && end >= 0;
    }
}
