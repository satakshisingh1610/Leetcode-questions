class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        backtrack(ans, 0,0, "",n);
        return ans;
    }
    public void backtrack(List<String> ans , int right , int left , String s , int n){
        if(s.length() == 2*n){
            ans.add(s);
            return ;
        }

        if(left<n){
            backtrack(ans, right,left+1, s+"(" , n);
        }
        if(right<left){
            backtrack(ans,right+1 ,left, s+")" , n);
        }
    }
}