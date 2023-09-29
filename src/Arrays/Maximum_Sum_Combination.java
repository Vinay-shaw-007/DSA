package Arrays;

import java.util.*;

public class Maximum_Sum_Combination {
    public static void main(String[] args) {
        int N = 4;
        int K = 3;
        int[] A = {1, 4, 2, 3};
        int[] B = {2, 5, 1, 6};
        System.out.println(maxCombinations(N, K, A, B));
    }
    static List<Integer> maxCombinations(int N, int K, int A[], int B[]) {
        // code here
        List<Integer> list = new ArrayList<>();
        PriorityQueue<Integer> p = new PriorityQueue<>();


        Arrays.sort(A);
        Arrays.sort(B);


        for (int i = N - 1; i > N - K - 1; i--) {
            for (int j = N - 1; j > N - K - 1; j--) {
                int sum = A[i] + B[j];

                if (p.size() < K) p.add(sum);
                else {
                    if (p.peek() < sum) {
                        p.remove();
                        p.add(sum);
                    } else break;
                }
            }
        }

        while (p.size() > 0) {
            list.add(0, p.poll());
        }

        return list;
    }
}
