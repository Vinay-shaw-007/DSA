package Stack;

import java.util.ArrayDeque;

/*
Problem Statement
Given a string s of length n containing the characters '(' and ')', return the length of the longest valid parentheses substring.

Example 1:
Input:

S = “()()(()”

Output:

4

Explanation : ()() is longest valid parentheses

Example 2:
Input:

S = “()))((”

Output:

2

Explanation : () is longest valid parentheses
 */
public class Longest_Valid_Parenthesis {
    public static void main(String[] args) {
        System.out.println(longestValidParentheses("()"));
    }

    public static int longestValidParentheses(String s) {
        //You can code here

//        if (s.isEmpty()) return 0;

        ArrayDeque<Integer> st = new ArrayDeque<>();

        st.push(-1);

        int max = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                st.push(i);
            } else {
                st.pop();
                if (st.isEmpty()) st.push(i);
                else max = Math.max(max, i - st.peek());
            }
        }


        return max;
    }

}
