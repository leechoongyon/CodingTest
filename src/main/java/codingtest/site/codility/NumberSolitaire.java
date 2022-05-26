package codingtest.site.codility;

/**
 * A[0] = 1
 *     A[1] = -2
 *     A[2] = 0
 *     A[3] = 9
 *     A[4] = -1
 *     A[5] = -2
 */

public class NumberSolitaire {
    public static void main(String[] args) {
        int[] A = new int[] {1,-2,0,9,-1,-2};
        System.out.println(new NumberSolitaire().solution(A) == 8);
    }

    /**
     * 문제
     * array 가 주어지고, 0부터 시작해서 주사위를 던진다. 주사위를 던진 만큼 array 를 이동하며,
     * 방문한 array element 의 수를 합한 것 중 최대 값을 구하라.
     * 이게 1~6 주사위를 던질 때, 최선의 수를 구하는 것이네.
     *
     *
     * solution 1.
     * 순회하면서 + 는 모두 더하는거 같은데... 근데 이렇게 쉬울리가 없는데...
     * 근데 왜 이 답이 안되지. 한 번에 1~6 으로 옮길수 있다면 A 에 대해 전체 순회가 가능하다는건데.
     * 아.. 마지막에 도착을 해야하니까 경우의수를 뽑아야하는건가. 그런거 같네.
     *
     *
     * solution 2.
     * 순회할 때, 주사위 중 제일 최선의 수를 매번 구해나간다.
     * i = 0, 1, 2, ... n-1 까지 어떤 수를 구해야하는지 파악이 필요.
     * 이 때, cache[0], cache[1] 을 통해 중복적인 수를 줄여나가야 함.
     * 여기서 cache 는 해당 index 위치에서 최대 값을 의미.
     * 그 최대 값을 뽑기 위해서 이전 cache[x] 값들을 A[x] 와 더하면서 계산하는거지.
     *
     * cache 의미가 해당 위치까지의 최선의 경로를 구하는 것이 의미상 맞음.
     * 그리고 그 최선의 경로를 구하기 위해 이전에 구해왔던 것들을 계산하는 것이 맞고.
     * i + dice 이런식으로 가는게 아니라 i-dice 로 가는게 그 이유임.
     *
     * @param A
     * @return
     */
    public int solution(int[] A) {
        int[] cache = new int[A.length];
        cache[0] = A[0];

        for (int i = 1 ; i < A.length ; i++) {
            int max = Integer.MIN_VALUE;
            // i - dice >= 0 조건은 A 범위를 초과할 수 있기에 들어갔음.
            for (int dice = 1 ; dice <= 6 && i - dice >= 0 ; dice++) {
                // cache[i-dice] 를 통해 이전 값 중 최대 값을 구해서 최선의 경로를 찾는 것
                max = Math.max(cache[i - dice] + A[i], max);
            }
            cache[i] = max;
        }
        return cache[A.length - 1];
    }
}
