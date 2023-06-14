import java.util.Arrays;

public class Coin_Change {
    public static void main(String[] args) {
        // int[] coins = {186, 419, 83, 408};
        // int amount = 6249;
        int[] coins = {1, 2, 5};
        int amount = 11;
        System.out.println(coinChange(coins,amount));
    }

    public static int coinChange(int[] coins, int amount) {

        int[] dp = new int[amount+1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
    
        int key = countCoinsUsingMemoization(coins, amount, dp);
        if (key == Integer.MAX_VALUE) {
            return -1;
        }
        
        return key;
    }

    private static int countCoinsUsingMemoization(int[] coins, int amount, int[] dp) {

        if (amount == 0) {
            return 0;
        }

        if (amount < 0) return Integer.MAX_VALUE;

        if (dp[amount] != -1) return dp[amount];

        int mini = Integer.MAX_VALUE;

        for (int i = 0; i < coins.length; i++) {
            
            int ans = countCoinsUsingMemoization(coins, amount-coins[i], dp);

            if (ans != Integer.MAX_VALUE) {
                mini = Math.min(mini, 1 + ans);            
            }
        }


        return dp[amount] = mini;

    }
}
