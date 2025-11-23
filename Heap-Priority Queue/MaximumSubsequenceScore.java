class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;

        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }

        Arrays.sort(indices, (i, j) -> nums2[j] - nums2[i]);

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        long sum = 0;
        long max = 0;

        for (int i : indices) {
            minHeap.offer(nums1[i]);
            sum += nums1[i];

            if (minHeap.size() > k) {
                sum -= minHeap.poll();
            }

            if (minHeap.size() == k) {
                max = Math.max(max, sum * nums2[i]);
            }
        }

        return max;
    }
}