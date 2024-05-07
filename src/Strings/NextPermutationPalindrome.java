package Strings;
import java.util.* ;
public class NextPermutationPalindrome {

    public static void main(String[] args) {
        String s = "1234321";
        System.out.println(nextLargestPalindrome(s, s.length()));
    }
    public static String nextLargestPalindrome(String number, int n) {
        boolean solved = false;
        int carry = 1;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(number.charAt(i) - '0');
        }
        for (int i = n /2; i < n; i++) {

            if (list.get(n - i - 1) > list.get(i)) {
                list.set(i, list.get(n - i - 1));

                for (int j = i + 1; j < n; j++) {
                    list.set(j, list.get(n - j - 1));
                }

                solved = true;
                break;

            } else if (list.get(n - i - 1) < list.get(i)) {
                break;
            }
        }

        if (!solved) {
            for (int i = (n - 1) / 2; i >= 0; i--) {
                if (list.get(i) + carry == 10) {
                    list.set(i, 0);
                } else {
                    list.set(i, list.get(i)+1);
                    carry = 0;
                    break;
                }
            }

            if (carry == 1) {
                list.add(0, 1);
                n++;
            }

            for (int i = (n+1)/2; i < n; i++) {
                list.set(i, list.get(n - i - 1));
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Integer i : list) {
            sb.append(i);
        }

        return sb.toString();
    }
}