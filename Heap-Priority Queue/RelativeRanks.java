class Solution {
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;

        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> b[0] - a[0]);

        for (int i = 0; i < n; i++) {
            pq.add(new int[] { score[i], i });
        }

        String[] result = new String[n];
        int rank = 1;

        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            int idx = top[1];

            if (rank == 1)
                result[idx] = "Gold Medal";
            else if (rank == 2)
                result[idx] = "Silver Medal";
            else if (rank == 3)
                result[idx] = "Bronze Medal";
            else
                result[idx] = String.valueOf(rank);

            rank++;
        }

        return result;
    }
}
