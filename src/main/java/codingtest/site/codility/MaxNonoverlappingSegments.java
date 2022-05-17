package codingtest.site.codility;

public class MaxNonoverlappingSegments {
    int[] cache = new int[5];
    public static void main(String[] args) {
        int[] A = new int[]{1,3,7,9,9};
        int[] B = new int[]{5,6,8,9,10};
        System.out.println(new MaxNonoverlappingSegments().solution(A, B) == 3);

        A = new int[]{1,10,55,65,76};
        B = new int[]{5,50,60,70,80};
        System.out.println(new MaxNonoverlappingSegments().solution(A, B) == 5);
    }

    /**
     * 문제
     * A는 선분 시작점. B 는 선분 끝
     * A 와 B 를 이어서 선분을 만들어야 함. 단, 조합된 선분이 겹치면 안됨.
     * 겹치지 않는 제일 max 선분 조합을 찾아라.
     *
     * solution 1.
     * - A, B 는 sort 돼있음.
     * - A, B 를 2번씩 순회하면서 가능한 조합을 찾는 것
     * - A, B 순회하면서 B 의 값보다 A 가 커야지 조회가 가능하도록
     * - O(n제곱)
     *
     * solution 2.
     * - 무조건 순회를 전부 해야하는거 같음.
     * - 그럼 그 순회 중 중복된 부분을 줄일 수 있는 부분이 있는지 파악
     * - 중복되는 부분은 캐시 사용
     * - 뒤에서부터 계산해서 캐싱 해보기.
     *  cache[4] = 1, cache[3] = 1, cache[2] = 2, cache[1] = 3, cache[0] = 3
     *
     * - 핵심이 B 값에 따라 caching 이 되는지 안되는지 체크하면 될거 같은데.
     *
     *
     * solution 3.
     * - 문제를 너무 복잡하게 생각함.
     * - A, B 는 sorting 돼있다고 문제에서 설명해줬음. (이게 핵심임)
     * - 또한, A[i] <= B[i] 이 조건을 놓쳤네.
     * - 즉, A[0], B[0] 은 A Array 와 B Array 에서 가장 작은 값이 온 것이다.
     * - 그럼 선분을 만들 때, 시작점을 A[0], A[1] ... A[n-1] 로 잡을 필요가 없다.
     * - 어차피 A[0], B[0] 이 제일 작기에 모든 시작점을 찾을 필요가 없음.
     * - 즉, 시작점을 A[0] 으로 잡고 시작하면 됨. 그런 뒤, B[i] 보다 다음 A[i] 가 크면 count 하고.
     * - 만약 A[0] > A[1] 이라면 모든 시작점을 구해봐야겠지만. A[0] < A[1] 이니 앞에꺼만 구해주면 됨.
     * - 즉, A[0], B[0] 을 제외한 나머지에서 스타트를 해도 최대 조합수는 잘해야 A[0], B[0] 에서 시작하는 것과 동일한 것
     *  - 이게 중요함. 이것 때문에 시작점이 맨처음이 될 수 있는거임.
     *  - 1번 지점에서 시작하는게 제일 베스트고. 2번 지점에서 시작해도 최대 1번 지점과 같은 count 임.
     *  - 그렇기에 1번 지점에서 시작하는 것만 count 하면 답임.
     *
     * @param A
     * @param B
     * @return
     */
    public int solution(int[] A, int[] B) {
        if (A.length < 1) {
            return 0;
        }
        int end = B[0];
        int count = 1;
        for (int i = 1 ; i < A.length ; i++) {
            if (A[i] > end) {
                end = B[i];
                count++;
            }
        }
        return count;
    }
}