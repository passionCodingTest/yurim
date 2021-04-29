package beakjoon;

import java.util.*;
public class Q1032 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		StringBuilder sb = null ;
		for(int i = 0; i<n; i++) {
			if(i == 0) {
				sb = new StringBuilder(sc.next());
				continue;
			}
			String str = sc.next();
			for(int j = 0; j<str.length(); j++) {
				if(sb.charAt(j)!=str.charAt(j)) {
					sb.setCharAt(j, '?');
				}
			}
		}
		System.out.println(sb.toString());
	}

}
