class RecentCounter {
    private Queue<Integer> queue;
    private static final int TIME_WINDOW = 3000;

    public RecentCounter() {
        queue = new LinkedList<>();
    }

    public int ping(int t) {
        queue.offer(t);

        int earliestValidTime = t - TIME_WINDOW;

        while (!queue.isEmpty() && queue.peek() < earliestValidTime) {
            queue.poll();
        }

        return queue.size();
    }
}