package codingtest.site.codility;

import java.util.Arrays;

public class MinAbsSumOfTwo {
    public static void main(String[] args) {
//        int[] A = new int[]{-8,-7,-3,-1};
//        System.out.println(new MinAbsSumOfTwo().solution(A) == 2);

        int[] A = new int[]{-8,4,5,-10,3};
        System.out.println(new MinAbsSumOfTwo().solution(A) == 3);
//
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


    public int solution(int[] A) {
        int N = A.length;
        Arrays.sort(A);
        int head = 0;
        int tail = N - 1;

        // 양끝에서부터 시작
        int min = Math.abs(A[head] + A[tail]);
        while (head <= tail) {
            int currentSum = A[head] + A[tail];
            min = Math.min(min, Math.abs(currentSum));
            // 음수라는건 head 쪽에 음수가 있다는 것. 그러므로 음수 쪽을 오른쪽으로 이동시켜주면 더 작아지겠지.
            if (currentSum <= 0) {
                head++;
            }
            // 0이상이라는건 tail 쪽 양수가 크다는 것. 그러면 tail 쪽을 왼쪽으로 옮겨주면 작아지겠지.
            else {
                tail--;
            }
        }
        return min;
    }

    public int solution3(int[] A) {
        Integer[] tmp = Arrays.stream(A).boxed().toArray(Integer[]::new);

        Arrays.sort(tmp, (a,b) -> (Integer.compare( Math.abs(a),  Math.abs(b))));

        int min = Math.abs(tmp[0] + tmp[0]);

        for (int i = 0 ; i < tmp.length - 1 ; i++) {
            min = Math.min(min, Math.abs(tmp[i] + tmp[i+1]));
        }
        return min;
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
     *
     *  solution 4
     *  sort 한 후, 양 끝에서부터 diff 를 비교해 나간다.
     *  diff 가 음수라면 왼쪽에 있는 값(음수) 가 작다는 것이다. 오른쪽으로 이동시켜준다.
     *  음수에서 오른쪽으로 이동할수록 절대 값은 작아질테니.
     *  diff 가 양수라면 오른쪽에 있는 값(양수) 가 크다는 것이다. 왼쪽으로 이동시켜준다.
     *  양수에서 왼쪽으로 이동할수록 절대 값은 작아질테니.
     *
     *  즉, head, tail index point 를 둬서 절대 값이 작아지는 방향으로 계속 계산해나가느 방식이다.
     *  시간복잡도 O(n log n)
     * 
     * @param A
     * @return
     */
    public int solution2(int[] A) {
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
