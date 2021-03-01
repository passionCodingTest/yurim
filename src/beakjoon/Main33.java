package beakjoon;

//RGB거리 : https://www.acmicpc.net/problem/1149

import java.io.*;
import java.util.*;

public class Main33 {

	public static void main(String[] args) throws IOException {
		// i = 집 번호 ,j 색번호 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine()); //집 
		// 0: 빨강 , 1: 초록 , 2: 파랑
		int[][] p = new int[N][3];
		int[][] d = new int[N][3];
		
		for(int i = 0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < 3; j++) {
				p[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i<3; i++) {
			d[0][i] = p[0][i];
		}
		
		for(int i = 1; i<N; i++) {
			d[i][0] = Math.min(d[i-1][1], d[i-1][2])+p[i][0];
			d[i][1] = Math.min(d[i-1][0], d[i-1][2])+p[i][1];
			d[i][2] = Math.min(d[i-1][0], d[i-1][1])+p[i][2];
		}
		
		int maxValue = Math.min(d[N-1][0], Math.min(d[N-1][1], d[N-1][2]));
		
		bw.write(maxValue+"");
		
		bw.flush();
		bw.close();
		br.close();
	}

}
