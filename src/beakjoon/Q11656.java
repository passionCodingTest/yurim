package beakjoon;

import java.util.*;
public class Q11656 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		StringBuilder sb = new StringBuilder(str);
		String[] arr = new String[str.length()];
		for(int i = 0; i<str.length(); i++) {
			arr[i] = sb.substring(i);
		}
		Arrays.sort(arr);
		for(String s : arr) {
			System.out.println(s);
		}
	}
}
