 
 import java.util.*;

 public class Minimum_number_of_Coins {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(minPartition(n));
        sc.close();
    }

    private static List<Integer> minPartition(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        return partition(list, n);
    }

    public static ArrayList<Integer> partition(ArrayList<Integer> list, int n) {
        if (n == 0) return list;
        if (n <= 1) {
            list.add(1);
            n = n - 1;
        } else if (n >= 2 && n < 5) {
            list.add(2);
            n = n - 2;
        } else if (n >= 5 && n < 10) {
            list.add(5);
            n = n - 5;
        } else if (n >= 10 && n < 20) {
            list.add(10);
            n = n - 10;
        } else if (n >= 20 && n < 50) {
            list.add(20);
            n = n - 20;
        } else if (n >= 50 && n < 100) {
            list.add(50);
            n = n - 50;
        } else if (n >= 100 && n < 200) {
            list.add(100);
            n = n - 100;
        } else if (n >= 200 && n < 500) {
            list.add(200);
            n = n - 200;
        } else if (n >= 500 && n < 2000) {
            list.add(500);
            n = n - 500;
        } else {
            list.add(2000);
            n = n - 2000;
        }
        return partition(list, n);
    }
 }