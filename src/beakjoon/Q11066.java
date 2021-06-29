package beakjoon;
import java.io.*;
import java.util.*;
public class Q11066 {
	static int[] a ;
	static int[][] dp;
	static int go(int i , int j) {
		if(i==j) return 0;
		if(dp[i][j] != -1) return dp[i][j];
		int ans = -1;
		int sum = 0;
		for(int k=i; k<=j; k++) {
			sum += a[k];
		}
		for(int k = i; k<=j-1; k++) {
			int temp = go(i,k)+go(k+1, j)+sum;
			if(ans == -1 || ans > temp) ans = temp;
		}
		dp[i][j] = ans;
		return ans;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		while(tc-- > 0) {
			int K = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			a = new int[K+1];
			dp = new int[K+1][K+1];
			for(int i = 1; i<=K; i++) {
				a[i] = Integer.parseInt(st.nextToken());
				Arrays.fill(dp[i], -1);
			}
			System.out.println(go(1,K));
		}
	}
}
