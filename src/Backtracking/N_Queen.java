package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class N_Queen {
    public static void main(String[] args) {
//        nQueen(4);
        for (List<String> list : nQueen(4)) {
            for (String n : list) {
                System.out.print(n + " ");
            }
            System.out.println();
        }
    }

    static List<List<String>> nQueen(int n) {
        // code here
        List<List<String>> list = new ArrayList<>();
        int[][] board = new int[n][n];
        helper(list, board, n, n, 0, 0);
        return list;
    }

    private static List<String> convertItIntoListOfString(int[][] board) {
        List<String> list = new ArrayList<>();
        for (int[] ints : board) {
            StringBuilder ans = new StringBuilder();
            for (int anInt : ints) {
                if (anInt == 0) ans.append(".");
                else ans.append("Q");
            }
            list.add(ans.toString());
        }
        return list;
    }


    static void helper(List<List<String>> list, int[][] board, int n, int q, int row, int col) {
        if (q == 0) {
            print(board);
            list.add(convertItIntoListOfString(board));
            return;
        }
        if (row >= n || col >= n || row < 0 || col < 0) return;
        if (board[row][col] == 0) {
            if (isSafe(row, col, board, n)) {
                board[row][col] = 1;
                helper(list, board, n, q - 1, row + 1, 0);
                board[row][col] = 0;
            }
            helper(list, board, n, q, row, col + 1);
        }
    }

    public static boolean isSafe(int i, int j, int[][] board, int n) {
        // checking row
        for (int row = 0; row < n; row++) {
            if (board[i][row] == 1) return false;
        }

        // checking column
        for (int col = 0; col < n; col++) {
            if (board[col][j] == 1) return false;
        }

        // checking diagonal up left
        for (int row = i, col = j; row >= 0 && col >= 0; row--, col--) {
            if (row - 1 >= 0 && col - 1 >= 0 && board[row - 1][col - 1] == 1) return false;
        }

        // checking diagonal up right
        for (int row = i, col = j; row >= 0 && col < n; row--, col++) {
            if (row - 1 >= 0 && col + 1 < n && board[row - 1][col + 1] == 1) return false;
        }

        return true;
    }

    static void print(int[][] arr) {
        System.out.println();
        for (int[] i : arr) {
            System.out.println(Arrays.toString(i));
        }
    }
}
