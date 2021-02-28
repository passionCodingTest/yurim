package beakjoon;

//가장 긴 증가하는 부분 수열 4 : https://www.acmicpc.net/problem/14002;

import java.io.*;
import java.util.*;

public class Main29 {
	static int[] arr;
	static int[] d;
	static int[] v;
	public static void main(String[] args) throws IOException {
		Main29 m = new Main29();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		arr = new int[N];
		d = new int[N];
		v = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		for(int i = 0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i<N; i++) {
			d[i] = 1;
			v[i] = -1;
			for(int j = 0; j<i; j++) {
				if(arr[j] < arr[i] && d[i] < d[j]+1) {
					d[i] = d[j]+1;
					v[i] = j;
				}
			}
		}
		
		int ans = d[0];
		int p = 0;
		
		for(int i = 0; i<N; i++) {
			if(ans < d[i]) {
				ans = d[i];
				p = i;
			}
		}
		
		bw.write(ans+"\n");
		m.go(p, bw);
		
		bw.flush();
		bw.close();
		br.close();
		
	}
	
	public void go(int p , BufferedWriter bw) throws IOException {
		if(p == -1 ) return ;
		go(v[p], bw);
		bw.write(arr[p]+" ");
	}

}
