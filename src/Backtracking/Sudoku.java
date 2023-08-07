package Backtracking;

import java.util.Scanner;

public class Sudoku {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        int[][] grid = new int[9][9];
//        for (int i = 0; i < 9; i++) {
//            for (int j = 0; j < 9; j++) {
//                grid[i][j] = sc.nextInt();
//            }
//        }
        int[][] grid = {
                {3, 0, 6, 5, 0, 8, 4, 0, 0},
                {5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1},
                {0, 0, 3, 0, 1, 0, 0, 8, 0},
                {9, 0, 0, 8, 6, 3, 0, 0, 5},
                {0, 5, 0, 0, 9, 0, 6, 0, 0},
                {1, 3, 0, 0, 0, 0, 2, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 4},
                {0, 0, 5, 2, 0, 6, 3, 0, 0}
        };
//        int[][] grid = {
//                {3, 6, 6, 5, 0, 8, 4, 0, 0},
//                {5, 2, 0, 0, 0, 0, 0, 0, 0},
//                {0, 8, 7, 0, 0, 0, 0, 3, 1},
//                {0, 0, 3, 0, 1, 0, 0, 8, 0},
//                {9, 0, 0, 8, 6, 3, 0, 0, 5},
//                {0, 5, 0, 0, 9, 0, 6, 0, 0},
//                {1, 3, 0, 0, 0, 0, 2, 5, 0},
//                {0, 0, 0, 0, 0, 0, 0, 7, 4},
//                {0, 0, 5, 2, 0, 6, 3, 0, 0}
//        };
        if (SolveSudoku(grid)) {
            printGrid(grid);
        } else System.out.println("Not possible");
    }
    //Function to print grids of the Sudoku.
    static void printGrid (int[][] grid) {
        // add your code here
        for (int[] ints : grid) {
            for (int j = 0; j < grid[0].length; j++) {
                System.out.print(ints[j] + " ");
            }
            System.out.println();
        }

    }

    //Function to find a solved Sudoku.
    static boolean SolveSudoku (int[][] grid) {
        // add your code here
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (grid[i][j] == 0) {
                    for (int k = 1; k <= 9; k++) {
                        if (isPossible(i, j, k, grid)) {
                            grid[i][j] = k;
                            if (SolveSudoku(grid)) return true;
                            grid[i][j] = 0;
                        }
                        if (k == 9) return false;
                    }
                }
            }
        }
        return true;
    }
    static boolean isPossible(int row, int column, int number, int[][] grid) {

        // Check for row
        for (int i = 0; i < 9; i++)
            if (grid[row][i] == number) return false;

        // Check for column
        for (int i = 0; i < 9; i++)
            if (grid[i][column] == number) return false;

        if (row < 3) row = 0;
        else if (row < 6) row = 3;
        else if (row < 9) row = 6;

        if (column < 3) column = 0;
        else if (column < 6) column = 3;
        else if (column < 9) column = 6;


        // Check for 3x3 grid
        for (int i = row; i < (row+3); i++) {
            for (int j = column; j < (column + 3); j++)
                if (grid[i][j] == number) return false;
        }
        return true;
    }
}
