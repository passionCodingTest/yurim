package beakjoon;

//정수 삼각형 : https://www.acmicpc.net/problem/1932

import java.io.*;
import java.util.*;

public class Main40 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		long[][] s = new long[N][N];
		long[][] dp = new long[N][N];
		
		for(int i = 0; i <N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j<=i; j++) {
				s[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dp[0][0] = s[0][0];
		
		for(int i = 1; i<N; i++) {
			dp[i][0] = dp[i-1][0]+s[i][0];
			dp[i][i] = dp[i-1][i-1]+s[i][i];
		}
		
		for(int i = 2; i<N; i++) {
			for(int j = 1; j<i; j++ ) {
				dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j])+s[i][j];
			}
		}
		
		long max = 0;
		
		for(int i = 0; i<N; i++) {
			if(max < dp[N-1][i]) max = dp[N-1][i];
		}
		
		bw.write(max+"");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
