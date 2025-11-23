class SmallestInfiniteSet {
    private PriorityQueue<Integer> minHeap;
    private HashSet<Integer> inHeap; 
    private int currentSmallest;

    public SmallestInfiniteSet() {
        minHeap = new PriorityQueue<>();
        inHeap = new HashSet<>();
        currentSmallest = 1;
    }

    public int popSmallest() {
        if (!minHeap.isEmpty()) {
            int smallest = minHeap.poll();
            inHeap.remove(smallest); 
            return smallest;
        }

        int result = currentSmallest;
        currentSmallest++;
        return result;
    }

    public void addBack(int num) {
        if (num < currentSmallest && !inHeap.contains(num)) {
            minHeap.offer(num);
            inHeap.add(num);
        }
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */