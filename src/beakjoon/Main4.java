package beakjoon;

//N과 M (1)

import java.io.*;
import java.util.*;

public class Main4 {
	public static boolean[] c = new boolean[10];
	public static int[] a = new int[10];
	public static void main(String[] args) {
		Main4 m = new Main4();
        Scanner sc = new Scanner(System.in);
        int range = sc.nextInt();
        int count = sc.nextInt();
       
        m.go(0, range, count);
	}
	public void go(int index, int n, int m) {
		if(index == m) {
			for(int i=0; i<m; i++ ) {
				System.out.print(a[i]);
				if(i != m-1) System.out.print(" ");
			}
			System.out.print("\n");
			return;
		}
		for(int i = 1; i<=n; i++) {
			if(c[i]) continue;
			c[i] = true; 
			a[index] = i;
			go(index+1, n ,m);
			c[i] = false;
		}
	}

}
