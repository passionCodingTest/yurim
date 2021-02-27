package beakjoon;

//카드 구매하기 : https://www.acmicpc.net/problem/11052

import java.io.*;
import java.util.*;
public class Main22 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine().trim());
		int[] d = new int[1001];
		int[] p = new int[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		for(int i = 1; i<=N; i++) {
			p[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 1; i<= N; i++) {
			for(int j =1; j<=i; j++) {
				d[i] = Math.max(d[i], d[i-j] + p[j]);
			}
		}
		
		bw.write(d[N]+"");
		
		bw.flush();
		bw.close();
		br.close();

	}

}
