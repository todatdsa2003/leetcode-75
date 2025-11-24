class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        PriorityQueue<Integer> leftHeap = new PriorityQueue<>();
        PriorityQueue<Integer> rightHeap = new PriorityQueue<>();

        int left = 0, right = costs.length - 1;
        long total = 0;

        for (int i = 0; i < candidates && left <= right; i++) {
            leftHeap.offer(costs[left++]);
        }
        for (int i = 0; i < candidates && left <= right; i++) {
            rightHeap.offer(costs[right--]);
        }

        for (int j = 0; j < k; j++) {
            int a = leftHeap.isEmpty() ? Integer.MAX_VALUE : leftHeap.peek();
            int b = rightHeap.isEmpty() ? Integer.MAX_VALUE : rightHeap.peek();

            if (a <= b) {
                total += leftHeap.poll();
                if (left <= right) {
                    leftHeap.offer(costs[left++]);
                }
            } else {
                total += rightHeap.poll();
                if (left <= right) {
                    rightHeap.offer(costs[right--]);
                }
            }
        }

        return total;
    }
}