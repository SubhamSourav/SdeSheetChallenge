import java.util.*;

public class _3romToInt {
    public static int romanToInt(String s) {
        Map<Character, Integer> symbol = new HashMap<>();

        symbol.put('I', 1);
        symbol.put('V', 5);
        symbol.put('X', 10);
        symbol.put('L', 50);
        symbol.put('C', 100);
        symbol.put('D', 500);
        symbol.put('M', 1000);

        int n = s.length();
        int no = symbol.get(s.charAt(n - 1));
        for (int i = n - 2; i >= 0; i--) {
            if (symbol.get(s.charAt(i)) >= symbol.get(s.charAt(i + 1))) {
                no += symbol.get(s.charAt(i));
            } else {
                no -= symbol.get(s.charAt(i));
            }
        }
        return no;
    }
}