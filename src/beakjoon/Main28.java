package beakjoon;
//가장 긴 증가하는 부분 수열 : https://www.acmicpc.net/problem/11053

import java.io.*;
import java.util.*;

public class Main28 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] d = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		for(int i = 0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i<N; i++ ) {
			d[i] = 1;
			for(int j = 0; j<i; j++) {
				if(arr[j] < arr[i] && d[i] < d[j]+1) {
					d[i] = d[j]+1;
				}
			}
		}
		
		int max =0;
		
		for(int value : d ) {
			if(max < value) max = value;
		}
		
		bw.write(max+"");
		
		bw.flush();
		bw.close();
		br.close();
	}

}
