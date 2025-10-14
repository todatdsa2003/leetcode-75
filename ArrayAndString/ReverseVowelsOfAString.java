class Solution {
        // Check if a character is a vowel
        private boolean isVowel(char c) {
            return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
                    c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
        }

        public String reverseVowels(String s) {
            char[] chars = s.toCharArray();
            int left = 0;
            int right = chars.length - 1;

            while (left < right) {

                while (left < right && !isVowel(chars[left])) {
                    left++;
                }
                while (left < right && !isVowel(chars[right])) {
                    right--;
                }

                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;

                left++;
                right--;
            }
            return new String(chars);
        }
    }