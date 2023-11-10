package Queue;

import java.util.LinkedList;
import java.util.Queue;

public class FirstNonRepeatingCharacterInStream {
    public static void main(String[] args) {
        System.out.println(firstNonRepeatingCharacterInStream("abacbcbd"));
    }

    private static String firstNonRepeatingCharacterInStream(String s) {
        System.out.println(s);

        StringBuilder ans = new StringBuilder();

        Queue<Character> q = new LinkedList<>();

        int[] frequency = new int[26];

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            frequency[ch - 'a'] = frequency[ch - 'a'] + 1;

            while (!q.isEmpty() && frequency[q.peek() - 'a'] > 1) q.poll();

            if (frequency[ch - 'a'] == 1)
                q.offer(ch);

            if (q.isEmpty()) ans.append('#');

            else {
                ans.append(q.peek());
            }

        }

        for (int i = 0; i < frequency.length; i++) {
            char ch = (char) ('a'+ i);
            System.out.println(ch +" = " + frequency[i]);
        }

        return ans.toString();
    }
}
