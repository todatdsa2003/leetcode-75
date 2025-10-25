class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }

        Map<Character, Integer> need = new HashMap<>();
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int left = 0, matched = 0;
        int minLength = Integer.MAX_VALUE, minStart = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            if (need.containsKey(c)) {
                need.put(c, need.get(c) - 1);
                if (need.get(c) >= 0) {
                    matched++;
                }
            }

            while (matched == t.length()) {
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    minStart = left;
                }

                char leftChar = s.charAt(left);
                if (need.containsKey(leftChar)) {
                    need.put(leftChar, need.get(leftChar) + 1);
                    if (need.get(leftChar) > 0) {
                        matched--;
                    }
                }
                left++;
            }
        }

        return minLength == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLength);
    }
}