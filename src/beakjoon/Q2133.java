package beakjoon;

//타일 채우기 : https://www.acmicpc.net/problem/2133

import java.io.*;
import java.util.*;
public class Q2133 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int[] D = new int[N+1];
		D[0] = 1;
		for(int i = 2; i<=N; i++) {
			D[i] = 3*D[i-2];
			for(int j = i-4; j>=0; j -=2) {
				D[i] += 2*D[j];
			}
		}
		
		bw.write(D[N]+"");
		
		bw.flush();
		bw.close();
		br.close();
	}

}
