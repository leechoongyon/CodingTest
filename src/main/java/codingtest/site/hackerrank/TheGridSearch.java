package codingtest.site.hackerrank;

import java.math.BigInteger;
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
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0 ; i < t ; i++) {
            /** grid row */
            int R = in.nextInt();
            /** grid column */
            int C = in.nextInt();

            StringBuilder grid = new StringBuilder();
            for (int k = 0 ; k < R ; k++) {
                grid.append(in.next());
            }

            /** pattern row */
            int r = in.nextInt();
            /** pattern column */
            int c = in.nextInt();

            String[] pattern = new String[r];
            for (int k = 0 ; k < r ; k++) {
                pattern[k] = in.next();
            }
            System.out.println(solve(grid.toString(), pattern, R, C, r, c));
        }
    }

    /**
     * https://www.hackerrank.com/challenges/the-grid-search/problem
     *
     * 문제 : Grid 와 pattern 이 주어졌을 때, Grid 안에 Pattern 이 존재하는지 확인.
     *       존재하면 'YES', 없으면 'NO' 리
     *
     * 제약사항 : row, column 은 1000 이 한계임.
     *
     * 풀이 :
     *
     * 1. brute-force
     *    - 맨 위에서부터 for 문 돌리면서 pattern 이 첫 줄이 존재하는지 확인.
     *    - pattern 의 첫줄과 일치하면 나머지도 각각 비교.
     *    - 이 때, 일치하는 것을 찾았을 때 index 를 저장해놔야겠지.
     *
     *    - grid 를 for 문 돌리면서 pattern 의 첫번째 index 와 일치하는게 있는지 확인 (startWith 사용)
     *    - 일치하는게 있다면 계속해서 pattern 과 grid 를 증가시키면서 확인.
     *
     *    - 시간복잡도 O(n 세제곱)
     *
     * 2. 데이터를 가공해서 처리.
     *
     *    - 아래와 같은 예제가 있다고 가정.
     *    - 아래 input 을 일렬로 쭉 세운다. pattern 도 마찬가지로 일렬로 쭉 세운다.
     *    - BigInteger 로 and 연산해서 같은 값이 나오면 input 에 pattern 이 존재하는 것이다.
     *    - 데이터 가공하는데 O(n세제곱)
     *    - and 연산하는데 O(n) 이니 최종 시간복잡도는 O(n세제곱)
     *
     *      input
     *      1234567890
     *      0987654321
     *      1111111111
     *      1111111111
     *      2222222222
     *
     *      가공 input
     *      123456098765111111
     *      234567987654111111
     *      ...
     *      ...
     *      ...
     *
     *      pattern
     *      876543
     *      111111
     *      111111
     *
     *      pattern 가공
     *      876543111111111111
     *
     *
     *  3. 일랼로 쭉 세운 뒤, and 연산
     *      - 일렬로 쭉 세우는게 3n
     *      - 12345678900987654321111111111111111111112222222222
     *
     *      - 123456098765111111 이게 한줄인데 이걸 만드는 로직을 고민.
     *      - BigOperationTest
     *      - 아래 처럼 for 문 2번 돌리니 O(n 제곱)
     *
     *  4. 3번의 아이디어에서 만들기 전에 비교.
     *      - 그럼 다 만듪필요 없음.
     *      - timeout 2개 걸림.
     *      - 시간복잡도가 O(n제곱) 인데 왜 timeout 이 나는거지.
     *
     * @return
     */
    private static String solve(String grid, String[] pattern,
                                int gridRow, int gridCol,
                                int patternRow, int patternCol) {

        for (int i = 0 ; i <= (gridRow - patternRow) * gridCol + (gridCol - patternCol)  ; i++) {
            int idx = i;
            StringBuilder subGrid = new StringBuilder();
            for (int k = 0 ; k < patternRow ; k++) {
                String tmp = grid.substring(idx, idx + patternCol);

//                System.out.println("start : " + idx + "   end : " + (idx + patternCol) );

                if ( !pattern[k].equals(tmp)) {
                    break;
                }
                subGrid.append(tmp);
                idx += patternCol;
                idx += gridCol - patternCol;
            }

            if (subGrid.toString().equals(toString(pattern))) {
                return "YES";
            }
        }
        return "NO";
    }

    private static String toString(String[] pattern) {
        StringBuilder sb = new StringBuilder();
        for (String s : pattern) {
            sb.append(s);
        }
        return sb.toString();
    }
}
