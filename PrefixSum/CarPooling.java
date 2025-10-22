 class Solution {
        public boolean carPooling(int[][] trips, int capacity) {
            int[] timeline = new int[1001];
            for (int[] trip : trips) {
                int numPassengers = trip[0];
                int from = trip[1];
                int to = trip[2];
                timeline[from] += numPassengers;
                timeline[to] -= numPassengers;
            }

            int current = 0;
            for (int passengers : timeline) {
                current += passengers;
                if (current > capacity)
                    return false;
            }
            return true;
        }
    }
