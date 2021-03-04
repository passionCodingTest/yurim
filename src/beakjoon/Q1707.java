package beakjoon;

//1707 : https://www.acmicpc.net/problem/1707

import java.io.*;
import java.util.*;

public class Q1707 {

	public static void main(String[] args) throws IOException {
		Q1707 m = new Q1707();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int K = Integer.parseInt(br.readLine());
		for(int i = 0; i<K; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," "); //정점 수 | 간선 수
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			ArrayList<Integer>[] arr = (ArrayList<Integer>[]) new ArrayList[V+1];
			for(int j = 1; j<=V; j++) {
				arr[j] = new ArrayList<Integer>();
			}
			for(int r = 0; r<E; r++) {
				StringTokenizer st2 = new StringTokenizer(br.readLine()," ");
				int u = Integer.parseInt(st2.nextToken());
				int v = Integer.parseInt(st2.nextToken());
				arr[u].add(v);
				arr[v].add(u);
			}
			int[] color = new int[V+1];
			boolean ok = true;
			for(int j = 1; j<=V; j++) {
				if(color[j] == 0) {
					if(m.dfs(arr,color, j, 1) == false) { // 컬러 0=방문 안했음 , 1 : A, 2 : B
						ok = false;
					}
				}
			}
			if(ok) bw.write("YES\n");
			else bw.write("NO\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}
	
	public boolean dfs(ArrayList<Integer>[] arr, int[] color, int x, int c) {
		color[x] = c;
		for(int y : arr[x]) {
			if(color[y] == 0) {
				if(dfs(arr, color, y, 3-c) == false) {
					return false;
				}
			}else if(color[y] == color[x]) {
				return false;
			}
		}
		return true;
		
	}
}
