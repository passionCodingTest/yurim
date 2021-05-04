package beakjoon;

import java.util.*;
public class Q2798 {
	static int[] num;
	static int m,n,answer;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		num = new int[n];
		answer = 0;
		for(int i = 0; i<n; i++) {
			num[i] = sc.nextInt();
		}
		backjack(0,0,0);
		System.out.println(answer);
	}
	
	static public void backjack(int index, int sum, int cnt) {
		if(sum > m) return;
		if(index>=n && cnt < 3) return;
		if(cnt==3) {
			if(Math.abs(m-sum) < Math.abs(m-answer)) answer = sum;
			return;
		}
		backjack(index+1,sum+num[index], cnt+1);
		backjack(index+1, sum, cnt);
	}

}
