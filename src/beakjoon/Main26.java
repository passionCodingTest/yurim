package beakjoon;

//쉬운 계단 수 : https://www.acmicpc.net/problem/10844

import java.io.*;

public class Main26 {
	static long mod = 1000000000;
	static long ans = 0;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine().trim());
		long[][] d = new long[N+1][11];
		d[1][0] = 0;
		for(int i = 1; i<10; i++) {
			d[1][i] = 1;
		}
		
		for(int i = 2; i<=N; i++) {
			for(int j = 0; j<10; j++) {
				if(j-1 >= 0) d[i][j] += d[i-1][j-1];
				if(j+1 <= 9) d[i][j] += d[i-1][j+1];
				
				d[i][j] %=mod;
			}
		}
		
		for(int i = 0; i<10; i++) {
			ans += d[N][i];
		}
		
		ans %=mod;
		
		bw.write(ans+"");
		
		bw.flush();
		bw.close();
		br.close();
		
	}

}
