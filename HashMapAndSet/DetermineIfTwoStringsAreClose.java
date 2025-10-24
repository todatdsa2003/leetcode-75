class Solution {
    //
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }

        int[] count1 = new int[26];
        int[] count2 = new int[26];
        Set<Character> set1 = new HashSet<>();
        Set<Character> set2 = new HashSet<>();

        for (char c : word1.toCharArray()) {
            count1[c - 'a']++;
            set1.add(c);
        }

        for (char c : word2.toCharArray()) {
            count2[c - 'a']++;
            set2.add(c);
        }

        if (!set1.equals(set2)) {
            return false;
        }

        Arrays.sort(count1);
        Arrays.sort(count2);

        return Arrays.equals(count1, count2);
    }
    // Cach Tham Khao
    // public boolean closeStrings(String word1, String word2) {
    // // Neu do dai khac nhau thi khong the gan nhau
    // if (word1.length() != word2.length()) {
    // return false;
    // }

    // // Dem tan so xuat hien cua tung ky tu trong hai chuoi
    // int[] count1 = new int[26];
    // int[] count2 = new int[26];

    // for (char c : word1.toCharArray()) {
    // count1[c - 'a']++;
    // }

    // for (char c : word2.toCharArray()) {
    // count2[c - 'a']++;
    // }

    // // Kiem tra co cung ky tu hay khong
    // for (int i = 0; i < 26; i++) {
    // if ((count1[i] == 0 && count2[i] != 0) || (count1[i] != 0 && count2[i] == 0))
    // {
    // return false;
    // }
    // }

    // // Sap xep tan so xuat hien va so sanh
    // Arrays.sort(count1);
    // Arrays.sort(count2);

    // return Arrays.equals(count1, count2);
    // }
}
