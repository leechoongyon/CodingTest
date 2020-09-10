package codingtest.site.hackerrank;

import java.util.Scanner;

public class NonDivisibleSubset {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[k];

        for (int i = 0; i < n; i++) {
            arr[sc.nextInt() % k]++;
        }
        System.out.println(solve(arr, k));
    }

    /**
     * 문제 : 문제 요약하면 array 가 주어지는데, 그 array 중 부분집합을 선택하는데. 이 부분집합의 2개 원소의 합은 k에 의해 나뉘어지면 안된다.
     *
     * 1. brute-force
     * - 부분집합 모두 구한 뒤에, k 로 나누는 과정은 너무 시간 복잡도가 높게 나옴.
     * - O(2 의 n 제곱)
     *
     * 2. 나머지 이용
     *  - array 를 k 로 나눈 나머지들의 갯수를 구함.
     *  - 무슨말인가 하면 1,2,3,4,5 array 있고. k 가 3이라면,
     *      arr[1%3], arr[2%3], arr[3%3], arr[4%3], arr[5%3] 이렇게 나머지를 구해서 갯수를 구함.
     *      arr[0] = 1, arr[1] = 2, arr[2] = 2 가 나옴. (나머지 0 은 1개, 나머지 1은 2개, 나머지 2은 2개 라는 뜻임)
     *  - 이런 생각을 해볼 수 있음.
     *      나머지가 1 + (k-1) = k 일테니 같이 고르면 안됨. 나머지가 k 라는건 k 로 나뉜다는 것이니까.
     *      이 원리를 이용해서 나머지가 1인 것을 고르거나. 나머지가 k-1 인 것을 고르거나 둘 중 1개를 골라야함.
     *      예를 들면, k = 5 라면 1 을 골랐으면 무조건 4가 와야 되고, 2를 골랐으면 3을 골라야하기 때문.
     *
     *  - 그렇기에 위에 원리를 기본으로 해서 다음과 같은 3가지를 구해야 함.
     *
     *      1. 1+ (k-1) , 2 + (k-2) 중 더 많은 갯수를 고른다.
     *      2. 나머지가 0은 어떠한 수가 와도 된다. 하지만 나머지가 0인 것이 2개 이상이라면 1번밖에 count 할 수 밖에 없다.
     *         왜냐면 0 + 0 은 0 이기에 k 로 나뉘기 때문이다.
     *      3. 2번과 마찬가지로 k 가 짝수일 때도, 최소 1번은 올 수 있다. k = 4 라고 해보자. 나머지가 2인 것이 갯수가 3이라고 하면, 그 중
     *         단 1개만 고를 수 있는거지. 2+2 = 4 이니까 k 로 나뉘니까.
     *
     * @param arr
     * @param k
     * @return
     */
    public static int solve(int[] arr, int k) {
        int result = 0;

        /** 위에서 3번을 구하는 것. */
        if (k % 2 == 0) {
            result = result + Math.min(arr[k/2], 1);
        }

        /** 위에서 2번을 구하는 것. */
        result = result + Math.min(arr[0], 1);

        /** 위에서 1번을 구하는 것.
         *  여기서 주의할게 j != k - j 은 서로 같은 수이면 이미 위에서 구했기 때문. (짝수)
         *  홀수일 경우 j <= k / 2 까지 접근해야 2개를 뽑을 수 있음.
         *  또한, j <= k 인 이유는 1,2,3,4,... k-4, k-3, k-2, k-1 에서 2개씩 뽑기 때문.  */
        for (int j = 1; j <= k / 2; j++) {
            if (j != k - j) {
                result += Math.max(arr[j], arr[k - j]);
            }
        }
        return result;
    }
}
