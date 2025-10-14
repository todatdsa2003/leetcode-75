class Solution {
    public int[] sortArrayByParity(int[] nums) {
        if(nums.length == 1) return nums;
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            if ((nums[right] % 2)  == 0) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
            }
        }
        return nums;
    }
}