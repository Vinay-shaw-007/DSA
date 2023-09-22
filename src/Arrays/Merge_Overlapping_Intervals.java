package Arrays;

import java.util.*;

import static Arrays.MultipleLeftRotationOfTheArray.printArray;

/*
Problem Statement
Given a collection of intervals, merge all overlapping intervals. Return the sorted list of intervals after merging all the overlapping intervals.

Example 1:
Input:

Intervals = {{1,3},{2,4},{6,8},{9,10}}

Output:

{{1, 4}, {6, 8}, {9, 10}}

Explanation:

Given intervals: [1,3],[2,4],[6,8],[9,10], we have only two overlapping intervals here,[1,3] and [2,4].
Therefore, we will merge these two and return [1,4],[6,8], [9,10].

Example 2:
Input:

Intervals = {{6,8},{1,9},{2,4},{4,7}}

Output:

{{1, 9}}
 */
public class Merge_Overlapping_Intervals {

    public static void main(String[] args) {
        int[][] a = {{1,3},{2,4},{6,8},{9,10}};

        for (int[] i: merge(a))
            printArray(i);
    }

    public static int[][] merge(int[][] intervals) {
        //You Can Code Here
        ArrayList<Pair> list = new ArrayList<>();


        Arrays.sort(intervals, Comparator.comparingInt((int[] a) -> a[0]).thenComparingInt(a -> a[1]));

        Pair pair = new Pair(intervals[0][0], intervals[0][1]);
        int prevStart = pair.start;
        int prevEnd = pair.end;
        list.add(new Pair(prevStart, prevEnd));

        for (int i = 1; i < intervals.length; i++) {
            int currStart = intervals[i][0];
            int currEnd = intervals[i][1];


            if (prevEnd >= currStart) {
                prevEnd = Math.max(prevEnd, currEnd);
                Pair p = list.get(list.size() - 1);
                p.end = prevEnd;
                list.set(list.size() - 1, p);
            } else {
                list.add(new Pair(currStart, currEnd));
                prevEnd = currEnd;
            }

        }


        int[][] ans = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            ans[i][0] = list.get(i).start;
            ans[i][1] = list.get(i).end;
        }
        return ans;
    }
}

class Pair {
    int start, end;

    Pair(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "start=" + start +
                ", end=" + end +
                "}\n";
    }
}
