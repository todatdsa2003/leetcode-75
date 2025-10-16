public class DefuseTheBomb {
    class Solution {
        public int[] decrypt(int[] code, int k) {
            int[] result = new int[code.length];

            if (k == 0) {
                return result;
            }

            int start, end;
            if (k > 0) {
                start = 1;
                end = k;
            } else {
                start = code.length + k;
                end = code.length - 1;
            }

            int windowSum = 0;
            for (int i = start; i <= end; i++) {
                windowSum += code[i];
            }
            result[0] = windowSum;

            for (int i = 1; i < code.length; i++) {
                windowSum -= code[start % code.length];
                start++;
                end++;
                windowSum += code[end % code.length];

                result[i] = windowSum;
            }

            return result;
        }
    }

    public static void main(String[] args) {
        Solution solution = new DefuseTheBomb().new Solution();
        int[] code = { 5, 7, 1, 4 };
        int k = 3;
        int[] result = solution.decrypt(code, k);
        System.out.print("Decrypted code: ");
        for (int num : result) {
            System.out.print(num + " ");
        }
    }

}
