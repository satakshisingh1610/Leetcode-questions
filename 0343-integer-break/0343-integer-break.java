class Solution {
    int []dp ;
    public int integerBreak(int n) {
        dp = new int[n+1];
        Arrays.fill(dp , -1);
        return dfs(n);
    }
    public int dfs(int n){
        if(n == 1){
            return 1;
        }
        if(dp[n]!=-1){
            return dp[n];
        }
        int pro=0;
        for(int i =1 ;i<n;i++){
            int max = i * Math.max(n-i , dfs(n-i));
             pro = Math.max(pro,max);
        }
        dp[n] = pro;
        return dp[n];
    }
}