package beakjoon;
import java.util.*;
import java.io.*;
public class Q10942 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[] d = new int[N+1];
		boolean[][] dp = new boolean[N+1][N+1];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 1; i<=N; i++) {
			d[i] = Integer.parseInt(st.nextToken());
		}
		for(int i = 1; i<=N; i++) {
			dp[i][i] = true;
		}
		for(int i = 1; i<N; i++) {
			if(d[i] == d[i+1]) dp[i][i+1] = true;
			else dp[i][i+1] = false;
		}
		for(int k = 3; k<=N; k++) {
			for(int i = 1; i<= N-k+1; i++) {
				int j = i+k-1;
				if(d[i] == d[j] && dp[i+1][j-1]) dp[i][j] = true;
				else dp[i][j] = false;
			}
		}
		int M = Integer.parseInt(br.readLine());
		for(int i = 0; i<M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			bw.write(dp[a][b] ? "1\n" : "0\n");
		}
        bw.flush();
        bw.close();
        br.close();
	}
}
