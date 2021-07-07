package beakjoon;

import java.util.*;
public class Q2631 {
	static int max = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] children = new int[n];
		int[] dp = new int[n];
		while(--n >= 0 ) {
			children[n] = sc.nextInt();
		}
		for(int i = 0; i<children.length; i++) {
			dp[i] = 1;
			for(int j = 0; j<i; j++) {
				if(children[i] < children[j] && dp[j] + 1 > dp[i] ) dp[i] = dp[j]+1;
			}
			max = Math.max(max, dp[i]);
		}
		System.out.println(children.length-max);
	}

}
