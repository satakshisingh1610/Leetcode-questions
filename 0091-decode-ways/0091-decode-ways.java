class Solution {

    public int numDecodings(String s) {

        int[] dp = new int[s.length() + 1];

        Arrays.fill(dp, -1);

        return dfs(s, 0, dp);
    }

    public int dfs(String s, int i, int[] dp) {

        // Successfully decoded the whole string
        if (i == s.length()) {
            return 1;
        }

        // 0 cannot be decoded alone
        if (s.charAt(i) == '0') {
            return 0;
        }

        // Already calculated
        if (dp[i] != -1) {
            return dp[i];
        }

        // Take one digit
        int one = dfs(s, i + 1, dp);

        int two = 0;

        // Make sure next character exists
        if (i + 1 < s.length()) {

            int num = (s.charAt(i) - '0') * 10
                    + (s.charAt(i + 1) - '0');

            // Two digits can form an alphabet
            if (num >= 10 && num <= 26) {
                two = dfs(s, i + 2, dp);
            }
        }

        dp[i] = one + two;

        return dp[i];
    }
}