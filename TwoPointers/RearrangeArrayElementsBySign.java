//
class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        // Positive index
        int i = 0;
        // Negative index
        int j = 1;

        for (int num : nums) {
            if (num > 0) {
                result[i] = num;
                i += 2;
            } else {
                result[j] = num;
                j += 2;
            }
        }
        return result;
    }
}