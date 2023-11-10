package Advanced_Sorting_Algorithm_and_Greedy_Problem;

import java.util.Arrays;

import static Arrays.MultipleLeftRotationOfTheArray.printArray;

/*
Problem Statement
There are N children standing in a line. Each child is assigned a rating value given in the integer array ratings.
You are giving candies to these children subjected to the following requirements:

Each child must have atleast one candy.
Children with a higher rating get more candies than neighbors.
Return the minimum number of candies you need to have to distribute the candies to the children.

Example 1:
Input:

N = 3
ratings [ ] = {1, 0, 2}

Output: 5

Explanation:

You can allocate to the first, second and third child with 2, 1, 2 candies respectively.

Example 2:
Input:

N = 3
ratings [ ] = {1, 2, 2}

Output: 4

Explanation:

You can allocate to the first, second and third child with 1, 2, 1 candies respectively.
The third child gets 1 candy because it statisfies the above two conditions.

Constraints:
1 ≤ N ≤  5*104
0 ≤ ratingsi ≤ 105
 */
public class Distribute_Candy {
    public static void main(String[] args) {
        int N = 3;
        int ratings[] = {1, 0, 2};
        System.out.println(minCandy(ratings, N));
    }

    public static int minCandy(int ratings[], int n) {
        int totalCandy = 0;

        int[] candyArray = new int[n];

        Arrays.fill(candyArray, 1);

        for (int i = 1; i < n; i++) {
            if (ratings[i - 1] < ratings[i]) candyArray[i] = candyArray[i - 1] + 1;
        }

        for (int i = n - 2; i >= 0 ; i--) {
            if (ratings[i] > ratings[i + 1] && candyArray[i] <= candyArray[i + 1]) candyArray[i] = candyArray[i + 1] + 1;
        }

        for (int i : candyArray) totalCandy += i;

        return totalCandy;
    }
}
