class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int n = nums.length;
        // Tinh tong cua moi subarray co do dai k
        int[] sums = new int[n - k + 1];
        int windowSum = 0;

        for (int i = 0; i < k; i++) {
            windowSum += nums[i];
        }
        sums[0] = windowSum;

        for (int i = 1; i <= n - k; i++) {
            windowSum = windowSum - nums[i - 1] + nums[i + k - 1];
            sums[i] = windowSum;
        }

        // Tim ben trai de chon subarray tot nhat
        int[] left = new int[sums.length];
        int bestLeft = 0;

        for (int i = 0; i < sums.length; i++) {
            if (sums[i] > sums[bestLeft]) {
                bestLeft = i;
            }
            left[i] = bestLeft;
        }

        // Tim ben phai de chon subarray tot nhat
        int[] right = new int[sums.length];
        int bestRight = sums.length - 1;

        for (int i = sums.length - 1; i >= 0; i--) {
            if (sums[i] >= sums[bestRight]) {
                bestRight = i;
            }
            right[i] = bestRight;
        }

        // Tim o giua de chon 3 subarray
        int[] result = new int[3];
        int maxSum = 0;

        for (int mid = k; mid <= sums.length - k - 1; mid++) {
            int leftSubarray = left[mid - k];
            int rightSubarray = right[mid + k];
            int totalSum = sums[leftSubarray] + sums[mid] + sums[rightSubarray];

            if (totalSum > maxSum) {
                maxSum = totalSum;
                result[0] = leftSubarray;
                result[1] = mid;
                result[2] = rightSubarray;
            }
        }

        return result;
    }
}