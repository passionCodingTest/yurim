package beakjoon;

//괄호 

import java.util.*;
public class Q9012 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		while(n > 0) {
			Stack<Character> st = new Stack<>();
			String vps = sc.next();
			for(int i = 0; i<vps.length(); i++) {
				if(vps.charAt(i)=='(') st.add(vps.charAt(i));
				else if(st.isEmpty() && vps.charAt(i)==')') {
					st.add(vps.charAt(i));
					break;
				}else {
					st.pop();
				}
			}
			if(st.isEmpty()) System.out.println("YES");
			else System.out.println("NO");
			n--;
		}

	}

}
