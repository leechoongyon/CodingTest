package codingtest.site.leetcode;

public class NumberOfIslands {

    private boolean[][] visited;

    public static void main(String[] args) {

        // case 1
//        char[][] grid = {
//                {'1', '1', '1', '1', '0'},
//                {'1', '1', '0', '1', '0'},
//                {'1', '1', '0', '0', '0'},
//                {'0', '0', '0', '0', '0'}
//        };

        // case 2
//        char[][] grid = {
//                {'1', '1', '0', '0', '0'},
//                {'1', '1', '0', '0', '0'},
//                {'0', '0', '1', '0', '0'},
//                {'0', '0', '0', '1', '1'}
//        };

        // case 3
//        char[][] grid = {
//                {'1', '1', '1'},
//                {'0', '1', '0'},
//                {'1', '1', '1'},
//        };

        // case 4
        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };

        int count = new NumberOfIslands().numIslands(grid);
        System.out.println(count);
    }

    /**
     * 섬의 개수를 구하라. 연결된 섬은 1개로 count
     *
     * 해결방안
     * 1. brute-force
     *      - for 2번 돌려서 연결된 것을 찾아야 함.
     *      - dfs 를 사용해서 이어지는 부분을 계속해서 탐색.
     *
     * 시간복잡도 O(n제곱) - 최악의 경우 한 번씩 다 순회는 해야 함.
     * 공간복잡도 O(n제곱)
     *
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        visited = new boolean[m][n];
        int count = 0;
        for (int i = 0 ; i < m ; i++) {
            for (int j = 0 ; j < n ; j++) {
                if (visited[i][j] == false) {
                    count += numIslands(grid, i, j);
                }
            }
        }
        return count;
    }

    public int numIslands(char[][] grid, int x, int y) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        if (m > x && x >= 0 && n > y && y >= 0 &&
                grid[x][y] == '1' && visited[x][y] == false) {
            count++;
            visited[x][y] = true;
            count += numIslands(grid, x, y + 1);
            count += numIslands(grid, x + 1, y);
            count += numIslands(grid, x - 1, y);
            count += numIslands(grid, x, y - 1);
        }
        return count > 0 ? 1 : 0;
    }

}
