package beakjoon;

//합분해 : https://www.acmicpc.net/problem/2225

import java.io.*;
import java.util.*;
public class Main38 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		long mod = 1000000000;
		long[][] d = new long[K+1][N+1];
		d[0][0] = 1;
		for(int i = 1; i<=K; i++) {
			for(int j = 0; j<=N; j++) {
				for(int l = 0; l <= j; l++) {
					d[i][j] += d[i-1][j-l];
					d[i][j] %= mod;
				}
			}
		}
		
		bw.write(d[K][N]+"");
		
		bw.flush();
		bw.close();
		br.close();
		
	}

}
