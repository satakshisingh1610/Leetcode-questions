class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int [] dp1 = new int[nums.length];
        Arrays.fill(dp1,-1);
        int [] dp2 = new int[nums.length];
        Arrays.fill(dp2,-1);
        int case1 = dfs(nums, 1 , nums.length-1,dp1);
        int case2= dfs(nums,0,nums.length-2,dp2);
        return Math.max(case1,case2);
    }
    public int dfs(int[] nums, int i ,int end , int[] dp){
        if(i>end){
            return 0;
        }
        if(dp[i]!=-1){
            return dp[i];
        }
        int take = nums[i] + dfs(nums, i+2, end,dp);
        int skip = dfs(nums,i+1,end,dp);
        dp[i]= Math.max(take,skip);
        return dp[i];
    }
}