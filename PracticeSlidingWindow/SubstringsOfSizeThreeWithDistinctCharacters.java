class Solution {
    public int countGoodSubstrings(String s) {
        if (s.length() < 3) {
            return 0;
        }

        int count = 0;

        for (int i = 0; i <= s.length() - 3; i++) {
            char char1 = s.charAt(i);
            char char2 = s.charAt(i + 1);
            char char3 = s.charAt(i + 2);

            if (char1 != char2 && char2 != char3 && char1 != char3) {
                count++;
            }
        }

        return count;
    }
}