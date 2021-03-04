package beakjoon;

//미로 탐색 : https://www.acmicpc.net/problem/2178
//bfs탐색 방법 

import java.io.*;
import java.util.*;

public class Q2178 {
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};

	
	static class Pair{
		int px;
		int py;
		Pair(int px, int py){
			this.px = px;
			this.py = py;
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int y = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int[][] a = new int[y][x];
		for(int i = 0; i < y; i++) {
			String line = br.readLine();
			for(int j = 0; j<x; j++) {
				a[i][j] = line.charAt(j)-'0';
			}
		}
		
		int[][] d = new int[y][x];
		boolean[][] check = new boolean[y][x];
		Queue<Pair> q = new LinkedList<Pair>();
		q.add(new Pair(0,0));
		check[0][0] = true;
		d[0][0]=1;
		while(!q.isEmpty()) {
			Pair p = q.remove();
			int px = p.px;
			int py = p.py;
			for(int k = 0; k<4; k++) {
				int nx = px+dx[k];
				int ny = py+dy[k];
				
				if(0<=nx && nx < y && 0<=ny && ny< x) {
					if(check[nx][ny] == false && a[nx][ny] == 1) {
						q.add(new Pair(nx, ny));
						d[nx][ny] = d[px][py] + 1;
						check[nx][ny] = true;
					}
				}
			}
		}
		
		bw.write(d[y-1][x-1]+"");
		bw.flush();
		bw.close();
		br.close();
		
	}

}
