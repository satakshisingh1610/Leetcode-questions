class Solution {

    public int deleteAndEarn(int[] nums) {

        int max = 0;

        for (int num : nums) {
            max = Math.max(max, num);
        }

        int[] count = new int[max + 1];

        for (int num : nums) {
            count[num] += num;
        }

        int[] dp = new int[max + 2];

        Arrays.fill(dp, -1);

        return dfs(1, count, dp);
    }

    public int dfs(int i, int[] count, int[] dp) {

        if (i >= count.length) {
            return 0;
        }

        if (dp[i] != -1) {
            return dp[i];
        }

        int take = count[i] + dfs(i + 2, count, dp);

        int skip = dfs(i + 1, count, dp);

        dp[i] = Math.max(take, skip);

        return dp[i];
    }
}