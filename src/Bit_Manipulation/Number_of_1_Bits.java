package Bit_Manipulation;

public class Number_of_1_Bits {
    public static void main(String[] args) {
        int n = 6;
        System.out.println(setBits(n));
    }

    private static int setBits(int n) {
        int count = 0;

        while (n != 0) {
            if (n == 1) {
                count++;
                break;
            }
            int r = n % 2;
            if (r == 1) count++;
            n = n / 2;
        }

        return count;
    }
}
