package Stack;

import java.util.ArrayDeque;

public class Redundant_Braces {
    public static void main(String[] args) {
        System.out.println(hasRedundantBraces("(a+b)"));
    }
    public static boolean hasRedundantBraces(String s) {
        // You can code here
        ArrayDeque<Character> st = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(' || ch == '+' || ch == '-' || ch == '*' || ch == '/') st.push(ch);
            else if (ch == ')'){
                if (st.isEmpty() || st.peek() == '(') return true;
                while (!st.isEmpty() && st.peek() != '(') st.pop();
                st.pop();
            }
        }

        return false;
    }
}
