package beakjoon;


import java.util.*;
public class Q11399 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] d = new int[n];
		for(int i = 0; i<n; i++) {
			d[i] = sc.nextInt();
		}
		Arrays.sort(d);
		int sum = d[0];
		for(int i = 1; i<n; i++) {
			d[i] +=d[i-1];
			sum += d[i];
		}
		System.out.println(sum);
	}
}
