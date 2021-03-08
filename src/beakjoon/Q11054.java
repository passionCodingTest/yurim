package beakjoon;

//가장 긴 바이토닉 부분 수열 : https://www.acmicpc.net/problem/11054

import java.io.*;
import java.util.*;

public class Q11054 {
	static int[] a ;
	static int[] d1 = new int[2000];
	static int[] d2 = new int[2000];
	static public void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer s = new StringTokenizer(br.readLine()," ");
		a = new int[N];
		for(int i = 0; i<N; i++) {
			a[i] = Integer.parseInt(s.nextToken());
		}
		//가장 긴 증가하는 수열  : start left
		for(int i = 0; i<N; i++) {
			d1[i] = 1;
			for(int j = 0; j<i; j++) {
				if(a[j] < a[i] && d1[i] < d1[j]+1) {
					d1[i] = d1[j]+1;
				}
			}
		}
		
		
		//가장 긴 감소하는 수열 : start right
		for(int i = N-1; i>=0; i--) {
			d2[i] = 1;
			for(int j = i+1; j<N; j++) {
				if(a[j] < a[i] && d2[i] < d2[j]+1) {
					d2[i] =  d2[j]+1;
				}
			}
		}
		
		int ans = d1[0]+d2[0]-1;
		for(int i = 0; i<N; i++) {
			if(ans < d1[i]+d2[i]-1) ans = d1[i]+d2[i]-1;
		}
		
		bw.write(ans+"");
		bw.flush();
		bw.close();
		br.close();
	}

}
