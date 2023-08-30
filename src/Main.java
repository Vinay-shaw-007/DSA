// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.


import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(Solution.count("hello world, hello universe", "hello"));
    }

}
class Solution {
    public static int count(String text, String word) {
        int count = 0;
        for (int i = 0; i <= text.length() - word.length(); i++) {
            String subString = text.substring(i, word.length()+i);
            if (subString.equals(word)) count++;
        }
        return count;
    }
}