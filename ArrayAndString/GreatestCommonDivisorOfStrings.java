class Solution {

    // reference implementation
    // public String gcdOfStrings(String str1, String str2) {
    // int str1Len = str1.length();
    // int str2Len = str2.length();
    // int gcdLen = gcd(str1Len, str2Len);
    // String c = str1.substring(0, gcdLen);
    // StringBuilder sb1 = new StringBuilder();
    // StringBuilder sb2 = new StringBuilder();
    // for (int i = 0; i < str1Len / gcdLen; i++) {
    // sb1.append(c);
    // }
    // for (int i = 0; i < str2Len / gcdLen; i++) {
    // sb2.append(c);
    // }
    // if (sb1.toString().equals(str1) && sb2.toString().equals(str2)) {
    // return c;
    // }
    // return "";
    // }

    //
    public String gcdOfStrings(String str1, String str2) {
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }
        return str1.substring(0, gcd(str1.length(), str2.length()));
    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}