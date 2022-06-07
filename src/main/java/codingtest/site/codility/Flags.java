package codingtest.site.codility;

import java.util.ArrayList;
import java.util.List;

public class Flags {
    public static void main(String[] args) {
//        // 1,3,5,10
//        int[] A = new int[]{1,5,3,4,3,4,1,2,3,4,6,2};
//        System.out.println(new Flags().solution(A) == 3);
//
//        // flags 없음
//        A = new int[]{1,1,1,1,1,1,1,1};
//        System.out.println(new Flags().solution(A) == 0);
//
//        // flags 최대 1개
//        A = new int[]{1,1,5,1,1,1,1,1};
//        System.out.println(new Flags().solution(A) == 0);
//
//        A = new int[]{1,5,1,1,1,1,7,1};
//        System.out.println(new Flags().solution(A) == 2);

        int[] A = new int[]{1,1,5,1,1,1,1,1};
        System.out.println(new Flags().solution(A));
    }

    /**
     * 문제
     * array 가 주어지고, 그 array 에서 peaks ( A[P-1] < A[P] > A[P+1] ) 를 구한다.
     * peaks 에다가 flag 를 set 할 수 있다. 단, flag 간의 거리는 flag 의 수보다 크거나 같아야 한다.
     * 예를 들면, flag 를 3개 선택했으면 flag 간의 거리는 3이상이여야 한다.
     *
     *
     * solution 1.
     * a. peaks 를 구하고.
     * b. flags 는 최대 peaks 만큼만 선택가능
     *  - peaks 가 3개면 최대 flags 는 3개까지 선택가능. 각 peaks 간의 길이는 3이상이 되야하겠지.
     * c. peaks 개수만큼 for 문을 돌림. 최대 값에서부터. 이것이 flags 개수임.
     * d. 앞에서부터 peaks 를 시작하면서 해당 flags 개수를 만족하는지 체크
     *
     * ** 시간복잡도 : O(n제곱)
     *
     * ** 최적화
     * a. 이미 순회했던 것들을 저장해놓는 것
     *
     *
     *
     * solution 2.
     *  a. 위에랑 동일한데 최적화. 이미 순회했던 것을 cache 처리
     *  b. peaks 최대 수 만큼 for 문
     *  c. peaks 를 순회할 때, 뒤에서부터 순회하고. 해당 위치를 순회할 때마다 cache 에 데이터를 세팅
     *
     * ** 시간복잡도
     *
     * ** 공간복잡도
     *
     * ** 최적화
     *
     * ** 예외케이스
     *
     * ** 기저사레 (peaks 가 2 이하이거나, A length 가 2이하이거나)
     *
     * @param A
     * @return
     */
    public int solution(int[] A) {
        if (A.length <= 2) {
            return 0;
        }

        List<Integer> peaks = getPeaks(A);

        // peaks 가 2개라는건 길이가 2이상을 만족하면 된다는거고. peaks 특성상 길이가 2이상이다.
        if (peaks.size() <= 2) {
            return peaks.size();
        }

        // 플래그간의 거리가 k length 이상이고, k 개수만큼 선택할 수 있다고 했으니 length 는 K 제곱 이상
        int maxFlag = (int) Math.sqrt( (peaks.get(peaks.size() - 1) - peaks.get(0) ) + 1);


        for (int flags = maxFlag ; flags >= 2 ; flags--) {
            int count = 1;
            int currentPos = peaks.get(0);
            for (int idx = 1 ; idx < peaks.size() ; idx++) {
//                if (Math.abs(currentPos - peaks.get(idx)) >= flags) {
                if (currentPos + flags <=  peaks.get(idx)) {
                    count++;
                    currentPos = peaks.get(idx);
                }

                if (count >= flags) {
                    return flags;
                }
            }
        }
        return 2;
    }

    public int solution2(int[] A) {
        List<Integer> peaks = getPeaks(A);

        int[] cache = new int[A.length];

        int peaksLength = peaks.size();

        for (int flags = peaksLength ; flags >= 2 ; flags--) {
            int start = peaks.get(peaksLength - 1);
            int count = 1;
            // peaks 를 순회한다. start 위에서 세팅했으니 뒤에서 2번째부터 시작
            for (int idx = peaksLength - 2 ; idx >= 0 ; idx--) {
                if (cache[idx] != 0) {
                    count += cache[idx];
                    return count;
                }

                if (Math.abs(start - peaks.get(idx)) >= flags) {
                    count++;
                    start = peaks.get(idx);
                    cache[idx] = count;
                }

                if (count == flags) {
                    cache[idx] = count;
                    return count;
                }
            }
        }
        return 0;
    }

    private List<Integer> getPeaks(int[] A) {
        List<Integer> peaks = new ArrayList<>();
        for (int idx = 1; idx < A.length - 1; idx++) {
            if (A[idx - 1] < A[idx] && A[idx] > A[idx + 1]) {
                peaks.add(idx);
            }
        }
        return peaks;
    }
}
