package beakjoon;

//15654번 - N과 M (5)

import java.util.*;
import java.io.*;

public class Main8 {
	static boolean[] c = new boolean[10000];
	static int[] a = new int[10];
	public static void main(String[] args) throws IOException {
		Main8 m = new Main8();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		
		for(int i = 0; i<N; i++) {
			arr[i] = Integer.parseInt(st2.nextToken());
		}
		
		Arrays.sort(arr);
		
		m.go(0, N, M, arr, bw);
		
		bw.flush();
		bw.close();
		br.close();
	}
	public void go(int index, int N, int M, int[] arr, BufferedWriter bw) throws IOException {
		if(index == M) {
			for(int i = 0; i<M; i++) {
				bw.write(a[i]+"");
				if(i != M-1) bw.write(" "); 
			}
			bw.write("\n");
			return;
		}
		for(int i = 0; i<N; i++) {
			if(c[arr[i]]) continue;
			c[arr[i]] = true; a[index] = arr[i];
			go(index+1, N, M, arr, bw);
			c[arr[i]] = false;
		}
	}
}
