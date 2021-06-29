package beakjoon;

import java.util.*;
public class Q2467 {
	static int[] d ;
	static int minLeft = 0, minRight = 0, min = 2000000000;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		d = new int[n];
		int left = 0, right = n-1;
		int i = 0;
		while(i < n) {
			d[i++] = sc.nextInt();
		}
		while(left < right) {
			int ans = d[left]+d[right];
			if(min > Math.abs(ans)) {
				min = Math.abs(ans);
				minLeft = d[left];
				minRight = d[right];
			}
			if(ans > 0) right--;
			else left++;
		}
		System.out.println(minLeft+" "+minRight);
	}

}
