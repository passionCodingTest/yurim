package beakjoon;

import java.util.*;
public class Q2230 {
	static int min = 2000000000;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(), m = sc.nextInt(), i = 0, left = 0, right = 0;
		int[] d = new int[n];
		while(i < n) d[i++] = sc.nextInt();
		Arrays.sort(d);
		while(left < n && right < n) {
			int ans = d[right]-d[left];
			if(min > ans && ans >= m) {
				min = ans;
			}
			if(ans > m) left++;
			else right++;
		}
		System.out.println(Math.abs(min));
	}
}
