class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        // Chuyen mang sang set de loai bo phan tu trung lap
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        // Them cac phan tu vao set1
        for (int num : nums1) {
            set1.add(num);
        }

        // Them cac phan tu vao set2
        for (int num : nums2) {
            set2.add(num);
        }

        // Tim phan tu trong nums1 nhung khong co trong nums2
        List<Integer> list1 = new ArrayList<>();
        for (int num : set1) {
            if (!set2.contains(num)) {
                list1.add(num);
            }
        }

        // Tim phan tu trong nums2 nhung khong co trong nums1
        List<Integer> list2 = new ArrayList<>();
        for (int num : set2) {
            if (!set1.contains(num)) {
                list2.add(num);
            }
        }

        // Ket qua
        return Arrays.asList(list1, list2);
    }
}
