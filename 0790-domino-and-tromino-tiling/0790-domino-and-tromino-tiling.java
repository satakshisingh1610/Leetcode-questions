class Solution {
       long MOD = 1000000007;
       long[] dp;
    public int numTilings(int n) {
       dp = new long[n + 1];
       Arrays.fill(dp,-1);
       return (int) dfs(n);

    }
    public long dfs(int n ){
        if(n==0) return 1;
        if(n==1) return 1;
        if(n==2) return 2;
        if(dp[n] != -1){
            return dp[n];
        }
        dp[n] = (2*dfs(n-1) + dfs(n-3)) % MOD;
        return dp[n];
    }
}