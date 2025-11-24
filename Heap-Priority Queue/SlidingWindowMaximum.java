class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // Using Deque
        // int n = nums.length;
        // Deque<Integer> dq = new LinkedList<>();
        // int[] result = new int[n - k + 1];
        // int idx = 0;

        // for (int i = 0; i < n; i++) {
        // if (!dq.isEmpty() && dq.getFirst() == i - k)
        // dq.removeFirst();
        // while (!dq.isEmpty() && nums[dq.getLast()] <= nums[i])
        // dq.removeLast();
        // dq.addLast(i);
        // if (i >= k - 1)
        // result[idx++] = nums[dq.getFirst()];
        // }

        // return result;

        // PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        // int n = nums.length;
        // int[] result = new int[n - k + 1];

        // for (int i = 0; i < k; i++)
        // pq.offer(new int[] { nums[i], i });
        // result[0] = pq.peek()[0];

        // for (int i = k; i < n; i++) {
        // pq.offer(new int[] { nums[i], i });
        // while (pq.peek()[1] <= i - k)
        // pq.poll();
        // result[i - k + 1] = pq.peek()[0];
        // }

        // return result;
    }

}