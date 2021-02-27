package beakjoon;

//1, 2, 3 더하기 5 : https://www.acmicpc.net/problem/15990

import java.util.*;
import java.io.*;
public class Main25 {
	static long mod = 1000000009;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine().trim());
		long[][] d = new long[100001][4];
		
		for(int i = 0; i<d.length; i++) {
			if(i == 1) d[i][1] = 1; 
			if(i < 1 ) d[i][1] = 0; 
			if(i > 1 ) d[i][1] = d[i-1][2] + d[i-1][3];
			
			if(i == 2) d[i][2] = 1;
			if(i < 2) d[i][2] = 0;
			if(i > 2 ) d[i][2] = d[i-2][1] + d[i-2][3];
			
			if(i == 3) d[i][3] = 1;
			if(i < 3) d[i][3] = 0;
			if(i > 3 ) d[i][3] = d[i-3][1] + d[i-3][2];
			
			d[i][1] %=mod;
			d[i][2] %=mod;
			d[i][3] %=mod;
		}
		
		for(int i = 0; i<T; i++) {
			int N = Integer.parseInt(br.readLine().trim());
			bw.write((d[N][1]+d[N][2]+d[N][3])%mod+"\n");
		}
		
		bw.flush();
		bw.close();
		br.close();

	}

}
