class Solution {
    int [][] dp;
    public int minDistance(String word1, String word2) {
        dp= new int[word1.length()][word2.length()];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return dfs(0,0,word1,word2);
    }
    public int dfs(int i , int j , String word1 , String word2){
        if(i==word1.length()){
            return word2.length() - j;
        }
        if(j==word2.length()){
            return word1.length() - i;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        if(word1.charAt(i) == word2.charAt(j)){
         dp[i][j]=   dfs(i+1,j+1, word1,word2);
        }
        else{
            int insert= 1 + dfs(i,j+1 , word1,word2);
            int delete = 1 + dfs(i+1,j,word1,word2);
            int replace = 1 + dfs(i+1,j+1,word1,word2);
            dp[i][j]= Math.min(insert, Math.min(delete,replace));
        }
            return dp[i][j];
        
    }
}