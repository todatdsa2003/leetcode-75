class Solution {
    public long largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        long sum = 0;
        long result = -1;

        for (int num : nums) {
            if (sum > num) {
                result = sum + num;
            }
            sum += num;
        }

        return result;
    }
}