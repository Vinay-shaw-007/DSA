package Strings;

public class Remove_Consecutive_Character {
    public static void main(String[] args) {
        String S = "aabbaa";
        System.out.println(removeConsecutiveCharacter(S));
    }

    private static String removeConsecutiveCharacter(String S) {
        StringBuilder newString = new StringBuilder();
        newString.append(S.charAt(0));

        for (int i = 1; i < S.length(); i++) {
            char ch = S.charAt(i);

            if (!(ch == S.charAt(i-1))) newString.append(ch);
        }
        return newString.toString();
    }
}
