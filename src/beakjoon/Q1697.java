package beakjoon;

//숨박꼭질 : https://www.acmicpc.net/problem/1697

import java.io.*;
import java.util.*;

public class Q1697 {
	public static void main(String[] args) throws IOException {
		Queue<Integer> queue = new LinkedList<Integer>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int MAX = 200000;
		
		boolean[] check = new boolean[MAX];
		int[] dist = new int[MAX];
		check[N] = true;
		dist[N] = 0;
		queue.add(N);
		while(!queue.isEmpty()) {
			int now = queue.remove();
			if(now-1 >= 0) {
				if(check[now-1] == false) {
					queue.add(now-1);
					check[now-1] = true;
					dist[now-1] = dist[now]+1;
				}
			}
			
			if(now+1 < MAX) {
				if(check[now+1] ==false) {
					queue.add(now+1);
					check[now+1] = true;
					dist[now+1] = dist[now]+1;
				}
			}
			
			if(now*2 < MAX) {
				if(check[now*2] == false) {
					queue.add(now*2);
					check[2*now] = true;
					dist[2*now] = dist[now]+1;
				}
			}
		}
		bw.write(dist[K]+"");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
