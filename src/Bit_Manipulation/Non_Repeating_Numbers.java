package Bit_Manipulation;

public class Non_Repeating_Numbers {

    public static void main(String[] args) {
        int[] arr = {16, 17, 13, 7, 23, 24, 13, 26, 23, 24, 16, 7, 19, 3, 26, 17};
        singleNumber(arr);
    }

    private static void singleNumber(int[] nums) {
        int[] ans = new int[2];
        int res = 0, sitBitIndex = 1;

        for (int j : nums) {
            res = res ^ j;
        }

        String resBinary = Integer.toBinaryString(res);

        for (int i = resBinary.length() - 1; i >= 0; i--) {
            char ch = resBinary.charAt(i);
            if (ch == '1') {
                sitBitIndex = resBinary.length() - i;
                break;
            }
        }
        sitBitIndex--;
        sitBitIndex = (int) Math.pow(2, sitBitIndex);

        for (int num : nums) {
            if ((num & sitBitIndex) == 0) ans[0] ^= num;
            else ans[1] ^= num;
        }

        if (ans[0] > ans[1]) {
            int temp = ans[0];
            ans[0] = ans[1];
            ans[1] = temp;
        }
        System.out.println(ans[0]);
        System.out.println(ans[1]);
    }
}
