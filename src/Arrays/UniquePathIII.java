package Arrays;

public class UniquePathIII {
    public static void main(String[] args) {
        int[][] mat = {
                {1, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 2, -1}
        };

        System.out.println("Answer = " + uniquePathsIII(mat));
    }

    public static int uniquePathsIII(int[][] grid) {

        int r = grid.length;
        int c = grid[0].length;
        int noOfZero = 0;

        boolean[][] visited = new boolean[r][c];

        int[] s = new int[1];

        for (int[] i : grid)
            for (int j : i)
                if (j == 0) noOfZero++;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == 1) {
                    helper(i, j, noOfZero, visited, grid, r, c, s, "");
                    break;
                }
            }
        }
//        System.out.println("Testing Answer = " + s[0]);
        return s[0];
    }

    private static void helper(int i, int j, int noOfZero, boolean[][] visited, int[][] grid, int r, int c, int[] ans, String ss) {
//        System.out.println("No of Zeros = " + noOfZero + " Path = " + ss + " i = " + i + " j = " + j);
        if (noOfZero == 0) {
                // Down
            if (i >= 0 && i + 1 < r && j >= 0 && j < c && grid[i + 1][j] == 2)
                ans[0] += 1;
                // Right
            else if (i >= 0 && i < r && j >= 0 && j + 1 < c && grid[i][j + 1] == 2)
                ans[0] += 1;
                // Left
            else if (i >= 0 && i < r && j - 1 >= 0 && j < c && grid[i][j - 1] == 2)
                ans[0] += 1;
                // Up
            else if (i - 1 >= 0 && i < r && j >= 0 && j < c && grid[i - 1][j] == 2)
                ans[0] += 1;
            return;
        }

        // Right
        if (isValid(i, j + 1, r, c, visited, grid)) {
            visited[i][j + 1] = true;
            helper(i, j + 1, noOfZero - 1, visited, grid, r, c, ans, ss + "R");
            visited[i][j + 1] = false;
        }

        // Down
        if (isValid(i + 1, j, r, c, visited, grid)) {
            visited[i + 1][j] = true;
            helper(i + 1, j, noOfZero - 1, visited, grid, r, c, ans, ss + "D");
            visited[i + 1][j] = false;
        }

        // left
        if (isValid(i, j - 1, r, c, visited, grid)) {
            visited[i][j - 1] = true;
            helper(i, j - 1, noOfZero - 1, visited, grid, r, c, ans, ss + "L");
            visited[i][j - 1] = false;
        }

        // UP
        if (isValid(i - 1, j, r, c, visited, grid)) {
            visited[i - 1][j] = true;
            helper(i - 1, j, noOfZero - 1, visited, grid, r, c, ans, ss + "U");
            visited[i - 1][j] = false;
        }
    }

    private static boolean isValid(int i, int j, int r, int c, boolean[][] visited, int[][] grid) {
        return i >= 0 && i < r && j >= 0 && j < c && grid[i][j] == 0 && !visited[i][j];
    }
}
