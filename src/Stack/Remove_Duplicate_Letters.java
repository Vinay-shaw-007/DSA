package Stack;

import java.util.ArrayDeque;

public class Remove_Duplicate_Letters {
    public static void main(String[] args) {
        System.out.println(removeDuplicateLetters("abacb"));//serwouyvghskpoixmnbcvzsdagfsjhskslhfgftwqtqiowpuetrr
    }

    public static String removeDuplicateLetters(String s) {
        //You can code here
        int n = s.length();

        StringBuilder ans = new StringBuilder();

        ArrayDeque<Character> st = new ArrayDeque<>();

        int[] lastTaken = new int[26];

        boolean[] visited = new boolean[26];

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            lastTaken[ch - 'a'] = i;
        }

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            if (visited[ch - 'a']) continue;

            while (!st.isEmpty() && st.peek() > ch && lastTaken[st.peek() - 'a'] > i) {
                visited[st.peek() - 'a'] = false;
                st.pop();
            }
            visited[ch - 'a'] = true;
            st.push(ch);

        }

//        System.out.println(st);

        while (!st.isEmpty()) {
            ans.append(st.pollLast());
        }

//        for (int i : lastTaken) {
//            System.out.print(i + " ");
//        }
//
//        System.out.println();
//
//        for (boolean i : visited) {
//            System.out.print(i + " ");
//        }

        return ans.toString();
    }
}
