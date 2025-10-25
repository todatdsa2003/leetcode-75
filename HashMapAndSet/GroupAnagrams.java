class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // Key: Chuoi da sap xep
        // Value: Danh sach chuoi ban dau
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            String key = new String(charArray);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }

        return new ArrayList<>(map.values());
    }
}