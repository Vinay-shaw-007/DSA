package Arrays;

public class Best_Time_to_Buy_and_Sell_Stock {
    public static void main(String[] args) {
        // int[] prices = {7,1,5,3,6,4}; demo changes for testing
        int[] prices = {7,6,4,3,1};
        System.out.println(maxProfit(prices));
    }

    private static int maxProfit(int[] arr) {
        int max = 0, min = 0, maxp = 0;

        for (int i = 0; i < arr.length; i++) {
            if(arr[i] < arr[min]) min = i;
            max = i;
            if (arr[max] - arr[min] > maxp) {
                maxp = arr[max] - arr[min];
            }
        }
        return maxp;
    }
}
