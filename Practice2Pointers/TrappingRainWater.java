class Solution {
    public int trap(int[] height) {
        if (height == null || height.length < 3) {
            return 0;
        }

        int left = 0;
        int right = height.length - 1;

        int leftMax = 0;
        int rightMax = 0;

        int totalWater = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                // If left pointer is lower than right pointer, process left side
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    totalWater += leftMax - height[left];
                }

                left++;
            } else {
                // If right pointer is lower than or equal to left pointer, process right side
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    totalWater += rightMax - height[right];
                }

                right--;
            }
        }

        return totalWater;
    }
}