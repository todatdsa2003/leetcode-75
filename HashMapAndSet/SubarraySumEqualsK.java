import java.util.HashMap;

public class SubarraySumEqualsK {
    class Solution {
        public int subarraySum(int[] nums, int k) {
            // Key: Tong tam thoi den vi tri i
            // Value: So lan tong do xuat hien
            HashMap<Integer, Integer> map = new HashMap<>();
            map.put(0, 1); // Tong = 0 xuat hien 1 lan

            int count = 0;
            int sum = 0;
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];

                // if (map.containsKey(sum - k)) {
                // count += map.get(sum - k);
                // }

                // Cac tham khao toi uu memory
                count += map.getOrDefault(sum - k, 0);

                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }

            return count;
        }
    }
}
