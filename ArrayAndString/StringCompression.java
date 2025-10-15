public class StringCompression {
    public class Solution {
        public int compress(char[] chars) {
            int n = chars.length;
            if (n == 1) {
                return 1;
            }

            int index = 0;
            int count = 1;

            for (int i = 1; i < n; i++) {
                if (chars[i] == chars[i - 1]) {
                    count++;
                } else {
                    chars[index++] = chars[i - 1];
                    if (count > 1) {
                        String countStr = Integer.toString(count);
                        for (char c : countStr.toCharArray()) {
                            chars[index++] = c;
                        }
                    }
                    count = 1;
                }
            }

            chars[index++] = chars[n - 1];
            if (count > 1) {
                String countStr = Integer.toString(count);
                for (char c : countStr.toCharArray()) {
                    chars[index++] = c;
                }
            }

            return index;
        }
    }
    
}
