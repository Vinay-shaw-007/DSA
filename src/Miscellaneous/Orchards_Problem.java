package Miscellaneous;

import java.util.LinkedList;
import java.util.Queue;

public class Orchards_Problem {
    public static void main(String[] args) {

        /**
         * <-----------------------------APPROACH----------------------------------------->
         * My approach is to first find trees in the matrix and discover all the adjacent trees.
         * I mark the visited trees in the visitor array as 1 to avoid revisiting them.
         * </-----------------------------APPROACH----------------------------------------->
         */

        char[][] arr = {
                { 'O', 'T', 'O', 'O' },
                { 'O', 'T', 'O', 'T' },
                { 'T', 'T', 'O', 'T' },
                { 'O', 'T', 'O', 'T' }
        };
        findSizeOfOrchard(arr);
    }

    private static void findSizeOfOrchard(char[][] arr) {
        /**
         * Getting the number of rows and columns of the matrix.
         */
        int row = arr.length, column = arr[0].length;

        /**
         * The visitor array is used to mark elements as visited.
         * If an element is already marked visited, we don't need to process it again.
         */
        int[][] visitor = new int[row][column];

        /**
         * The queue is used to store elements where operations need to be performed.
         */
        Queue<Pair> q = new LinkedList<>();

        /**
         * The count variable is used to store the size of orchards.
         */
        int count = 0;
        System.out.print("Output: ");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (arr[i][j] == 'T' && visitor[i][j] == 0) {
                    q.add(new Pair(i, j));
                    visitor[i][j] = 1;
                    recursionOrchard(arr, q, visitor, count);
                }
            }
        }


    }

    private static void recursionOrchard(char[][] arr, Queue<Pair> q, int[][] visitor, int count) {
        // If the queue is empty, we have traversed all adjacent trees and can print the size of the orchard.
        if (q.isEmpty()) {
            System.out.print(count + " ");
            return;
        }
        while (!q.isEmpty()) {
            // Increase the counter as we traverse through the trees.
            count++;

            Pair indexes = q.poll();
            int row = indexes.row, column = indexes.column;

            // Moving to the top
            if (row - 1 >= 0 && arr[row - 1][column] == 'T' && visitor[row - 1][column] != 1) {
                q.add(new Pair(row - 1, column));
                visitor[row - 1][column] = 1;
            }
            // Moving to Bottom
            else if (row + 1 < arr.length && arr[row + 1][column] == 'T' && visitor[row + 1][column] != 1) {
                q.add(new Pair(row + 1, column));
                visitor[row + 1][column] = 1;
            }
            // Moving to the left
            else if (column - 1 >= 0 && arr[row][column - 1] == 'T' && visitor[row][column - 1] != 1) {
                q.add(new Pair(row, column - 1));
                visitor[row][column - 1] = 1;
            }
            // Moving to right
            else if (column + 1 < arr.length && arr[row][column + 1] == 'T' && visitor[row][column + 1] != 1) {
                q.add(new Pair(row, column + 1));
                visitor[row][column + 1] = 1;
            }
            // Moving to top-left
            else if (row - 1 >= 0 && column - 1 >= 0 && arr[row - 1][column - 1] == 'T'
                    && visitor[row - 1][column - 1] != 1) {
                q.add(new Pair(row - 1, column - 1));
                visitor[row - 1][column - 1] = 1;
            }
            // Moving to bottom-right
            else if (row + 1 < arr.length && column + 1 < arr.length && arr[row + 1][column + 1] == 'T'
                    && visitor[row + 1][column + 1] != 1) {
                q.add(new Pair(row + 1, column + 1));
                visitor[row + 1][column + 1] = 1;
            }
            // Moving to top-right
            else if (row - 1 >= 0 && column + 1 < arr.length && arr[row - 1][column + 1] == 'T'
                    && visitor[row - 1][column + 1] != 1) {
                q.add(new Pair(row - 1, column + 1));
                visitor[row - 1][column + 1] = 1;
            }
            // Moving to bottom-left
            else if (row + 1 < arr.length && column - 1 >= 0 && arr[row + 1][column - 1] == 'T'
                    && visitor[row + 1][column - 1] != 1) {
                q.add(new Pair(row + 1, column - 1));
                visitor[row + 1][column - 1] = 1;
            }

            recursionOrchard(arr, q, visitor, count);
        }
    }
}

/**
 * Created a pair class to store the indexes where the Tree is present, so that
 * we can travel to its adjacent sides,
 * i.e., top, bottom, left, right, top-left, top-right, bottom-left,
 * bottom-right.
 */

class Pair {
    int row, column;

    Pair(int row, int column) {
        this.row = row;
        this.column = column;
    }
}
