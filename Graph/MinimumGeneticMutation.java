class Solution {
    public int minMutation(String start, String end, String[] bank) {
        Set<String> dict = new HashSet<>();
        for (String b : bank) {
            dict.add(b);
        }
        if (!dict.contains(end))
            return -1;

        ArrayDeque<String> q = new ArrayDeque<>();
        q.add(start);

        Set<String> visited = new HashSet<>();
        visited.add(start);

        char[] gene = { 'A', 'C', 'G', 'T' };
        int steps = 0;

        while (!q.isEmpty()) {
            for (int s = q.size(); s > 0; s--) {
                String cur = q.removeFirst();
                if (cur.equals(end))
                    return steps;

                char[] arr = cur.toCharArray();

                for (int i = 0; i < 8; i++) {
                    char old = arr[i];
                    for (char g : gene) {
                        if (g == old)
                            continue;
                        arr[i] = g;
                        String mut = new String(arr);

                        if (dict.contains(mut) && visited.add(mut))
                            q.add(mut);
                    }
                    arr[i] = old;
                }
            }
            steps++;
        }
        return -1;
    }
}
