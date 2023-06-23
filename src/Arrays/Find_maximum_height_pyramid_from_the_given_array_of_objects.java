package Arrays;

import java.util.Arrays;

public class Find_maximum_height_pyramid_from_the_given_array_of_objects {
    public static void main(String[] args) {
        // int[] height = { 10, 20, 30, 50, 60, 100 };
        int[] height = { 40, 20, 30, 100 };
        System.out.println(findMaxHeight(height));
    }

    private static int findMaxHeight(int[] arr) {

        if (arr.length == 1) {
            return 1;
        }
        Arrays.sort(arr);

        int ans = 1;

        int prev_width = arr[0];
        int prev_count = 1;

        int curr_width = 0;
        int curr_count = 0;

        for (int i = 0; i < arr.length; i++) {
            curr_width += arr[i];
            curr_count += 1;

            if (curr_width > prev_width && curr_count > prev_count) {
                prev_count = curr_count;
                prev_width = curr_width;

                curr_count = 0;
                curr_width = 0;

                ans += 1;
            }
        }

        return ans;
    }
}
