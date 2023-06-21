package Arrays;

public class Container_With_Most_Water {
    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }

    private static int maxArea(int[] height) {
        int i = 0, j = height.length - 1;
        int mostWater = 0;
        while (i < j) {
            if (mostWater < Math.min(height[i], height[j]) * (j - i)) {
                mostWater = Math.min(height[i], height[j]) * (j - i);
            }

            if (height[i] <= height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return mostWater;
    }
}
