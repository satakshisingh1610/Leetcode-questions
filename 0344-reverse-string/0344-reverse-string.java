class Solution {
    public void reverseString(char[] s) {
        int start =0;
        int end= s.length - 1;
        for(int i =0;i<s.length;i++){
            while(start<end){
                char c = s[start];
                s[start]=s[end];
                s[end]=c;
                start++;
                end--;
            }
        }
   }
}