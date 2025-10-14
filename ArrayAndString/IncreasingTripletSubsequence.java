class Solution {
    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }
        int first = nums[0];
        int second = Integer.MAX_VALUE;

        for (int n : nums) {
            if (n <= first) {
                first = n;
            } else if (n <= second) {
                second = n;
            } else {
                return true;
            }
        }
        return false;
    }
}