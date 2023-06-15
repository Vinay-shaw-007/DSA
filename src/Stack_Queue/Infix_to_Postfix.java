package Stack_Queue;

import java.util.Stack;

public class Infix_to_Postfix {
    public static void main(String[] args) {
        String exp = "h^m^q^(7-4)";
        System.out.println(infixToPostfix(exp));
    }

    public static String infixToPostfix(String exp) {
        // Your code here
        Stack<Character> st = new Stack<>();
        StringBuilder newExp = new StringBuilder();
        int i = 0;
        while (i < exp.length()) {
            char ch = exp.charAt(i), peek, pop;
            switch (ch) {
                case '(' : st.push(ch);
                case '^' : {
                    if(!st.isEmpty()){
                        peek = st.peek();
                        if(peek == '^') {
                            pop = st.pop();
                            newExp.append(pop);
                            continue;
                        } else st.push(ch);
                    } else st.push(ch);
                }
                case '+' : {
                    if (st.isEmpty()) {
                        st.push(ch);
                    } else {
                        peek = st.peek();
                        if (peek == '/' || peek == '*' || peek == '^' || peek == '+'|| peek == '-') {
                            pop = st.pop();
                            newExp.append(pop);
                            continue;
                        } else st.push(ch);
                    }
                }
                case '-' : {
                    if (!st.isEmpty()) {
                        peek = st.peek();
                        if (peek == '/' || peek == '*' || peek == '^' || peek == '+' || peek == '-') {
                            pop = st.pop();
                            newExp.append(pop);
                            continue;
                        } else st.push(ch);
                    } else st.push(ch);
                }
                case '*' : {
                    if (st.isEmpty()) {
                        st.push(ch);
                    } else {
                        peek = st.peek();
                        if (peek == '^' || peek == '*' || peek == '/') {
                            pop = st.pop();
                            newExp.append(pop);
                            continue;
                        } else st.push(ch);
                    }
                }
                case '/' : {
                    if (st.isEmpty()) {
                        st.push(ch);
                    } else {
                        peek = st.peek();
                        if (peek == '^' || peek == '*' || peek == '/') {
                            pop = st.pop();
                            newExp.append(pop);
                            continue;
                        } else st.push(ch);
                    }
                }
                case ')' : {
                    if (st.isEmpty()) {
                        st.push(ch);
                    } else {
                        peek = st.peek();
                        if (peek != '(') {
                            pop = st.pop();
                            newExp.append(pop);
                            continue;
                        } else {
                            st.pop();
                        }
                    }
                }
                default : newExp.append(ch);
            }
            i++;
        }
        while (!st.isEmpty()) {
            char pop = st.pop();
            newExp.append(pop);
        }
        return newExp.toString();
    }

}
