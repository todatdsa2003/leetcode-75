import java.util.HashMap;
import java.util.Map;

public class ContinuousSubarraySum {
    class Solution {
        public boolean checkSubarraySum(int[] nums, int k) {
            if (nums.length < 2)
                return false;
            Map<Integer, Integer> map = new HashMap<>();
            map.put(0, -1);

            int prefixSum = 0;

            for (int i = 0; i < nums.length; i++) {
                prefixSum += nums[i];
                int r = prefixSum % k;
                if (map.containsKey(r)) {
                    if (i - map.get(r) > 1) {
                        return true;
                    }
                } else {
                    map.put(r, i);
                }
            }

            return false;
        }
    }
}