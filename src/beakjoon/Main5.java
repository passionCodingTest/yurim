package beakjoon;

//N과 M (2)

import java.util.*;

public class Main5 {
	public static boolean[] c = new boolean[10];
	public static int[] a = new int[10];
	public static void main(String[] args) {
		Main5 m = new Main5();
		Scanner sc = new Scanner(System.in);
		
		int range = sc.nextInt();
		int count = sc.nextInt();
		
		m.go(0, 1, range, count);
	}
	
	public void go(int index, int start, int n, int m) {
		if(index == m) {
			for(int i = 0; i<m; i++) {
				System.out.print(a[i]);
				if(i != m-1) System.out.print(" ");
			}
			System.out.println();
			return;
		}
		for(int i = start; i<=n; i++) {
			if(c[i]) continue;
			c[i]=true;
			a[index] = i;
			go(index+1, i+1, n, m);
			c[i]=false;
		}
		
	}

}
