package Queue;

import java.util.*;

/*
Problem Statement
Given an integer k and a queue of integers, The task is to reverse the order of the first k elements of the queue,
leaving the other elements in the same relative order.

Only the following standard operations are allowed on the queue:

enqueue(x): Add an item x to the rear of queue

dequeue(): Remove an item from the front of the queue

size(): Returns the number of elements in the queue.

front(): Finds front item.

Example 1:
Input:

k = 3 queue = [10, 20, 30, 40, 50]

Output:

[30, 20, 10, 40, 50]

Explanation:

Reverse the first 3 elements of the queue and leave the remaining elements in the same order as before.

Example 2:
Input:

k = 2, queue = [60, 75, 80]

Output:

[75, 60, 80]
 */
public class Reversing_Element_of_Queue {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(10);
        q.offer(20);
        q.offer(30);
        q.offer(40);
        q.offer(50);
        System.out.println(reverseQueueFirstKElements(3, q));
    }
    public static Queue<Integer> reverseQueueFirstKElements(int k, Queue<Integer> queue) {
        if (k == 1 && k > queue.size()) return queue;

        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < k; i++)
            st.push(queue.poll());

        while (!st.isEmpty())
            queue.offer(st.pop());

        for (int i = 0; i < queue.size() - k; i++)
            queue.offer(queue.poll());

        return queue;
    }
}
