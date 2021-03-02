package beakjoon;

//DFS와 BFS : https://www.acmicpc.net/problem/1260

import java.io.*;
import java.util.*;

public class Main42 {
	static int[][] G;
	static ArrayList<Integer>[] GList;
	static Stack<Integer> stack = new Stack<Integer>();
	static Queue<Integer> queue = new LinkedList<Integer>();
	static boolean[] bcheck;
	static boolean[] dcheck;
	public static void main(String[] args) throws IOException{
		Main42 m = new Main42();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(st.nextToken());
		
		bcheck = new boolean[N+1];
		dcheck = new boolean[N+1];
		GList = (ArrayList<Integer>[]) new ArrayList[N+1];// 인접 리스트 
		
		for(int i = 1; i<=N; i++) {
			GList[i] = new ArrayList<Integer>(); //인접 리스트 
		}
		
		for(int i = 0; i< M; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
			int s = Integer.parseInt(st2.nextToken());
			int e = Integer.parseInt(st2.nextToken());
			GList[s].add(e);
			GList[e].add(s);
		}
		
		for(int i = 1; i<=N; i++) {
			Collections.sort(GList[i]);
		}

		//DFS
		m.DFS(start, bw);
		bw.write("\n");
		
		//BFS
		m.BFS(start, bw);
		bw.write("\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
	//BFS
	public void BFS(int start, BufferedWriter bw) throws IOException{
		queue.add(start);
		bcheck[start] = true;
		while(!queue.isEmpty()) {
			int x = queue.remove();
			bw.write(x+" ");
			for(int y : GList[x]) {
				if(bcheck[y] == false) {
					bcheck[y] = true;
					queue.add(y);
				}
			}
		}
	}
	
	//DFS
	public void DFS(int start, BufferedWriter bw) throws IOException {
		if(dcheck[start]) return;
		dcheck[start] = true;
		bw.write(start+" ");
		for(int y : GList[start]) {
			if(dcheck[y] == false) DFS(y, bw);
		}
	}

}
