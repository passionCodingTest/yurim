package beakjoon;

import java.util.*;
public class Q1904 {
	static int mod = 15746;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] d = new int[n+1];
		d[0] = 1;
		d[1] = 1;
		for(int i = 2; i<=n ;i++) {
			d[i] = (d[i-1]+d[i-2])%mod;
		}
		System.out.println(d[n]);
	}
}
