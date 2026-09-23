class Solution {

    int MOD = 1000000007;
    long[] dp;

    public int numTilings(int n) {

        dp = new long[n + 1];

        Arrays.fill(dp, -1);

        return (int) dfs(n);
    }

    public long dfs(int n) {

        // Base cases
        if (n == 0) return 1;
        if (n == 1) return 1;
        if (n == 2) return 2;

        // Already calculated
        if (dp[n] != -1) {
            return dp[n];
        }

        // DP recurrence
        dp[n] = (2 * dfs(n - 1) + dfs(n - 3)) % MOD;

        return dp[n];
    }
}