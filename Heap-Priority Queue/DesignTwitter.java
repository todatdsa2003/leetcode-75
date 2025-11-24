class Twitter {
    int time = 0;
    Map<Integer, Set<Integer>> followMap = new HashMap<>();
    Map<Integer, List<int[]>> tweets = new HashMap<>();

    public Twitter() {
    }

    public void postTweet(int userId, int tweetId) {
        tweets.putIfAbsent(userId, new ArrayList<>());
        tweets.get(userId).add(new int[] { tweetId, time++ });
    }

    public List<Integer> getNewsFeed(int userId) {
        followMap.putIfAbsent(userId, new HashSet<>());
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);

        if (tweets.containsKey(userId)) {
            List<int[]> list = tweets.get(userId);
            int idx = list.size() - 1;
            pq.offer(new int[] { list.get(idx)[0], list.get(idx)[1], idx, userId });
        }

        for (int f : followMap.get(userId)) {
            if (tweets.containsKey(f)) {
                List<int[]> list = tweets.get(f);
                int idx = list.size() - 1;
                pq.offer(new int[] { list.get(idx)[0], list.get(idx)[1], idx, f });
            }
        }

        List<Integer> result = new ArrayList<>();
        while (!pq.isEmpty() && result.size() < 10) {
            int[] top = pq.poll();
            result.add(top[0]);
            int idx = top[2] - 1;
            int uid = top[3];
            if (idx >= 0) {
                int[] prev = tweets.get(uid).get(idx);
                pq.offer(new int[] { prev[0], prev[1], idx, uid });
            }
        }
        return result;
    }

    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId)
            return;
        followMap.putIfAbsent(followerId, new HashSet<>());
        followMap.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (followMap.containsKey(followerId))
            followMap.get(followerId).remove(followeeId);
    }
}