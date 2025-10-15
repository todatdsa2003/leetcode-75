class Solution {
    public int numFriendRequests(int[] ages) {
        int[] count = new int[121];
        for (int age : ages) {
            count[age]++;
        }

        int totalReq = 0;

        for (int ageA = 1; ageA <= 120; ageA++) {
            int countA = count[ageA];

            if (countA == 0)
                continue;

            for (int ageB = 1; ageB <= 120; ageB++) {
                int countB = count[ageB];

                if (countB == 0)
                    continue;

                if (ageB <= 0.5 * ageA + 7)
                    continue;

                if (ageB > ageA)
                    continue;

                if (ageB > 100 && ageA < 100)
                    continue;

                if (ageA == ageB) {
                    totalReq += countA * (countA - 1);
                } else {
                    totalReq += countA * countB;
                }
            }
        }

        return totalReq;
    }
}