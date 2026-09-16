class Solution {

    public int change(int amount, int[] coins) {

        int dp[][] = new int[amount + 1][coins.length];

        for(int i = 0; i <= amount; i++){
            Arrays.fill(dp[i], -1);
        }

        return dfs(amount, coins, 0, dp);
    }

    public int dfs(int amount, int[] coins, int index, int[][] dp){

        if(amount == 0){
            return 1;
        }

        if(amount < 0 || index == coins.length){
            return 0;
        }

        if(dp[amount][index] != -1){
            return dp[amount][index];
        }

        int take = dfs(amount - coins[index], coins, index, dp);

        int skip = dfs(amount, coins, index + 1, dp);

        dp[amount][index] = take + skip;

        return dp[amount][index];
    }
}