package Stack;

import java.util.ArrayDeque;

public class Remove_K_Digits {
    public static void main(String[] args) {
        String S = "03335900507657115995027415060785449588629028243069564304317233669789";
        int K = 1;
        System.out.println(removeKDigits(S, K));
    }
    private static String removeKDigits(String num, int k) {

        ArrayDeque<Integer> st = new ArrayDeque<>();

        for (int i = 0; i < num.length(); i++) { // 14301620 3002983

            int currNum = num.charAt(i) - '0';

//            System.out.print(currNum+" ");

            // Removing the previous greater elements in the stack
            while (!st.isEmpty() && st.peek() > currNum && k > 0) {
                st.pop();
                k--;
            }

            if (st.isEmpty() && currNum == 0)
                continue;

            st.push(currNum);
//            System.out.println("Stack element = "+st);

        }

        while (!st.isEmpty() && k > 0) {
            st.pop();
            k--;
        }

//        System.out.println("print = "+st+", k = "+k);

        if (st.isEmpty()) return "0";

        StringBuilder ans = new StringBuilder();

        while (!st.isEmpty())
            ans.append(st.pollLast());

        return ans.toString();
    }
}
