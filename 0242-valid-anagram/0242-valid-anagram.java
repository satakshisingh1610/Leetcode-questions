class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        String sorts = new String(arr);

        char[] arr2 = t.toCharArray();
        Arrays.sort(arr2);
        String sorts2 = new String(arr2);

        return sorts.equals(sorts2);
    }
}