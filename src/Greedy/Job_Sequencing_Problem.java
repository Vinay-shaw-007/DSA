package Greedy;

import java.util.Arrays;

public class Job_Sequencing_Problem {
    public static void main(String[] args) {
        int n = 17;
        Job[] arr = new Job[n];
        arr[0] = new Job(1, 3, 288);
        arr[1] = new Job(2, 2, 435);
        arr[2] = new Job(3, 10, 401);
        arr[3] = new Job(4, 16, 368);
        arr[4] = new Job(5, 16, 248);
        arr[5] = new Job(6, 1, 361);
        arr[6] = new Job(7, 11, 108);
        arr[7] = new Job(8, 10, 167);
        arr[8] = new Job(9, 5, 251);
        arr[9] = new Job(10, 3, 170);
        arr[10] = new Job(11, 14, 156);
        arr[11] = new Job(12, 6, 184);
        arr[12] = new Job(13, 4, 370);
        arr[13] = new Job(14, 5, 424);
        arr[14] = new Job(15, 8, 397);
        arr[15] = new Job(16, 5, 375);
        arr[16] = new Job(17, 5, 218);

        JobScheduling(arr, n);
    }

    private static void JobScheduling(Job[] arr, int n) {
        Arrays.sort(arr, (a, b) -> {
            return Integer.compare(b.profit, a.profit);
        });

        int max = -1, count = 0, profit = 0;
        for (Job job : arr) {
            if (job.deadline > max) {
                max = job.deadline;
            }
        }
        int[] result = new int[max + 1];
        Arrays.fill(result, -1);

        for (Job i : arr) {
            int idx = i.deadline;
            while (idx > 0) {
                if (result[idx] == -1) {
                    result[idx] = i.id;
                    count++;
                    profit += i.profit;
                    break;
                }
                idx--;
            }
        }
        System.out.println("Count = " + count + ", Profit = " + profit);
    }
}

class Job {
    int id, profit, deadline;

    Job(int x, int y, int z) {
        this.id = x;
        this.deadline = y;
        this.profit = z;
    }
}
