public class FindTheKBeautyOfANumber {
    class Solution {
        public int divisorSubstrings(int num, int k) {
            String s = Integer.toString(num);
            int n = s.length();
            int count = 0; 

            for (int i = 0; i <= n - k; i++) {
                String sub = s.substring(i, i + k);
                int divisor = Integer.parseInt(sub);

                if (divisor != 0 && num % divisor == 0) {
                    count++;
                }
            }

            return count;
        }
    }

    public static void main(String[] args) {
        Solution solution = new FindTheKBeautyOfANumber().new Solution();
        int num = 240;
        int k = 2;
        int result = solution.divisorSubstrings(num, k);
        System.out.println("The K-Beauty of the number is: " + result);
    }
}