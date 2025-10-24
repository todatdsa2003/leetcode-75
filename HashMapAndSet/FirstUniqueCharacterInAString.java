class Solution {
    // public int firstUniqChar(String s) {
    // //Key: Cac ky tu
    // //Value: So lan xuat hien cua ky tu do
    // HashMap<Character, Integer> freqMap = new HashMap<>();

    // for (char c : s.toCharArray()) {
    // freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
    // }

    // // Duyet lai chuoi de tim ky tu unique dau tien
    // for (int i = 0; i < s.length(); i++) {
    // if (freqMap.get(s.charAt(i)) == 1) {
    // return i;
    // }
    // }

    // return -1;
    // }

    // Cach tham khao dung array int[26]

    public int firstUniqChar(String s) {
        // Array dem so lan xuat hien cua tung ky tu ('a' - 'z')
        int[] count = new int[26];

        // Dem so lan xuat hien cua tung ky tu
        for (char c : s.toCharArray()) {
            count[c - 'a']++; // Map ky tu 'a'-'z' thanh index 0-25
        }

        // Duyet lai chuoi, tim ky tu dau tien co count = 1
        for (int i = 0; i < s.length(); i++) {
            if (count[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }

        return -1; // Khong co ky tu nao unique
    }
}