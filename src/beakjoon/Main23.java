package beakjoon;

// 이동하기 : https://www.acmicpc.net/problem/11048

import java.util.*;
import java.io.*;

public class Main23 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer NM = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(NM.nextToken()); // y 축 
		int M = Integer.parseInt(NM.nextToken()); // x 축 
		
		int[][] location = new int[N][M];
		
		for(int i = 0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j<M; j++) {
				location[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		for(int i = 1; i<N; i++) {
			location[i][0] += location[i-1][0];
		}
		
		for(int i = 1; i<M; i++) {
			location[0][i] += location[0][i-1];
		}
		
		
		for(int i = 1; i<N; i++) {
			for(int j = 1; j<M; j++) {
				location[i][j] = Math.max(location[i][j]+location[i-1][j], location[i][j]+location[i][j-1]);
			}
		}
		
		System.out.println(location[N-1][M-1]);
	
	}

}
