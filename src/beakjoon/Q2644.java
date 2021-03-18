package beakjoon;

//촌수 계산 : https://www.acmicpc.net/problem/2644

import java.io.*;
import java.util.*;

public class Q2644 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int person = Integer.parseInt(br.readLine());
		int[] d = new int[person+1];
		ArrayList<Integer>[] g = (ArrayList<Integer>[]) new ArrayList[person+1]; 
		boolean[] visited = new boolean[person+1];
		for(int i = 0; i<person+1; i++) {
			g[i] = new ArrayList<Integer>();
			d[i] = -1;
		}
		StringTokenizer r = new StringTokenizer(br.readLine(), " ");
		int start = Integer.parseInt(r.nextToken());
		int end = Integer.parseInt(r.nextToken());
		int v = Integer.parseInt(br.readLine());
		for(int i = 0; i<v; i++) {
			StringTokenizer n = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(n.nextToken());
			int b = Integer.parseInt(n.nextToken());
			g[a].add(b);
			g[b].add(a);
		}
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(start);
		visited[start] = true;
		d[start] = 0;
		while(!q.isEmpty()) {
			int p = q.remove();
			for(int i = 0; i<g[p].size(); i++) {
				if(visited[g[p].get(i)]) continue;
				visited[g[p].get(i)]=true;
				d[g[p].get(i)] = d[p]+1;
				q.add(g[p].get(i));
			}
		}
		bw.write(d[end]+"");
		bw.flush();
		bw.close();
		br.close();
	}

}
