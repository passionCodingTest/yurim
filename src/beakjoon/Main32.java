package beakjoon;

//1, 2, 3 더하기 3 : https://www.acmicpc.net/problem/15988

import java.io.*;
import java.util.*;

public class Main32 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int max = 1000000;
		long mod = 1000000009;
		int testCase = Integer.parseInt(br.readLine());
		long[] d = new long[max+1];
		for(int i = 1; i<=max; i++) {
			if(i >= 1) {
				if(i == 1) d[i] = 1;
				else d[i] += d[i-1];
			}
			if(i >= 2) {
				if(i == 2) d[i] = 2;
				else d[i] += d[i-2];
			}
			if(i >= 3) {
				if(i == 3) d[i] = 4;
				else d[i] += d[i-3];
			}
			
			d[i] %=mod;
		}
		
		for(int i = 0; i <testCase; i++) {
			int N = Integer.parseInt(br.readLine());
			bw.write(d[N]+"\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}

}
