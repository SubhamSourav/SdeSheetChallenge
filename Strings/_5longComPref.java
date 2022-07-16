
public class _5longComPref {
    public static String longestCommonPrefix(String[] strs, int n) {
        if (n == 1)
            return strs[0];

        StringBuilder sb = new StringBuilder(strs[0].length());

        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            int irp = 1;
            while (irp < n) {
                if (i >= strs[irp].length() || c != strs[irp].charAt(i)) {
                    break;
                } else
                    irp++;
            }
            if (irp == n)
                sb.append(c);
            else
                break;
        }

        return sb.toString();
    }

}
