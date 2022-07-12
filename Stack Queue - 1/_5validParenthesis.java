import java.util.Stack;

public class _5validParenthesis {
    public static boolean isValidParenthesis(String expression) {
        Stack<Character> s = new Stack<Character>();
        for (char ele : expression.toCharArray()) {
            if (ele == '(' || ele == '[' || ele == '{')
                s.push(ele);
            else {
                if (s.isEmpty())
                    return false;
                char ch = s.pop();
                if ((ele == ')' && ch == '(') || (ele == ']' && ch == '[') || (ele == '}' && ch == '{'))
                    continue;
                else
                    return false;
            }
        }
        return s.isEmpty();
    }
}