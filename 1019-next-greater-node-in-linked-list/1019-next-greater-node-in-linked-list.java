class Solution {
    public int[] nextLargerNodes(ListNode head) {

        ArrayList<Integer> arr = new ArrayList<>();

        ListNode curr = head;

        while (curr != null) {
            arr.add(curr.val);
            curr = curr.next;
        }

        int[] ans = new int[arr.size()];

        for (int i = 0; i < arr.size(); i++) {

            for (int j = i + 1; j < arr.size(); j++) {

                if (arr.get(j) > arr.get(i)) {
                    ans[i] = arr.get(j);
                    break;
                }
            }
        }

        return ans;
    }
}