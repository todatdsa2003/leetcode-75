class Solution {
    public int findChampion(int n, int[][] edges) {
        int[] indegree = new int[n];

        for (int[] e : edges) {
            int winner = e[0], loser = e[1];
            indegree[loser]++;
        }

        int champion = -1;
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                champion = i;
                count++;
            }
        }

        return (count == 1) ? champion : -1;
    }
}
