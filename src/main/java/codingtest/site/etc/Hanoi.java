package codingtest.site.etc;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Hanoi {
    public static void main(String[] args) {
        int count = hanoi(3, 1, 2, 3, 0);
        log.info("{}", count);
        count = hanoi(4, 1, 2, 3, 0);
        log.info("{}", count);
    }

    /**
     * 하노이탑 원리를 이해해야 함.
     * 1. n-1 를 두번째 기둥으로 옮기고.
     * 2. 첫번째 기둥에서 마지막 원판을 세번째 기둥으로 옮긴다.
     * 3. 두번째 기둥에 있는 n-1 원판을 세번째 기둥으로 옮긴다.
     *
     * 위 내용을 보면 n 번쨰 기둥을 옮기는건 n-1 번째 기둥을 옮기는 것을 풀어야 풀 수 있는 문제이다.
     * 즉, 재귀 문제이다.
     *
     * 제일 작은 문제부터 시작해보자.
     * n = 1 일 때는 1번 움직이기.
     * n = 2 일 때는 1 --> 2, 1 --> 3, 2 --> 3 (3번)
     * n = 3 일 때는 n-1 을 2번째 기둥으로 옮기는데 3번이 소요, 1 --> 3, n - 1 을 3번째 기둥으로 옮김.  (총 7번)
     * n = 4 일 때는 n-1 을 2번째 기둥으로 옴기는데 7번, 1 --> 3, n - 1 을 3번째 기둥으로 옮기는데 7번. (총 15번)
     *
     *
     * @param n     원판갯수
     * @param from  시작
     * @param mid   경유지
     * @param to    목적지
     */
    public static int hanoi(int n, int from, int mid, int to, int count) {
        if (n == 1) {
            log.info("from : {} --> to : {}", from, to);
            count++;
            return count;
        }

        /** 위에 1번을 뜻함. */
        count = hanoi(n - 1, from, to, mid, count );

        /** 위에 2번을 뜻함. */
        log.info("from : {} --> to : {}", from, to);
        count++;
        /** 위에 3번을 뜻함. */
        count = hanoi(n-1, mid, from, to, count);

        return count;
    }
}
