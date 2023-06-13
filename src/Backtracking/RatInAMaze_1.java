package Backtracking;

import java.util.ArrayList;
import java.util.Scanner;

public class RatInAMaze_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];

        for(int i = 0; i < n; ++i) {
            for(int j = 0; j < n; ++j) {
                arr[i][j] = sc.nextInt();
            }
        }
        sc.close();
        System.out.println(findPath(arr, n));
    }

    private static ArrayList<String> findPath(int[][] arr, int n) {
        ArrayList<String> path = new ArrayList<>();
        int[][] visited = new int[n][n];
        if (arr[0][0] == 1) {
            findRatPath(arr, n, "", 0, 0, path, visited);
        }

        return path;
    }

    private static void findRatPath(int[][] arr, int n, String path, int i, int j, ArrayList<String> originalPath, int[][] visited) {
        System.out.println("i = " + i + ",j = " + j + ", path = " + path);
        if (i == n - 1 && j == n - 1) {
            System.out.println("Path = " + path);
            originalPath.add(path);
        } else {
            if (i + 1 < n && visited[i + 1][j] != 1 && arr[i + 1][j] == 1) {
                visited[i][j] = 1;
                findRatPath(arr, n, path + "D", i + 1, j, originalPath, visited);
                visited[i][j] = 0;
            }

            if (j - 1 >= 0 && visited[i][j - 1] != 1 && arr[i][j - 1] == 1) {
                visited[i][j] = 1;
                findRatPath(arr, n, path + "L", i, j - 1, originalPath, visited);
                visited[i][j] = 0;
            }

            if (j + 1 < n && visited[i][j + 1] != 1 && arr[i][j + 1] == 1) {
                visited[i][j] = 1;
                findRatPath(arr, n, path + "R", i, j + 1, originalPath, visited);
                visited[i][j] = 0;
            }

            if (i - 1 >= 0 && visited[i - 1][j] != 1 && arr[i - 1][j] == 1) {
                visited[i][j] = 1;
                findRatPath(arr, n, path + "U", i - 1, j, originalPath, visited);
                visited[i][j] = 0;
            }

        }
    }
}
