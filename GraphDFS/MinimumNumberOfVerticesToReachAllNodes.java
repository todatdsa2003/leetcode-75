class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        boolean[] check = new boolean[n];

        for (List<Integer> e : edges) {
            check[e.get(1)] = true;
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!check[i]) result.add(i);
        }

        return result;
    }
}
