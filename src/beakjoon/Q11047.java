package beakjoon;

import java.util.*;
public class Q11047 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int sum = sc.nextInt();
		int[] A = new int[a];
		int cnt = 0;
		for(int i = 0; i<a; i++) {
			A[i] = sc.nextInt();
		}
		for(int i = a-1; i>=0; i--) {
			if(sum - A[i] >= 0) {
				sum -= A[i];
				i++;
				cnt++;
			}
			if(sum == 0) break;
		}
		System.out.println(cnt);
	}

}
