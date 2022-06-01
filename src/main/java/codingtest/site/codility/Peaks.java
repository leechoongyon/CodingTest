package codingtest.site.codility;

import java.util.ArrayList;
import java.util.List;

public class Peaks {
    public static void main(String[] args) {
        int[] A = new int[] {1,2,3,4,3,4,1,2,3,4,6,2};
        System.out.println(new Peaks().solution(A) == 3);
    }

    /**
     *
     * 문제 : array 를 같은 갯수로 divide 했을 때, Peaks 가 최소 1개 이상 있어야 함.
     *
     *
     * 1 100 99 101 98 102 97 103 96 104 - array length 10, peaks 4 (10개면 최대 4개 나올 수 있음) --> max result : 2
     *
     * solution 1.
     * - peaks count 만큼 array length 를 나눠줌. for (i = peaks count ; i >= 1 ; i--)
     *  - array length % peaks count == 0 이 나와야 함
     *  - for 문
     * - 0이 떨어진 divide 수를 가지고 peaks count 를 나눠보자.
     *  - for 문
     * - peaks count 를 나눠서 나온 나머지들을 set 에 저장.
     * - 마지막에 set 을 순회해서 0 ~ divide 수 만큼 전부 들어가있는지 확인
     *
     * - n 제곱
     *
     *
     *
     * solution 2
     * - peaks 를 찾고
     * - peaks 를 순회하면서 블록 divide 를 구하는 방법 (이게 핵심임)
     * - peaks 를 순회하기에 시간복잡도가 줄어듬.
     * - 1 100 90 91 90 102 97 103 96 104
     * - 100, 91, 102, 103
     *
     * - 한 블록에 2개이상의 peaks 가 나와도 상관없네. 앞에서부터 블록을 peaks 1개씩 채워나가야 함. 안그러면 답이 안됨.
     * - 블록 내에 Peaks 가 속하는지를 찾는 것이지. Peaks 간 크기는 상관없음
     * - n log (logn)
     *
     * @param A
     * @return
     */
    public int solution(int[] A) {
        List<Integer> peaks = getPeaks(A);
        int len = A.length;

        // A 에서 divide 가 최대로 나올 수 있는 수는 peaks 개수만큼이니 peaks 부터 구해줌.
        for (int divideCount = peaks.size() ; divideCount >= 1 ; divideCount--) {
            // Array 가 divideCount 로 나눈 나머지가 0이여야 divide 가 같은 element 가 됨.
            if (len % divideCount == 0) {
                // 한 block 에 들어가는 size
                int blockSize = A.length / divideCount;
                // block 에 들어간 peaks count
                int peaksCountContainBlock = 0;
                for (int peakIdx : peaks) {
                    /**
                     * 앞에서부터 count 를 할텐데. peakIdx 가 blockSize 에 나눠져서 peaksCountContainBlock 이랑 같다는건 해당 block 에 peaks 가 있다는 것.
                     * 이게 핵심임. peakIdx 는 앞에서부터 시작되고, 앞 block 부터 peaks 가 안채워지면 뒤에 가서 만족을 못함.
                     * 같은 block 내에 peaks 가 2개 이상이여도 아래 로직대로라면 문제 없음. 이미 블록에서 peaks 가 존재한다는 것을 체크했으면 다음으로 넘어갔을테니.
                     * 아래 로직이 best 이고, 0 <= peakIdx > block Idx 이런식으로 if 문을 조회해서 찾아도 됨.
                     * 0 <= peakIdx > blockIdx 를 만족하면 다음 블록 idx 로 넘어가는거지.
                     */
                    if (peakIdx / blockSize == peaksCountContainBlock) {
                        peaksCountContainBlock++;
                    }
                }
                if (peaksCountContainBlock == divideCount) {
                    return peaksCountContainBlock;
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
