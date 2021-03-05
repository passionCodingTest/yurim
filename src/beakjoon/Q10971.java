package beakjoon;

//외판원 순회 2 : https://www.acmicpc.net/problem/10971

import java.io.*;
import java.util.*;
public class Q10971 {
	static int ans = Integer.MAX_VALUE;
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int[] d = new int[N];
		int[][] w = new int[N][N];
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for(int j = 0; j<N; j++) {
				w[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i = 0; i<N; i++) {
			d[i] = i;
		}
		
		do {
			if(d[0] != 0) break;
			boolean ok = true;
			int sum = 0;
			for(int i = 0; i<N-1; i++) {
				if(w[d[i]][d[i+1]] == 0) {
					ok = false;
				}else {
					sum +=w[d[i]][d[i+1]];
				}
			}
			if(ok&&w[d[N-1]][d[0]] != 0) {
				sum += w[d[N-1]][d[0]];
				if(ans > sum) ans = sum;
			}
			
		}while(next_permutation(d));
		
		bw.write(ans+"");
		bw.flush();
		bw.close();
		br.close();

	}
	static boolean next_permutation(int[] a) {
		int i = a.length-1;
		while(i > 0 && a[i-1] >= a[i]) i-=1;
		if(i<=0) return false;
		int j = a.length-1;
		while(a[j] <= a[i-1]) j -=1;
		int temp = a[i-1];
		a[i-1] = a[j];
		a[j] = temp;
		
		j = a.length-1;
		while(i < j) {
			temp = a[i];
			a[i] = a[j];
			a[j] = temp;
			i+=1;
			j-=1;
		}
		return true;
	}

}
