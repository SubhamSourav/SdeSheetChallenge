public class Solution {
    public static boolean findPattern(String pattern, String text) {
        int n = text.length(), m = pattern.length();

        int[] pArray = new int[m];

        pArray[0] = 0;
        int i = 1, j = 0;

        while (i < m) {
            if (pattern.charAt(i) == pattern.charAt(j)) {
                pArray[i] = j + 1;
                i++;
                j++;
            } else {
                if (j == 0) {
                    pArray[i] = 0;
                    i++;
                } else {
                    j = pArray[j - 1];
                }
            }
        }

        i = 0;
        j = 0;

        while (i < n) {
            if (text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
                if (j == m)
                    return true;
            } else {
                if (j == 0)
                    i++;
                else {
                    j = pArray[j - 1];
                }
            }
        }
        return false;
    }
}