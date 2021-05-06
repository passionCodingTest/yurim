package beakjoon;

import java.util.*;
public class Q9461 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		while(testCase > 0) {
			testCase--;
			int n = sc.nextInt();
			long[] d = new long[n+1];
			if(n < 4) {
				System.out.println("1");
				continue;
			}
			Arrays.fill(d,1,4,1);
			d[4] = 2;
			for(int i = 5; i<=n; i++) {
				d[i] = d[i-1]+d[i-5];
			}
			System.out.println(d[n]);
		}
		
	}
}
