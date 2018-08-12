package Stack;
import java.util.Stack;

public class ValidParentheses {
    //No.423:Valid Parentheses;
    public boolean isValidParentheses(String s) {
        Stack<Character> res = new Stack<>();
        if(s.length() % 2 != 0) {
            return false;
        }
        for(int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            if(res.empty()) {
                res.push(temp);
                continue;
            }
            if(temp == '(' || temp == '[' || temp == '{') {
                res.push(temp);
            } else {
                if(temp == ')') {
                    if(res.pop() != '(') {
                        return false;
                    }
                } else if(temp == '}') {
                    if(res.pop() != '{') {
                        return false;
                    }
                } else if(temp == ']') {
                    if(res.pop() != '[') {
                        return false;
                    }
                }
            }
        }
        if(!res.empty()) {
            return false;
        }
        return true;
    }
}
