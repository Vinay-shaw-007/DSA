// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        // Press Alt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.

        String n = "", ans = "";

        // Press Shift+F10 or click the green arrow button in the gutter to run the
        // code.
        for (int i = 0; i < n.length(); i++) {
            char ch = n.charAt(i);
            if (ch == ' ') {
                ans += '_';
            } else {
                ans += ch;
            }

            // Press Shift+F9 to start debugging your code. We have set one breakpoint
            // for you, but you can always add more by pressing Ctrl+F8.
            // System.out.println("i = " + i);
        }
        System.out.println(ans);

        /**
         * 17
               
         */

        Job[] job = new Job[17];
        job[0] = new Job(1, 3, 288);
        job[1] = new Job(2, 2, 435);
        job[2] = new Job(3 ,10 ,401);
        job[3] = new Job(4, 16, 368);
        job[4] = new Job(5, 16, 248);
        job[5] = new Job(6, 1 ,361);
        job[6] = new Job(7, 11, 108);
        job[7] = new Job(8, 10, 167);
        job[8] = new Job(9, 5 ,251);
        job[9] = new Job(10, 3, 170);
        job[10] = new Job(11, 14, 156);
        job[11] = new Job(12, 6 ,184);
        job[12] = new Job(13, 4 ,370);
        job[13] = new Job(14, 5 ,424);
        job[14] = new Job(15, 8 ,397);
        job[15] = new Job(16, 5 ,375);
        job[16] = new Job(17, 5 ,218);
        
        Arrays.sort(job, new Comparator<Job>() {

            @Override
            public int compare(Job job1, Job job2) {
                if (job1.deadline != job2.deadline) {
                     return Integer.compare(job1.deadline, job2.deadline);
                    } else {
                    return Integer.compare(job2.profit, job1.profit);
                }
            }
            
        } );
        // Print the sorted jobs
        for (Job job1 : job) {
            System.out.println(job1);
        }
    }
}

class Job {
    int id, deadline, profit;

    Job(int id, int deadline, int profit) {
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }

    @Override
    public String toString() {

        return "Id = " + id + ", deadline = " + deadline + ", profit = " + profit;
    }
}