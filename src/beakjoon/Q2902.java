package beakjoon;

import java.util.*;
public class Q2902 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String email = sc.next();
		for(int i = 0; i<email.length(); i++) {
			if(email.charAt(i) >= 'A' && email.charAt(i) <= 'Z' ) System.out.print(email.charAt(i));
		}
		System.out.println();
		return ;
	}
}
