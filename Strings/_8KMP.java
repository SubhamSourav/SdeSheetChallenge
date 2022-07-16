
public class Solution {

    public static int minCharsforPalindrome(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append('$');

        for (int i = str.length() - 1; i >= 0; i--) {
            sb.append(str.charAt(i));
        }

        int pArray[] = new int[sb.length()];
        int i = 1, j = 0;

        pArray[0] = 0;

        while (i < sb.length()) {
            if (sb.charAt(i) == sb.charAt(j)) {
                pArray[i] = j + 1;
                i++;
                j++;
            } else {
                if (j == 0) {
                    pArray[i] = 0;
                    i++;
                } else
                    j = pArray[j - 1];
            }
        }

        return str.length() - pArray[sb.length() - 1];
    }

}