package beakjoon;

import java.util.*;
public class Q4949 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = "";
		Stack<Character> st = new Stack<>();
		while(!(str=sc.nextLine()).equals(".")) {
			boolean check = false;
			for(int i = 0; i<str.length(); i++) {
				if(str.charAt(i)=='.') {
					if(!st.isEmpty() || check) {
						System.out.println("no");
						st.clear();
					}
					else {
						System.out.println("yes");
					}
					check = false;
				}
				if(check) continue;
				if(str.charAt(i) == '[' || str.charAt(i) == '(' ) {
					st.add(str.charAt(i));
				}else if(str.charAt(i)==']' || str.charAt(i)==')'){
					if(!st.isEmpty() && balanceCheck(st.peek(),str.charAt(i))) {
						st.pop();
						continue;
					}else {
						check = true;
					}
				}
				
			}
		}
	}
	static public boolean balanceCheck(char a, char b) {
		if(a == '(' && b == ')' || a == '[' && b == ']') return true;
		else return false;
	}

}
