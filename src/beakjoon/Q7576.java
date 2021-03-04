package beakjoon;

//토마토 : https://www.acmicpc.net/problem/7576
//bfs 탐색 방

import java.io.*;
import java.util.*;

public class Q7576 {
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	static class Pair{
		int x;
		int y;
		Pair(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] a = new int[M][N];
		int[][] d = new int[M][N];
		Queue<Pair> q = new LinkedList<Pair>();
		for(int i = 0; i<M; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine()," ");
			for(int j = 0; j<N; j++) {
				a[i][j] = Integer.parseInt(st2.nextToken());
				d[i][j] = -1;
				if(a[i][j] == 1) {
					q.add(new Pair(i,j));
					d[i][j] = 0;
				}
			}
		}
		//a[][] 0 : 안 익음, 1: 익음, -1:비어있음 
		while(!q.isEmpty()) {
			Pair p = q.remove();
			int x = p.x;
			int y = p.y;
			for(int k = 0; k<4; k++) {
				int nx = x+dx[k];
				int ny = y+dy[k];
				if(0<=nx && nx < M && 0 <= ny && ny < N) {
					if(a[nx][ny] == 0 && d[nx][ny] == -1) {
						q.add(new Pair(nx,ny));
						d[nx][ny] = d[x][y]+1;
					}
				}
			}
		}
		
		int ans = 0;
		for(int i=0; i<M; i++) {
			for(int j = 0; j<N; j++) {
				if(ans<d[i][j]) ans = d[i][j];
				if(a[i][j] == 0 && d[i][j] == -1) {
					ans = -1; break;
				}
			}
		}
		
		bw.write(ans+"");
		
		bw.flush();
		bw.close();
		br.close();
	}

}
