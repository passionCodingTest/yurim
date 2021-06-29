package beakjoon;

import java.io.*;
import java.util.*;
public class Q11725 {
	static int[] parents;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		ArrayList<Integer>[] g = (ArrayList<Integer>[]) new ArrayList[n+1]; 
		for(int i = 0; i<=n; i++) {
			g[i] = new ArrayList<>();
		}
		for(int i = 0; i<n-1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			g[a].add(b);
			g[b].add(a);
		}
		parents = new int[n+1];
		int root = 1;
		bfs(root, g, parents, n);
		for(int i = 2; i<=n; i++) {
			bw.write(parents[i]+"\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
	static public void bfs(int root, ArrayList<Integer>[] g, int[] parents, int n) {
		Queue<Integer> q = new LinkedList<>();
		q.add(root);
		parents[root] = 1;
		while(!q.isEmpty()) {
			int parent = q.poll();
			for(int i : g[parent]) {
				if(parents[i] == 0) {
					parents[i] = parent;
					q.add(i);
				}
			}
		}
	}
}
