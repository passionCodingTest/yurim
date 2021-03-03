package beakjoon;

//알고스팟 : https://code.plus/course/51
//DP로 풀어봤음 = 실패 

import java.io.*;
import java.util.StringTokenizer;

public class Q1261_2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		int[][] G = new int[N][M];
		for(int i = 0; i < N; i++) {
			String[] st2 = (br.readLine()).split("");
			for(int j = 0; j<M; j++) {
				G[i][j] = Integer.parseInt(st2[j]);
			}
		}
		
		for(int i=0; i<N; i++) {
			if(i+1 < N) G[0][i+1] += G[0][i];
		}
		for(int i = 0; i<M; i++) {
			if(i+1 < M) G[0][i+1] +=G[0][i];
		}
		
		for(int i = 1; i<N; i++) {
			for(int j = 1; j<M; j++) {
				G[i][j] = Math.min(G[i-1][j], G[i][j-1])+G[i][j];
			}
		}
		
		bw.write(G[N-1][M-1]+"");
		bw.flush();
		bw.close();
		br.close();
	}

}
