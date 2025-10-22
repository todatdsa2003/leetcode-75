class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        int[] prefixSum = new int[garbage.length];

        prefixSum[0] = 0;

        for (int i = 1; i < garbage.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + travel[i - 1];
        }

        int pickingTime = 0;
        int lastM = 0;
        int lastP = 0;
        int lastG = 0;

        for (int i = 0; i < garbage.length; i++) {
            String s = garbage[i];
            pickingTime += s.length();
            if (s.contains("M")) {
                lastM = i;
            }
            if (s.contains("P")) {
                lastP = i;
            }
            if (s.contains("G")) {
                lastG = i;
            }
        }
        int travelTimeM = prefixSum[lastM];
        int travelTimeP = prefixSum[lastP];
        int travelTimeG = prefixSum[lastG];

        int totalTravelTime = travelTimeM + travelTimeP + travelTimeG;
        return (pickingTime + totalTravelTime);
    }
}
