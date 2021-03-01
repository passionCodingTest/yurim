package beakjoon;

//연속합 : https://www.acmicpc.net/problem/1912

import java.io.*;
import java.util.*;

public class Main36 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] s = new int[N];
		long[] d = new long[N]; // 연속으로 더한 값
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		// 값 초기화 
		for(int i = 0; i<N; i++) {
			s[i] = Integer.parseInt(st.nextToken());
		}
		d[0] = s[0];
		for(int i = 1; i<N; i++) {
			d[i] = s[i];
			d[i] = Math.max(d[i], d[i-1]+s[i]);
		}
		
		long max = -1001;
		
		for(long p: d) {
			if(max < p ) max = p;
		}
		
		bw.write(max+"");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
