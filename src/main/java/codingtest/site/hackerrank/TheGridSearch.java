package codingtest.site.hackerrank;

import java.util.Scanner;

/**
1
10 10
7283455864
6731158619
8988242643
3830589324
2229505813
5633845374
6473530293
7053106601
0834282956
4607924137
3 4
9505
3845
3530
 */

public class TheGridSearch {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0 ; i < t ; i++) {
            /** grid row */
            int R = in.nextInt();
            /** grid column */
            int C = in.nextInt();

            /** 입력배열 */
            String[] grid = new String[C];
            for (int k = 0 ; k < R ; k++) {
                grid[k] =in.next();
            }

            /** pattern row */
            int r = in.nextInt();
            /** pattern column */
            int c = in.nextInt();

            String[] pattern = new String[r];
            for (int k = 0 ; k < r ; k++) {
                pattern[k] = in.next();
            }
            System.out.println(solve(grid, pattern));
        }
    }



    /**
     *
     * 1. brute-force
     *
     *  - 입력 배열에서 일치하는 배열을 찾음.
     *  - 목표 배열의 크기 만큼 입력 배열에 존재하는지 찾기.
     *
     *  - 주의사항 :
     *      입력 배열에서 동일한 입력 배열이 있을 수 있음.
     *      그렇기에 입력배열의 1행에서 동일한 값이 몇 번 나오는지 확인이 필요.
     *      이렇게 안한다면 입력배열을 계속 확인해야하므로.
     *      예를 들면, 입력 배열의 첫행이 12345345 이고, 목표배열[0] 이 34 라면. 입력배열[0] 에는 34가 2번있는거임.
     *
     *  - 최악의 경우 시간복잡도 : O(gridHeightLen * gridWidthLen * patternHeightLen * gridWidthLen * patternWidthLen)
     *      - 최악의 경우 gridHeightLen 만큼 for 문 돌림.
     *      - 최악의 경우 gridWidthLen 만큼 countContainsPattern 가 발생.
     *      - 최악의 경우 patternHeightLen 만큼 for 문 돌림.
     *      - 최악의 경우 contains 에서 gridWidthLen * patternWidthLen 이 발생.
     *
     * @param grid
     * @param pattern
     * @return
     */
    public static String solve(String[] grid, String[] pattern) {

        /** 입력 배열의 가로 길이 */
        int gWidthLen = grid[0].length();

        /** 입력 배열의 세로 길이 */
        int gHeightLen = grid.length;

        /** 패턴의 세로 길이 */
        int pHeightLen = pattern.length;

        /** 입력배열을 한행씩 조회해서 목표배열[0] 이 있는지 확인 */
        for (int i = 0 ; i < gHeightLen ; i++) {
            /** 한 행에서 Pattern 을 몇 개 가지고 있는지 표현 */
            int countContainsPattern = 0;
            /**
             *  입력 배열에서 패턴을 찾는 것이다. 근데 한 번만 찾는게 아니라 계속해서 찾는 것.
             *  만약, 입력 배열 G[0] 에서 Pattern[0] 이 3개 라면, countContainsPatternForLine = 3 이다.
             **/
            int fromIdx = -1;
            while ( true ) {
                fromIdx = grid[i].indexOf(pattern[0], fromIdx + 1);
                if (fromIdx >= 0) {
                    countContainsPattern++;
                } else {
                    break;
                }
            }

            int startIdx = -1;
            /** 입력배열[i] 에서 패턴이 존재할 때, for 문을 돌린다. */
            for (int k = 0 ; k < countContainsPattern ; k++) {

                /** startIdx 가 하는 역할은 입력배열[i] 행에 pattern 이 시작하는 인덱스가 몇 번인지 파악. */
                startIdx = grid[i].indexOf(pattern[0], startIdx + 1);

                /** 패턴이 일치할 때까지 찾기. */
                for (int p = 0 ; p < pHeightLen ; p++) {
                    /**
                     *  grid 의 다음행이 pattern 의 다음행과 일치하는지 확인.
                     *  만약 위 조건이 맞다면, 위에서 구한 startIdx 와 grid 에서 찾은 pattern 의 인덱스가 같은지 비교.
                     *  같은 행에 패턴이 여러개 있을 수 있으니.
                     **/
                    if ( (grid[i + p].contains(pattern[p])) && (startIdx == grid[i + p].indexOf(pattern[p], startIdx)) ) {

                        /** 패턴의 모든 높이를 탐색했으니 YES */
                        if (p + 1 == pHeightLen) {
                            return "YES";
                        }
                        /** 패턴을 모두 탐색하기 전에 입력배열의 높이를 모두 탐색했으면 답이 없는거임. */
                        else if (i + p + 1 == gHeightLen) {
                            return "NO";
                        }
                    } else {
                        break;
                    }
                }
            }
        }
        return "NO";
    }
}
