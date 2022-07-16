import java.lang.*;

public class _1revWords {
    public static String reverseString(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        int i = n - 1;

        while (i >= 0) {

            while (i >= 0 && s.charAt(i) == ' ')
                i--;

            if (i < 0)
                break;

            int j = i - 1;
            while (j >= 0 && s.charAt(j) != ' ')
                j--;

            sb.append(s.substring(j + 1, i + 1));
            sb.append(" ");
            i = j;
        }

        return sb.toString();
    }
}
