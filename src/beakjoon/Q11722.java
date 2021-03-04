package beakjoon;

//가장 긴 감소하는 부분 수열 : https://www.acmicpc.net/problem/11722

import java.io.*;
import java.util.*;

public class Q11722 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer s = new StringTokenizer(br.readLine(), " ");
		int[] a = new int[N];
		int[] d = new int[N];
		
		for(int i = 0; i<N; i++) {
			a[i] = Integer.parseInt(s.nextToken());
		}
		
		for(int i = 0; i < N; i++) {
			d[i] = 1;
			for(int j = 0; j<i; j++) {
				if(a[j] > a[i] && d[i] < d[j]+1) {
					d[i] =  d[j]+1;
				}
			}
		}
		
		int max = 1;
		for(int value : d) {
			if(max < value) max = value;
		}
		bw.write(max+"");
		bw.flush();
		bw.close();
		br.close();
	}

}
