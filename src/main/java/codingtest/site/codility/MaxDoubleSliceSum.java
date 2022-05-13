package codingtest.site.codility;

public class MaxDoubleSliceSum {
    public static void main(String[] args) {
        int[] A = new int[] {3,2,6,-1,4,5,-1,2};  // 17
        System.out.println(new MaxDoubleSliceSum().solution(A) == 17);
        A = new int[] {-1, -2, -3, -4, -5, -6}; // 0
        System.out.println(new MaxDoubleSliceSum().solution(A) == 0);
        A = new int[] {-1, 5, -3, 7, -5, -6}; // 12
        System.out.println(new MaxDoubleSliceSum().solution(A) == 12);
        A = new int[] {1,2,3,4,5,6,7}; // 18
        System.out.println(new MaxDoubleSliceSum().solution(A) == 18);
        A = new int[] {1, 1, 0, 10, -100, 10, 0}; // 21
        System.out.println(new MaxDoubleSliceSum().solution(A) == 21);
        A = new int[] {1, 0, 1, 1, -1, 1, 1}; // 3
        System.out.println(new MaxDoubleSliceSum().solution(A) == 3);
        A = new int[] {1,1,1,1,-1000000,1,-1000000,1,1,1, 1}; // 4
        System.out.println(new MaxDoubleSliceSum().solution(A) == 4);
    }

    /**
     * MaxSliceSum 이 2개를 뽑는거라면 이건 3개를 뽑는거임.
     *
     * 1. brute-force
     *  - 3개를 뽑는거니 3번을 돌려야 함. O(n3제곱)
     *
     * 2. 한 번 순회하면서 메모리를 이용하는 방식으로 풀어야할거 같음.
     *
     *  - 3,2,6,-1,4,5,-1,2
     *
     *  - MaxSliceSum과 같이 순회하면서 max 값을 구함.
     *  - 동시에 min 값을 구하면서 sum 에서 min 을 뺄 수가 있음. 왜냐하면 3개를 고르는거니까
     *  - 또한, MaxSliceSum 과는 다르게 선택한거는 포함시킬 수가 없음. 이점 고려해야 함.
     *  - 동시에 min 값을 구함. globalMax 값을 구할 때, sum + min 을 구함.
     *  - localMax 가 변경될 때 (=이전에 합한 값들이 마이너스여서 currentValue 를 더해도 max 값이 안구해질 때)
     *    localMin 도 같이 변경되야 됨.
     *  - slice 한 index 내에 있는 값들만 포함시키기에 1부터 n-1 까지 조회
     *  - currentValue > currentValue + localMax 일 때, localMin 은 0 이 맞음. 왜냐하면 아무것도 선택안했으니
     *
     *  예외 케이스
     *  1, 1, 0, 10, -100, 10, 0
     *  내가 작성한 알고리즘으로는 위 예시가 1번 부터 5번까지 합을 구하지는 않음.
     *
     * 모든 예외 케이스를 다 뽑아봐야 함.
     *
     * @param A
     * @return
     */
    public int solution2(int[] A) {
        int localMax = 0;
        int globalMax = 0;
        int localMin = Integer.MAX_VALUE;   // 초기 세팅은 MAX_VALUE 로 해야 함. 전부 양수일 때 MIN 값이 안 구해짐.

        for (int i = 1 ; i < A.length - 1 ; i++) {
            if (localMax + A[i] - localMin < A[i]) {    // 이 부분이 slice 를 나누는 포인트. x,y,z 를 고르는건데 y 는 제외시켜야 하는 것이 반드시 들어가야 함.
                localMax = A[i];
                localMin = A[i];   // localMin 이 본인이 될 수 있는 것은 본인이 제외될 수도 있음.
                globalMax = Math.max(globalMax, localMax - localMin);
            } else {
                localMax = localMax + A[i];
                localMin = Math.min(localMin, A[i]);
                globalMax = Math.max(globalMax, localMax - localMin);
            }
        }
        return globalMax;
    }

    /**
     * x,y,z 를 뽑아서 부분합을 구하는 문제인데.
     * y 는 제외시켜야 한다. 그럼 y 를 기준으로 왼쪽에 있는 부분합과 오른 쪽에 있는 부분합을 구해서 합해주면 그것이 max 값이다.
     * 앞, 뒤 부분합을 구할 때, 0을 비교 대상으로 하는 경우는 x,y / y,z 가 인접할 경우 0 이기 때문에 제일 작은 값은 0미만 일수가 없음.
     *
     *
     * @param A
     * @return
     */
    public int solution(int[] A) {
        int maxSum = 0;

        if (A.length == 3) {
            return 0;
        }

        int[] headSum = new int[A.length];
        int[] tailSum = new int[A.length];

        // headSum, tailSum 은 0보다 작을 수 없음. array 각 위치 max 값을 구함.
        for (int x = 1 ; x < A.length ; x++) {
            headSum[x] = Math.max(0, headSum[x-1] + A[x]);
        }

        for (int z = A.length - 2 ; z >= 1 ; z--) {
            tailSum[z] = Math.max(0, tailSum[z+1] + A[z]);
        }

        // 여기서 y 는 x,y,z 의 y 이다. 즉, y 를 기준으로 앞의 부분합과 뒤의 부분합을 구하는 것이다. y는 제외되는 것이지.
        for (int y = 1 ; y < A.length-1 ; y++) {
            maxSum = Math.max(maxSum, headSum[y-1] + tailSum[y+1]);
        }

        return maxSum;
    }
}
