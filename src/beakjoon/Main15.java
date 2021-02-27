package beakjoon;

//1로 만들기 : https://www.acmicpc.net/problem/1463

import java.util.*;

public class Main15 {
	static int[] d = new int[1000001];
	public static void main(String[] args) {
		Main15 m = new Main15();
		Scanner sc = new Scanner(System.in);
		d[1] = 0;
		int n = sc.nextInt();
		
		int result = m.go(n);
		
		System.out.println(result);

	}
	
	public int go(int n) {
		if(n == 1) {
			return 0;
		}
		
		if(d[n] > 0) {
			return d[n];
		}

		d[n] = go(n-1) + 1;
		
		if(n%2 == 0) {
			int temp = go(n/2)+1;
			if(d[n] > temp) d[n] = temp;
		}
		
		if(n%3 == 0) {
			int temp = go(n/3)+1;
			if(d[n] > temp) d[n] = temp;
		}
		
		return d[n];
	}

}
