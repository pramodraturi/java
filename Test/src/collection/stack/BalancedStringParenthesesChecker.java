package collection.stack;

import java.util.Stack;

public class BalancedStringParenthesesChecker {
	
	public static void main(String[] args) {
		
		Stack<Boolean> stack = new Stack<>();
		String inputString = "(A+B)+C*(A+B+C)+(A*B)";
		//String inputString = " ((A+B)+C*(A+B+C)+(A*B)";
		
		for(Character character: inputString.toCharArray()) {
			if(character.equals('(')) {
				stack.push(true);
			}else if(character.equals(')')){
				stack.pop();
			}
		}
		
		if(stack.isEmpty()) {
			System.out.println("String is Properly Parenthesized");
		}else {
			System.out.println("Mismatch found in string parentheses.");
		}
	}

}
