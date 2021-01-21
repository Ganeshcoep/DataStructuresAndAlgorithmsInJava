package leetcode;

import java.util.Stack;

public class LC20_ValidParentheses {

	public static void main(String[] args) {
		System.out.println(isValid("("));
		System.out.println(isValid(")"));
		
		System.out.println(isValid("()"));
		System.out.println(isValid("()()"));
		
		System.out.println(isValid("([])"));
		System.out.println(isValid("({}[])"));
	}
	
	public static boolean isValid(String s) {
        if(s == null || s.isEmpty()){
            return true;
        }
        
        Stack<Character> S = new Stack<>();
        
        for(Character c: s.toCharArray()){
            if(c == '(' || c == '{' || c == '['){
                S.push(c);
            } else if( !S.isEmpty() && ((c == ')'  && '(' == S.peek()) || (c == '}' && '{' == S.peek()) || (c == ']' && '[' == S.peek()))){
                S.pop();
            }else {
                return false;
            }
        }
        
        return S.isEmpty();
        
    }

}
