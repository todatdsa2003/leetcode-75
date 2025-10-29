class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        int n = deck.length;
        Queue<Integer> queue = new LinkedList<>();
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            queue.offer(i);
        }

        Arrays.sort(deck);

        for (int card : deck) {
            int i = queue.poll();
            result[i] = card;

            if (!queue.isEmpty()) {
                queue.offer(queue.poll());
            }
        }

        return result;

    }
}