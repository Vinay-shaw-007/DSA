package Stack;

import java.util.Stack;

public class Reverse_a_Stack_using_Recursion {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        new Reverse_a_Stack_using_Recursion().reverseStack(stack);
        System.out.println(stack);
    }
    public void reverseStack(Stack<Integer> s) {
        //You can code here
        if (s.isEmpty()) return;

        int element = s.pop();

        System.out.println("Popped = "+element);

        reverseStack(s);

        reverse(s, element);

        System.out.println("Stack element = "+s);
    }
    private void reverse(Stack<Integer> s, int element) {
        if (s.isEmpty()) {
            s.push(element);
            return;
        }

        int pop = s.pop();

        reverse(s, element);

        s.push(pop);

    }
}
