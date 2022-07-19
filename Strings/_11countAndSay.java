public class _11countAndSay {
    public static String writeAsYouSpeak(int n) {
        if (n == 1)
            return "1";
        if (n == 2)
            return "11";
        StringBuilder sb = new StringBuilder("11");
        for (int i = 3; i <= n; i++) {
            StringBuilder temp = new StringBuilder();
            sb.append('$');
            int c = 1;
            for (int j = 1; j < sb.length(); j++) {
                if (sb.charAt(j) != sb.charAt(j - 1)) {
                    temp.append(c).append(sb.charAt(j - 1));
                    c = 1;
                } else
                    c++;
            }
            sb = temp;
        }
        return sb.toString();
    }
}