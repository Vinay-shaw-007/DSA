package Stack_Queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class Delete_middle_element_from_stack {
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        st.push(5);
//        st.push(6);
//        st.push(7);
//        st.push(8);
        deleteMiddle(st, 4);
    }
    public static void deleteMiddle(Stack<Integer> inputStack, int N) {
        // WRITE YOUR CODE HERE
        Deque<Integer> q = new ArrayDeque<>();
        System.out.println("Original = "+inputStack);
        while (!inputStack.isEmpty()){
            int val = inputStack.pop();
            q.addFirst(val);
//            System.out.println("Stack = "+inputStack);
//            System.out.println("Queue = "+q);
        }
        int size = 0, i = 1;

        if(q.size()/2 == 0) size = N+1;
        else size = N+2;

        while(i < size) {
            System.out.println("i = "+i+" & "+" size = "+size);
            if (size/2 == i) q.poll();
            else {
                int val = q.poll();
                q.add(val);
            }
            System.out.println("Queue = "+q);

            i++;
        }
        while (!q.isEmpty()) {
            int val = q.pollFirst();
            inputStack.push(val);
        }
        System.out.println("inputStack = "+inputStack);

    }
}
