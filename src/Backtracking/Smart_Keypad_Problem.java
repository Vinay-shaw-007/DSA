package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class Smart_Keypad_Problem {
    public static void main(String[] args) {
        for (String s :
                letterCombinations("237")) {
            System.out.println(s);
        }
    }

    public static List<String> letterCombinations(String digits) {
        //You can code here
        List<String> ans = new ArrayList<>();
        ArrayList<String> value = new ArrayList<>();
        fillValues(value);
        helper(ans, value, digits, "", 0);
        return ans;
    }

    public static void helper(List<String> ans, ArrayList<String> value, String input,
                              String ss, int index) {
        if (index >= input.length()) {
            ans.add(ss);
            return;
        }
        String inputString;
        inputString = value.get(Character.getNumericValue(input.charAt(index)));
        for (int i = 0; i < inputString.length(); i++)
            helper(ans, value, input, ss + inputString.charAt(i), index + 1);


    }

    public static void fillValues(ArrayList<String> value) {
        value.add(0, null);
        value.add(1, null);
        value.add(2, "abc");
        value.add(3, "def");
        value.add(4, "ghi");
        value.add(5, "jkl");
        value.add(6, "mno");
        value.add(7, "pqrs");
        value.add(8, "tuv");
        value.add(9, "wxyz");
    }
}
/*
Input:
digits = "23"
Output:
["ad","ae","af","bd","be","bf","cd","ce","cf"]
 */
