package beakjoon;

//바이러스 : https://www.acmicpc.net/problem/2606

import java.util.*;
import java.io.*;
public class Q2606 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int computer = Integer.parseInt(br.readLine());
		int v = Integer.parseInt(br.readLine());
		ArrayList<Integer>[] arr = (ArrayList<Integer>[]) new ArrayList[computer+1];
		boolean[] visited = new boolean[computer+1];
		for(int i = 0; i<=computer; i++) {
			arr[i] = new ArrayList<>();
		}
		for(int i = 0; i<v; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a].add(b);
			arr[b].add(a);
		}
		
		int cnt = 0;
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(1);
		visited[1] = true;
		while(!q.isEmpty()) {
			int a = q.remove();
			for(int i = 0; i<arr[a].size(); i++) {
				if(visited[arr[a].get(i)]) continue;
				q.add(arr[a].get(i));
				visited[arr[a].get(i)] = true; 
			}
			if(a != 1) cnt +=1;
		}
		
		bw.write(cnt+"");
		bw.flush();
		bw.close();
		br.close();
	}
}
