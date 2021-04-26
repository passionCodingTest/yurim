package beakjoon;

//그룹 단어 체커 

import java.util.*;
public class Q1316 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int answer = 0;
		int n = sc.nextInt();
		while(n > 0) {
			String str = sc.next();
			Stack<Character> st = new Stack<>();
			HashSet<Character> hs = new HashSet<>();
			boolean check = true;
 			for(int i = 0; i<str.length(); i++) {
				if(st.isEmpty()) st.add(str.charAt(i));
				else {
					if(st.peek() == str.charAt(i)) st.add(str.charAt(i));
					else {
						char c = st.pop();
						st.clear();
						st.add(str.charAt(i));
						if(!hs.add(c)) {
							check = false;
							break;
						}
					}
				}
			}
 			if(!st.isEmpty()) {
 				char c = st.pop();
 				if(!hs.add(c)) {
 					check = false;
 				}
 			}
			n--;
 			if(check) {
 	 			answer +=1;
 			}
		}
		System.out.println(answer);
	}

}
