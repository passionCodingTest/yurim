package beakjoon;

// 유기농 배추 : https://www.acmicpc.net/problem/1012

import java.io.*;
import java.util.*;
public class Q1012 {
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};

	static class Pair{
		int x;
		int y;
		Pair(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int[][] d;
		boolean[][] visited;
		int testCase = Integer.parseInt(br.readLine());
		for(int i = 0; i<testCase; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			d = new int[N][M];
			visited = new boolean[N][M];
			
			for(int j =0; j<K; j++) {
				StringTokenizer st2 = new StringTokenizer(br.readLine()," ");
				int m = Integer.parseInt(st2.nextToken()); //가로 
				int n = Integer.parseInt(st2.nextToken()); //세로 
				d[n][m] = 1;
			}
			int cnt = 0;
			for(int y = 0; y < N; y++) {
				for(int x = 0; x < M; x++) {
					if(visited[y][x] == false && d[y][x] == 1) {
						visited[y][x] = true;
						Queue<Pair> q = new LinkedList<Pair>();
						q.add(new Pair(x, y));
						while(!q.isEmpty()) {
							Pair p = q.remove();
							int px = p.x;
							int py = p.y;
							for(int k = 0; k<4; k++) {
								int nx = px+dx[k];
								int ny = py+dy[k];
								if( 0 <= ny && ny < N && 0 <= nx && nx < M) {
									if(d[ny][nx] == 1 && visited[ny][nx] == false) {
										q.add(new Pair(nx, ny));
										visited[ny][nx] = true;
									}
								}
							}
						}
						cnt +=1;
					}
				}
			}
			bw.write(cnt+"\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
	
}
