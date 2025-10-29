class Solution {
    // public int timeRequiredToBuy(int[] tickets, int k) {
    // Queue<Integer> queue = new LinkedList<>();
    // for (int i = 0; i < tickets.length; i++) {
    // queue.offer(i);
    // }
    // int time = 0;

    // while (!queue.isEmpty()) {
    // int index = queue.poll();
    // time++;
    // tickets[index]--;

    // if (index == k && tickets[index] == 0) {
    // return time;
    // }

    // if (tickets[index] > 0) {
    // queue.offer(index);
    // }
    // }
    // return time;
    // }

    public int timeRequiredToBuy(int[] tickets, int k) {
        // Tham khao
        int time = 0;
        int n = tickets.length;

        for (int i = 0; i < n; i++) {
            if (i <= k) {
                time += Math.min(tickets[i], tickets[k]);
            } else {
                time += Math.min(tickets[i], tickets[k] - 1);
            }
        }

        return time;
    }
}