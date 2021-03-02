package beakjoon;

//포도주 시식 : https://www.acmicpc.net/problem/2156

import java.io.*;
import java.util.*;

public class Main39 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int[] a = new int[N+1];
		long[] d = new long[N+1];
		for(int i = 1; i<N; i++) {
			a[i] = Integer.parseInt(br.readLine());
		}
		
		d[1] = a[1];
		d[2] = a[1] + a[2];
		
		for(int i = 3; i<=N; i++) {
			d[i] = a[i];
			if(d[i] < d[i-2]+a[i]) { //현재와 전 전잔 
				d[i] = d[i-2] + a[i];
			}
			if(d[i] < d[i-3] + a[i] + a[i-1]) {//현재와 전전전  전잔 
				d[i] = d[i-3] + a[i] + a[i-1];
			}
		}
		
		bw.write("");
		
		bw.flush();
		bw.close();
		br.close();
		
	}

}
