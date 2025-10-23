class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        // Dung HashMap de dem so lan xuat hien cua moi phan tu
        HashMap<Integer, Integer> countMap = new HashMap<>();
        for (int num : arr) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        // Dung HashSet de kiem tra su duy nhat cua cac so lan xuat hien
        HashSet<Integer> set1 = new HashSet<>();
        for (int count : countMap.values()) {
            if (!set1.add(count)) {
                return false;
            }
        }

        return true;
    }
}