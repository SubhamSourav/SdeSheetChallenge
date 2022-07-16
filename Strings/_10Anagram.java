public class Solution {
    public static boolean areAnagram(String str1, String str2) {
        if (str1.length() != str2.length())
            return false;
        int n = str1.length();
        int[] c = new int[256];

        for (int i = 0; i < n; i++) {
            c[str1.charAt(i)]++;
            c[str2.charAt(i)]--;
        }

        for (int i = 0; i < 256; i++) {
            if (c[i] != 0)
                return false;
        }

        return true;
    }
}