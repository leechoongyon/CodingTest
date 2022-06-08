package codingtest.site.codility;

import java.util.Arrays;

public class CountSemiprimes {
    public static void main(String[] args) {
        int[] P = new int[] {1,4,16};
        int[] Q = new int[] {26, 10, 20};
        int N = 26;
        int[] results = new CountSemiprimes().solution(N, P, Q);
        for (int result : results) {
            System.out.print(result + " ");
        }
    }

    /**
     *
     * 문제
     *  P, Q 사이의 SemiPrimes 개수를 파악
     *  1 ≤= P[K] ≤ Q[K] ≤ N
     *
     * Solution 1
     *
     * - SemiPrimes 는 Prime numbers 2개로 이루어진 것.
     * - Prime number 는 소수. 2,3,4,7,11,13
     * - SemiPrimes 4,6,9,10,14,15,21,22,25,26…
     *     - 4 는 1,2,4 이며, 1,2,4 는 소수. 6 은 1,2,3,6 이고 소수
     *
     * - 앞에서부터 계산해나가면서 cache 를 사용.
     *     - For 문 앞에서 돌면서 cache[1], cache[2]… semi primes 를 구함. 구하는 도중에 cache 값이 존재하면 return
     * - cache[4] 는 1~4번 위치의 semiprimes 구함. cache[21] 는 1~21 번까지의 semi primes 개수
     * - 그렇기에 4(P)~10(Q) 위치의 semiprimes 는 cache[10] - cache[4] 를 빼면 됨.
     *
     * - 소수 구하기 - [https://st-lab.tistory.com/81](https://st-lab.tistory.com/81)
     * - Semi prime 구하는 방법 - 처음에 메모리에 전부 구해서 넣기.
     *
     *
     * solution1 안됨. 맨 뒤에 숫자부터 시작하면 맨 앞에 숫자들을 구하는게 의미가 없음.
     *
     *
     * 입력 값
     * P[i] <= Q[i]
     *
     * 시간복잡도
     *   n 제곱이지만 중간에 캐시가 들어가서 최적화가 됨
     *
     * 최적화
     *
     * 예외케이스
     *  P,q 가 같은 숫자
     *  P, q 사이 전부 semi prime 없음
     *  P, q 사이 semi prime 전부 있음
     *
     *
     *
     *
     * Solution 2
     *
     * - P 를 sorting 함.
     * - P 최소 값부터 N 까지 Semi Prime 을 구함. 구하면서 cache 저장
     *  - cache[P+1] 은 P~P+1 까지 Semi Prime 의 개수임.
     * - 그런 뒤, P, Q 순회하면서 cache 에 저장된 것들을 가지고 cache[Q] - cache[P] 구해줌.
     *
     * - semi prime 어떻게 구하지?
     *  - 소수를 미리 N 까지 구함. 그런 뒤, set 에 집어넣음.
     *  - set 을 순회하면서 존재하는지 파악
     *
     *
     * 시간복잡도
     * - sorting nlogn
     *
     * 기저사례
     *
     *
     * 위에 템플릿 반드시 유지
     *
     * @return
     */
    public int[] solution(int N, int[] P, int[] Q) {
        int[] cache = new int[P.length];
        int[] arrayP = new int[P.length];

        for (int i = 0 ; i < P.length ; i++) {
            arrayP[i] = P[i];
        }

        Arrays.sort(arrayP);

        int min = arrayP[0];

        // P, Q 를 순회
        for (int i = 0 ; i < P.length ; i++) {
            for (int j = P[i] ; j <= Q[i] ; j++) {

            }
        }
        return null;
    }

    /**
     * X 라는 양수가 있다고 가정
     * X = A * B 로 이루어짐.
     * 이 때, A 또는 B 중 1개는 루트 X 보다 크거나 작아야 함.
     * ex) X = 36 이라 한다면, 1*36, 2 * 18, 3 * 12, ... , 18 * 2, 36 * 1 이런식으로 진행이 됨.
     *     위와 같이 2개의 숫자중 1개는 반드시 루트 X 보다 크거나 작아야 함.
     *     그렇다면 루트 X 보다 크거나 작은 숫자는 소수여야 prime 겠지?
     *
     * 시간복잡도 O(루트n)
     * @param num
     * @return
     */
    private boolean isPrime(int num) {
        if (num < 2) {
            return true;
        }

        for (int i = 2 ; i <= Math.sqrt(num) ; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    private boolean isSemiPrime(int num) {
        boolean isExistSemiPrime = false;

        if (num < 2) {
            return false;
        }

        for (int i = 2 ; i <= Math.sqrt(num) ; i++) {
            if (num % i == 0) {
                if ( !isPrime(i) || !isPrime(num / i)) {
                    return false;
                } else if (isExistSemiPrime) {
                    return false;
                } else {
                    isExistSemiPrime = true;
                }
            }
        }
        return isExistSemiPrime;
    }
}
