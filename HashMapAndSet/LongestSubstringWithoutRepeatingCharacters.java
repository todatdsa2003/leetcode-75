class Solution {
    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        // DUng SLiding Window
        // Con tro ben trai
        int left = 0;

        // Key: Ky tu
        // Value: Vi tri xuat hien moi nhat cua ky tu do
        Map<Character, Integer> map = new HashMap<>();

        // Duyet tung ky tu trong chuoi
        for (int right = 0; right < s.length(); right++) {
            char charr = s.charAt(right);
            if (map.containsKey(charr)) {
                left = Math.max(left, map.get(charr) + 1);
            }
            map.put(charr, right);
            result = Math.max(result, right - left + 1);
        }

        return result;
    }
}