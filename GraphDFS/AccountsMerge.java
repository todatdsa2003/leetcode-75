class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, List<String>> graph = new HashMap<>();
        Map<String, String> emailToName = new HashMap<>();

        for (List<String> acc : accounts) {
            String name = acc.get(0);
            String firstEmail = acc.get(1);
            emailToName.put(firstEmail, name);

            //Neu key chua ton tai → them moi
            //NNeu key da ton tai → KHONG lam gi ca
            graph.putIfAbsent(firstEmail, new ArrayList<>());

            for (int i = 2; i < acc.size(); i++) {
                String email = acc.get(i);

                emailToName.put(email, name);
                graph.putIfAbsent(email, new ArrayList<>());
                graph.get(firstEmail).add(email);
                graph.get(email).add(firstEmail);
            }
        }

        Set<String> visited = new HashSet<>();
        List<List<String>> result = new ArrayList<>();

        for (String email : graph.keySet()) {
            if (!visited.contains(email)) {
                List<String> group = new ArrayList<>();
                dfs(email, graph, visited, group);
                Collections.sort(group); 
                group.add(0, emailToName.get(email));
                result.add(group);
            }
        }

        return result;
    }

    private void dfs(String email,
                     Map<String, List<String>> graph,
                     Set<String> visited,
                     List<String> group) {

        visited.add(email);
        group.add(email);

        for (String next : graph.get(email)) {
            if (!visited.contains(next)) {
                dfs(next, graph, visited, group);
            }
        }
    }
}
