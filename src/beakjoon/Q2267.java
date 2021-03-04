package beakjoon;

//단지번호붙이기  : https://www.acmicpc.net/problem/2667
//bfs 

import java.io.*;
import java.util.*;

public class Q2267 {
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	public static void main(String[] args) throws IOException {
		Q2267 m = new Q2267();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int[][] a = new int[N][N];
		int[][] d = new int[N][N];
		
		for(int i = 0; i <N; i++) {
			String s = br.readLine();
			String[] arr = s.split("");
			for(int j = 0; j<N; j++) {
				a[i][j] = Integer.parseInt(arr[j]);
			}
		}
		int cnt = 0;
		
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<N; j++) {
				if(a[i][j] == 1 && d[i][j] == 0) {
					m.bfs(d, a, i, j, ++cnt, N, bw);
				}
			}
		}
		
		int[] ans = new int[cnt];
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<N; j++) {
				if(d[i][j] != 0) ans[d[i][j]-1] +=1;
			}
		}
		
		Arrays.sort(ans);
		
		bw.write(cnt+"\n");
		for(int value : ans) {
			bw.write(value+"\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	public void bfs(int[][] d, int[][] a, int i, int j, int cnt, int N, BufferedWriter bw) throws IOException {
		Queue<Pair> q = new LinkedList<Pair>();
		q.add(new Pair(i,j));
		d[i][j] = cnt;
		while(!q.isEmpty()) {
			Pair p = q.remove();
			int x = p.x; 
			int y = p.y;
			for(int k = 0; k<4; k++) {
				int nx = x+dx[k];
				int ny = y+dy[k]; 
				if(0<=nx && nx < N && 0 <= ny && ny < N) {
					if(a[nx][ny] == 1 && d[nx][ny] == 0) {
						q.add(new Pair(nx,ny));
						d[nx][ny] = cnt;
					}
				}
			}
		}
	}
	
	class Pair {
		int x,y;
		Pair(int x, int y) {
			this.x=  x;
			this.y = y;
		}
	}

}
