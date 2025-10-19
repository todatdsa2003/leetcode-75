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