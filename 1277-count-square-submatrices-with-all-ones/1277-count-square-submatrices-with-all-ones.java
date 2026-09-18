class Solution {
    public int countSquares(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int[][] dp = new int[n][m];

        // -1 means "not calculated yet"
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ans += dfs(i, j, matrix, dp);
            }
        }

        return ans;
    }

    public int dfs(int i, int j, int[][] matrix, int[][] dp) {

        // Out of bounds
        if (i < 0 || j < 0) {
            return 0;
        }

        // Current cell is 0
        if (matrix[i][j] == 0) {
            return 0;
        }

        // Already calculated
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int up = dfs(i - 1, j, matrix, dp);
        int left = dfs(i, j - 1, matrix, dp);
        int diagonal = dfs(i - 1, j - 1, matrix, dp);

        dp[i][j] = 1 + Math.min(up, Math.min(left, diagonal));

        return dp[i][j];
    }
}