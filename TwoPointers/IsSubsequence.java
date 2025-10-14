class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0) {
            return true;
        }
        int left = 0;
        for (int right = 0; right < t.length(); right++) {
            if (s.charAt(left) == t.charAt(right)) {
                left++;
                if (left == s.length()) {
                    return true;
                }
            }
        }
        return false;
    }
}