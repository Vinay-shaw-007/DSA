package Queue;

import java.util.*;

/*
Problem Statement
Given a number N. The task is to generate all the binary numbers with from 1 to N.

Example 1:
Input:
N = 2
Output:
[1, 10]
Explanation:
Binary numbers from 1 to 2 are:

1 -> 1

2 -> 10

Example 2:
Input:
N = 5
Output:
[1, 10, 11, 100, 101]
Explanation:
Binary numbers from 1 to 5 are

1 -> 1,

2 -> 10

3 -> 11

4 -> 100 and

5 -> 101.
 */
public class Generate_Binary_Numbers {
    public static void main(String[] args) {
        System.out.println(generate(5));
    }
    public static ArrayList<String> generate(int N) {
        ArrayList<String> ans = new ArrayList<>();

        Queue<String> q = new LinkedList<>();

        q.offer("1");

        for (int i = 1; i <= N; i++) {
            StringBuilder s = new StringBuilder(q.remove());
            ans.add(s.toString());
            s.append("0");
            q.offer(s.toString());
            s.deleteCharAt(s.length() - 1);
            s.append("1");
            q.offer(s.toString());
        }
        return ans;
    }
}
