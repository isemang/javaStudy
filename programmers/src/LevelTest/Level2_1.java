package levelTest;

import java.util.Stack;

public class Level2_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(solution(")()("));
	}
	
	static boolean solution(String s) {
        boolean answer = true;
        String[] str = s.split("");
        Stack<String> stack = new Stack<>();
        
        for (int i=0; i<str.length; i++){
            if(str[i].equals("(")) stack.add(str[i]);
            if(str[i].equals(")")) {
            	if(stack.size() != 0) stack.pop();
            	else {
            		answer = false;
            		break;
            	}
            }
        }
        if(stack.size() != 0) answer = false;
        return answer;
    }
}
