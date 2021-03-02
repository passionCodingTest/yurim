package beakjoon;

//정수 삼각형 : https://www.acmicpc.net/problem/1932

import java.io.*;
import java.util.*;

public class Main41 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		long[][] s = new long[N][N];
		
		for(int i = 0; i <N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j<=i; j++) {
				s[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = N-1; i >= 0; i--) {
			for(int j = 0; j<=i; j++) {
				if(i == N-1) s[i][j] = s[i][j];
				else s[i][j] = Math.max(s[i+1][j], s[i+1][j+1])+s[i][j];
			}
		}
		
		bw.write(s[0][0]+"");
		bw.flush();
		bw.close();
		br.close();
	}

}
