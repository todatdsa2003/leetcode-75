class Solution {
    public int largestAltitude(int[] gain) {
        int max = 0;
        int prefixsum = 0;

        for (int g : gain) {
            prefixsum += g;
            max = Math.max(max, prefixsum);
        }
        return max;
    }
}