package beakjoon;

//열 개씩 끊어 출력하기

import java.util.*;
public class Q11721 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		while(str.length() > 0) {
			if(str.length() > 9) {
				System.out.println(str.substring(0,10));
				str = str.substring(10);
			}else {
				System.out.println(str);
				break;
			}
		}
	}
}
