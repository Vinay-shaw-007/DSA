// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        // Press Alt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.

        System.out.println("Hello and welcome!");
        BigInteger b = new BigInteger("0");
         b = BigInteger.valueOf(2147418972);
         

        // Press Shift+F10 or click the green arrow button in the gutter to run the
        // code.
        for (int i = 1; i <= 5; i++) {

            // Press Shift+F9 to start debugging your code. We have set one breakpoint
            // for you, but you can always add more by pressing Ctrl+F8.
            // System.out.println("i = " + i);
        }

        int[][] interval = {
                { 2, 3 },
                { 1, 5 },
                { 2, 4 },
                { 7, 8 }
        };
        int row = interval.length;
        int column = interval[0].length;
        System.out.println("Row = "+row+", Column = "+column);
        Arrays.sort(interval, new Comparator<int[]>() {

            @Override
            public int compare(int[]o1, int[] o2) {
                int result = Integer.compare(o1[0], o2[0]);

                if (result ==  0) {
                    result = Integer.compare(o1[1], o2[1]);
                }
                return result;
            }
            
        });
        for (int i = 0; i < interval.length; i++) {
            for (int j = 0; j < interval[i].length; j++) {
                System.out.print(interval[i][j] + " ");
            }
            System.out.println();
        }
        // String n = "0470";
        // System.out.println(Integer.parseInt(n));
    }
}