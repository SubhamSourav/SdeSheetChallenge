public class _4impATOI {
    public static int atoi(String str) {
        int sign = 1, no = 0, n = str.length(), i = 0;

        if (str.charAt(0) == '-') {
            sign = -1;
            i++;
        }

        while (i < n) {
            int as = str.charAt(i) - '0';
            if (as >= 0 && as <= 9) {
                no *= 10;
                no += as;
            }
            i++;
        }

        return no * sign;
    }
}
