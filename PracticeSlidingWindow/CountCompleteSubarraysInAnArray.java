class Solution {
    public int countCompleteSubarrays(int[] nums) {
        int n = nums.length;
        Set<Integer> distinctArray = new HashSet<>();
        for (int num : nums) {
            distinctArray.add(num);
        }
        int k = distinctArray.size();

        int result = 0;
        int left = 0;
        HashMap<Integer, Integer> freqMap = new HashMap<>();

        for (int right = 0; right < n; right++) {
            freqMap.put(nums[right], freqMap.getOrDefault(nums[right], 0) + 1);
            while (freqMap.size() == k) {
                result += (n - right);
                freqMap.put(nums[left], freqMap.get(nums[left]) - 1);

                if (freqMap.get(nums[left]) == 0) {
                    freqMap.remove(nums[left]);
                }

                left++;
            }
        }

        return result;
    }
}