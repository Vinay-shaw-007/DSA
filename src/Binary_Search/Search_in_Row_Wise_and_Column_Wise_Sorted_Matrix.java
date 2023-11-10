package Binary_Search;

/*
Problem Statement
Find the location of a specifc element (x) in an nxn matrix where each row and column are sorted in ascending order. If the element is present, return an array where frst element is row of element and second element is column of element. If not, return [-1,-1]. The solution should have a linear time complexity of O(n)." Note that elements will be unique.

Example 1:
Input:

X = 8

[[1, 4, 8],

[3, 7, 9],

[4, 8, 12]]

Output:

[0, 2]

Explanation:

In this example, we are given a 3x3 matrix with rows and columns sorted in ascending order. We are looking for the element 8. We start from the top-right corner (8) and compare it to 8. Since they match, we return [0, 2] because the element 8 is found at row 0 and column 2.

Constraints:
2 <= |N| <= 1000

1 <= X <= 109


 */
public class Search_in_Row_Wise_and_Column_Wise_Sorted_Matrix {
    public static void main(String[] args) {
        int X = 12;

        int[][] arr = {
                {1, 4, 8},
                {3, 7, 9},
                {4, 8, 12}
        };
        for (int i : findElement(arr, X))
            System.out.print(i+" ");


    }

    public static int[] findElement(int[][] mat, int x) {
        int[] ans = new int[2];
        ans[0] = -1;
        ans[1] = -1;

        int r = mat.length;
        int c = mat[0].length;

        int i = 0, j = c - 1;
        while (i >= 0 && j >= 0 && i < r && j < c) {
            if (mat[i][j] == x) {
                ans[0] = i;
                ans[1] = j;
                break;
            } else if (mat[i][j] < x) i++;
            else j--;
        }

        return ans;
    }
}
