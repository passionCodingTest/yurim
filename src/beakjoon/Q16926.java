package beakjoon;

//배열 돌리기 : https://www.acmicpc.net/problem/16926

import java.util.*;
import java.io.*;

public class Q16926 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int[][] d = new int[N][M];
		for(int i = 0; i<N; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j<M; j++) {
				d[i][j]= Integer.parseInt(st2.nextToken());
			}
		}
		
		ArrayList<ArrayList<Integer>> groups = new ArrayList<>();
		int groupn = Math.min(M, N)/2;
		for(int k = 0; k<groupn; k++) {
			ArrayList<Integer> group = new ArrayList<>();
			for(int j = k; j <M-k; j++) {
				group.add(d[k][j]);
			}
			for(int i=M-k-1; i > k; i++) {
				group.add(d[i][M-k-1]);
			}
			for(int j = M-k-1; j>k; j--) {
				group.add(d[N-k-1][j]);
			}
			for(int i = N-k-1; i>k; i--) {
				group.add(d[i][k]);
			}
			groups.add(group);
		}
		for(int k =0; k<groupn; k++) {
			ArrayList<Integer> group = groups.get(k);
			int len = group.size();
			int index = R%len;
			for(int j = k; j<M-k; j++, index=(index+1)%len) {
				d[k][j] = group.get(index);
			}
			for(int i = k+1; i<N-k-1; i++, index = (index+1)%len) {
				d[i][M-k-1] = group.get(index);
			}
			for(int j = M-k-1; j>k; j--, index = (index+1)%len) {
				d[N-k-1][j] = group.get(index);
			}
			for(int i=N-k-1; i>k; i--, index = (index+1)%len) {
				d[i][k] = group.get(index);
			}
		}
		for(int i = 0; i<N; i++) {
			for(int j = 0; j < M; j++) {
				bw.write(d[i][j]+" ");
			}
			bw.write("\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
