class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        //a -> b = k, b -> a = 1/k
        Map<String, Map<String, Double>> graph = new HashMap<>();

        for (int i = 0; i < equations.size(); i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            double k = values[i];

            graph.putIfAbsent(a, new HashMap<>());
            graph.putIfAbsent(b, new HashMap<>());

            graph.get(a).put(b, k);       // a -> b
            graph.get(b).put(a, 1.0 / k); // b -> a
        }

        double[] answers = new double[queries.size()];

        for (int i = 0; i < queries.size(); i++) {
            String start = queries.get(i).get(0);
            String end = queries.get(i).get(1);

            //Neu mot bien start or end khong co trong mot equation nao thi 0 có thong tin nen ket qua se la -1.0.
            if (!graph.containsKey(start) || !graph.containsKey(end)) {
                answers[i] = -1.0;
                continue;
            }
            //Set tranh lap vo han 
            Set<String> visited = new HashSet<>();
            answers[i] = dfs(start, end, graph, visited, 1.0);
        }

        return answers;
    }

    private double dfs(String cur, String target,
                       Map<String, Map<String, Double>> graph,
                       Set<String> visited,
                       double value) {

        if (cur.equals(target)) return value;
        visited.add(cur);
        for (String next : graph.get(cur).keySet()) {
            if (!visited.contains(next)) {
                double result = dfs(next, target, graph, visited,
                                    value * graph.get(cur).get(next));
                if (result != -1.0) {
                    return result;
                }
            }
        }

        return -1.0;
    }
}
