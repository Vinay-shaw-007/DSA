package Strings;

import java.util.Arrays;

public class Longest_Common_Prefix {
    public static void main(String[] args) {
        String[] strs = { "flower", "flow", "flight" };
        System.out.println(findLongesCommonPrefix(strs));
    }

    private static String findLongesCommonPrefix(String[] strs) {

        Arrays.sort(strs);

        String first = strs[0];
        String last = strs[strs.length - 1];

        int idx = 0;

        while (idx < first.charAt(idx) && idx < last.charAt(idx)) {
            if (first.charAt(idx) != last.charAt(idx)) {
                break;
            } else {
                idx++;
            }
        }

        return first.substring(0, idx);
    }
}
