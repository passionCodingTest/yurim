package beakjoon;

//Java vs C++

import java.util.*;
public class Q3613 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		StringBuffer sb = new StringBuffer();
		if(input.contains("_")) {
			if(cppCheck(input)) {
				for(int i = 0; i<input.length(); i++) {
					if(input.charAt(i)=='_') {
						sb.append((input.charAt(i+1)+"").toUpperCase());
						i++;
					}else {
						sb.append((input.charAt(i)+""));
					}
				}
			}
			else {
				System.out.println("Error!");
			}
		}else {
			if(javaCheck(input)) {
				for(int i = 0; i<input.length(); i++) {
					if((input.charAt(i)+"").matches(".*[A-Z].*")) {
						sb.append("_");
						sb.append((input.charAt(i)+"").toLowerCase());
					}else {
						sb.append((input.charAt(i)+""));
					}
				}
			}
			else {
				System.out.println("Error!");
			}
		}
		System.out.println(sb.toString());
	}
	static public boolean javaCheck(String str) {
		if((str.charAt(0)+"").matches(".*[A-Z].*")) return false;
		return true;
	}
	
	static public boolean cppCheck(String str) {
		if(str.charAt(0)=='_' || str.charAt(str.length()-1) == '_' || str.contains("__")) {
			return false;
		}
		if(str.matches(".*[A-Z].*")) return false;
		return true;
	}
}
