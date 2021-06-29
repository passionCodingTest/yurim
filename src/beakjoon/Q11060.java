package beakjoon;
import java.util.*;
public class Q11060 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] a = new int[N];
		int[] dp = new int[N];
		Arrays.fill(dp, -1);
		for(int i = 0; i<N; i++) a[i] = sc.nextInt();
		dp[0] = 0;
		for(int i = 1; i<N; i++) {
			for(int j = 0; j< i; j++) {
				if(dp[j] != -1 && i-j <= a[j]) {
					if(dp[i] == -1 || dp[i] > dp[j]+1) {
						dp[i] = dp[j]+1;
					}
				}
			}
		}
		System.out.println(dp[N-1]);
	}
}
