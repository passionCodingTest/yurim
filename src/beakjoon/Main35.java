package beakjoon;

//오르막 수 : https://www.acmicpc.net/problem/11057

import java.io.*;
import java.util.*;

public class Main35 {

	public static void main(String[] args) throws IOException {
		Main35 m = new Main35();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		// i 계단 길이 ,j 마지막 수 0도 포함 
		
		int N = Integer.parseInt(br.readLine());
		
		long[][] d = new long[N+1][10];
		
		
		for(int i = 0; i<10; i++) {
			d[1][i] = 1;
		}
		
		for(int i = 2; i<=N; i++) {
			for(int j = 0; j <10; j++) {
				m.go(d, i, j);
			}
		}
		
		int sum = 0;
		
		for(int i = 0; i<10; i++) {
			sum += d[N][i];
		}
		
		bw.write(sum%10007+"");
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	public void go(long[][] d, int i, int j) {
		for(int k = 0; k <= j; k++) {
			d[i][j] += d[i-1][k];
		}
		
		d[i][j] %= 10007;
	}

}
