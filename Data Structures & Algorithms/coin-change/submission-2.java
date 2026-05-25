class Solution {
    public int coinChange(int[] coins, int target) {

        int INF = (int)1e9;
        int[][] dp = new int[coins.length][target + 1];

        // Base case
        for (int t = 0; t <= target; t++) {
            if (t % coins[0] == 0)
                dp[0][t] = t / coins[0];
            else
                dp[0][t] = INF;
        }

        for (int i = 1; i < coins.length; i++) {
            for (int j = 1; j <= target; j++) {

                int notpick = dp[i - 1][j];

                int pick = INF;
                if (coins[i] <= j && dp[i][j - coins[i]] != INF) {
                    pick = 1 + dp[i][j - coins[i]];
                }

                dp[i][j] = Math.min(pick, notpick);
            }
        }

        int ans = dp[coins.length - 1][target];
        return ans >= INF ? -1 : ans;
    }
}