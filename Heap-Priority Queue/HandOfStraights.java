class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if (n % groupSize != 0) {
            return false;
        }

        Map<Integer, Integer> freq = new HashMap<>();
        for (int h : hand) {
            freq.put(h, freq.getOrDefault(h, 0) + 1);
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(freq.keySet());

        while (!minHeap.isEmpty()) {
            int start = minHeap.peek();
            for (int i = 0; i < groupSize; i++) {
                int current = start + i;

                if (!freq.containsKey(current) || freq.get(current) == 0) {
                    return false;
                }
                freq.put(current, freq.get(current) - 1);
                if (freq.get(current) == 0) {
                    minHeap.poll();
                }
            }
        }
        return true;
    }
}