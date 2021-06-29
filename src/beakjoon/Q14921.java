package beakjoon;

import java.util.*;
public class Q14921 {
	static int min = 200000000;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] data = new int[n];
		int left=0, right = n-1, i = 0;
		while(i < n) {
			data[i++] = sc.nextInt();
		}
		while(left < right) {
			int ans = data[left]+data[right];
			if(Math.abs(min) > Math.abs(ans)) {
				min = ans;
			}
			if(ans > 0) right--;
			else left++;
		}
		System.out.println(min);
	}
}
