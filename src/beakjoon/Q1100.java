package beakjoon;

import java.util.*;
public class Q1100 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cnt = 0;
		for(int i = 0; i<8; i++) {
			String str = sc.next();
			for(int j = 0; j<8; j++) {
				if((i+1)%2==1 && (j+1)%2==1 || (i+1)%2==0 && (j+1)%2==0) {
					if(str.charAt(j)=='F') cnt +=1;
				}
			}
		}
		System.out.println(cnt);
	}
}
