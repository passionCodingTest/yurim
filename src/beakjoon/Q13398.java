package beakjoon;

//연속합 2 : https://www.acmicpc.net/problem/13398

import java.io.*;
import java.util.*;
public class Q13398 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer s = new StringTokenizer(br.readLine()," ");
		int[] A = new int[N];
		int[] DL = new int[N];
		int[] DR = new int[N];
		for(int i = 0; i<N; i++) {
			A[i] = Integer.parseInt(s.nextToken());
		}
		for(int i = 0; i<N; i++) {
			DL[i] = A[i];
			if(i > 0 && DL[i] < DL[i-1]+A[i]) DL[i] = DL[i-1] +A [i];
 		}
		for(int i = N-1; i>=0; i--) {
			DR[i] = A[i];
			if(i < N-1 && DR[i] < DR[i+1]+A[i]) DR[i] = DR[i+1]+A[i];
		}
		
		int ans = DL[0];
		for(int i = 0; i<N; i++) {
			if(ans < DL[i]) ans = DL[i];
		}
		for(int i = 1 ; i<N-1; i++) {
			if(ans < DL[i-1]+DR[i+1]) ans = DL[i-1]+DR[i+1];
		}
		bw.write(ans+"");
		bw.flush();
		bw.close();
		br.close();
	}

}
