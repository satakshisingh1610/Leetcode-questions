class Solution {
    List<List<String>> ans = new ArrayList<>();
    public List<List<String>> partition(String s) {
        List<String> curr = new ArrayList<>();
        backtrack(s,0,curr);
        return ans;
    }
    public void backtrack(String s , int index , List<String> curr){
        if(index==s.length()){
            ans.add(new ArrayList<>(curr));
            return ;
        }
        for (int i = index;i<s.length();i++){
            String part = s.substring(index,i+1);
            if(isPalindrome(part)){
                curr.add(part);
                backtrack(s,i+1,curr);
                curr.remove(curr.size() - 1);
            }

        }
    }
    public boolean isPalindrome(String s){
        int left =0;
        int right = s.length() -1 ;
        while(left<right){
            if(s.charAt(left)!=s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}