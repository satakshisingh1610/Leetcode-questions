class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> st = new Stack<>();
        for(String op : operations){
            if(op.equals("+")){
                int last = st.pop();
                int sum = last + st.peek();
                st.push(last);
                st.push(sum);
            }
            else if(op.equals("C")){
                st.pop();
            }
            else if(op.equals("D")){
                st.push(2*st.peek());
            }
            else{
              st.push(Integer.parseInt(op));
            }
        }
        int a =0;
        for(int s: st){
            a +=s;
        }
        return a;
    }
}