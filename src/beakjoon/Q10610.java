package beakjoon;

import java.util.*;
public class Q10610 {
	static String[] d;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String n = sc.next();
		int[] digits = new int[10];
		int num, sum = 0;
		for(int i = 0 ; i<n.length(); i++) {
			num = n.charAt(i)-'0';
			sum +=num;
			digits[num]++;
		}
		if(digits[0] == 0 || sum%3 != 0) {
			System.out.println("-1");
			return;
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 9; i>= 0; i--) {
			while(digits[i]-- > 0) {
				sb.append(i);
			}
		}
		System.out.println(sb.toString());
	}
}
