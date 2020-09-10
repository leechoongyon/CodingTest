package codingtest.site.acmicpc;

import java.util.Scanner;

/**
 * @author lee
 * @desc 1. 두 원이 너무 멀 때 -  r > r1 + r2
 * 2. 두 원이 한점에서 만남. (외접) - r = r1 + r2
 * 3. 두 교점 - 나머지 조건
 * 4. 두 원이 한점에서 만남. (내접) - r = |r1-r2|
 * 5. 하나의 원이 다른 하나의 원 안에 있고 중점이 같지만 두원이 만나지 않을 때 - x1 = x2 & y1 = y2 & r1 != r2
 * 6. 두 원이 일치 ( x1 = x2 & y1 = y2 & r1 = r2 )
 * 7. 하나의 원이 다른 하나의 원 안에 있고 중점이 다른데 만나지 않을 때 - r < |r2-r1|
 */
public class Num1002 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int res[] = new int[T];
        for (int i = 0; i < T; i++) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int r1 = sc.nextInt();

            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            int r2 = sc.nextInt();
            res[i] = solve(x1, y1, r1, x2, y2, r2);
        }
        for (int i = 0; i < T; i++)
            System.out.println(res[i]);

        sc.close();
    }

    public static int solve(int x1, int y1, int r1, int x2, int y2, int r2) {
        double r = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));

        // 6번
        if (x1 == x2 && y1 == y2 && r1 == r2)
            return -1;
            // 1번 5번 7번
        else if (r > r1 + r2 || x1 == x2 && y1 == y2 && r1 != r2 || r < Math.abs(r1 - r2))
            return 0;
            // 2번 4번
        else if (r == r1 + r2 || Math.abs(r1 - r2) == r)
            return 1;
        // 3번
        return 2;
    }
}
