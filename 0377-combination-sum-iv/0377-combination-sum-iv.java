class Solution {
    public int combinationSum4(int[] nums, int target) {
        int [] dp = new int [target+1];
        Arrays.fill(dp,-1);
        dp[0]=0;
        return dfs(target,nums,dp);

    }
    public int dfs(int target,int [] nums,int [] dp){
        int sum=0;
        if(target==0){
            return 1;
        }
        if(target<0){
            return 0;
        }
        if(dp[target]!=-1){
            return dp[target];
        }
        for(int num:nums){
            sum+= dfs(target-num,nums,dp);
        }
        dp[target]= sum;
        return dp[target];

    }
}