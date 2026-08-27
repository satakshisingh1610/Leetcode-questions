class Solution {
    public int height (TreeNode root){
        if(root==null ||(root.left==null && root.right==null)) return 0;
        return 1 + Math.max(height(root.left),height(root.right));
    }
    public void nth (TreeNode root , int n , List<Integer> arr){
        if(root==null) return;
        if(n==1){
            arr.add(root.val);
            return;
        }
        nth(root.left,n-1,arr);
        nth(root.right,n-1,arr);
    }
    public void nth2(TreeNode root , int n , List<Integer> arr){ 
        if(root==null) return; 
        if(n==1){
             arr.add(root.val);
              return;
               } 
        nth2(root.right , n-1,arr); 
        nth2(root.left , n-1,arr); }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root==null) return ans ;
        int n = 1 + height (root);
        for(int i =1;i<=n;i++){
            List<Integer>arr = new ArrayList<>();
            if(i%2!=0){
                nth(root,i,arr);
                ans.add(arr);
            }
            else{
                nth2(root,i,arr);
                ans.add(arr);
        }
        }
        return ans;
        
    }
}