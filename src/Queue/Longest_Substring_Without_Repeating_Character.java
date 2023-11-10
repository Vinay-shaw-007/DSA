package Queue;

import java.util.LinkedList;
import java.util.Queue;

/*
Problem Statement
Given a string s, find the length of the longest substring without repeating characters.

Example 1:
Input:

s = "abcabcbb"

Output:

3

Explanation:

The Longest substring with non-repeating characters are abc, bca, cab with length 3.

Example 2:
Input

s = "aaa"

Output

1

Constraints:
0 <= |s| <= 5 * 104

s consists of English letters, digits, symbols and spaces.
 */
public class Longest_Substring_Without_Repeating_Character {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }
    public static int lengthOfLongestSubstring(String s) {
        int max = 0;

        Queue<Character> q = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            while (!q.isEmpty() && q.contains(ch))
                q.poll();
            q.offer(ch);

            max = Math.max(max, q.size());
        }

        return max;
    }
}
