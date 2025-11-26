class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int n = potions.length;
        int[] result = new int[spells.length];

        for (int i = 0; i < spells.length; i++) {
            long target = (success + spells[i] - 1L) / spells[i];
            int index = lowerBound(potions, target);
            result[i] = n - index;
        }
        return result;
    }

    private int lowerBound(int[] potions, long target) {
        int left = 0;
        int right = potions.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (potions[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}