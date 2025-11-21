class Solution {
    public long maximumImportance(int n, int[][] roads) {
        int[] d = new int[n];

        for (int[] e : roads) {
            d[e[0]]++;
            d[e[1]]++;
        }

        Integer[] nodes = new Integer[n];
        for (int i = 0; i < n; i++)
            nodes[i] = i;

        Arrays.sort(nodes, (a, b) -> d[a] - d[b]);

        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[nodes[i]] = i + 1;

        long result = 0;
        for (int[] e : roads)
            result += arr[e[0]] + arr[e[1]];

        return result;
    }
}
