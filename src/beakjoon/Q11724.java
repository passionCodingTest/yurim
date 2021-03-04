package beakjoon;

//11724번 - 연결 요소의 개수 : https://www.acmicpc.net/problem/11724

import java.io.*;
import java.util.*;

public class Q11724 {

	public static void main(String[] args) throws IOException {
		Q11724 m = new Q11724();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		boolean[] c = new boolean[N+1];
		ArrayList<Integer>[] arr = (ArrayList<Integer>[]) new ArrayList[N+1];
		int answer = 0;
		for(int i = 0; i<=N; i++) {
			arr[i] = new ArrayList<Integer>();
		}
		
		for(int i=1; i<=M; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine()," ");
			int k = Integer.parseInt(st2.nextToken());
			int j = Integer.parseInt(st2.nextToken());
			arr[k].add(j);
			arr[j].add(k);
		}
		
		for(int i = 1; i<=N; i++) {
			if(c[i] == false) {
				m.dfs(arr,c,i);
				answer +=1;
			}
		}
		
		bw.write(answer+"");
		bw.flush();
		bw.close();
		br.close();
	}
	
	public void dfs(ArrayList<Integer>[] arr, boolean[] c, int x) {
		if(c[x]) return;
		c[x] = true;
		for(int y : arr[x]) {
			dfs(arr, c, y);
		}
	}

}
