package beakjoon;

//연구소 : https://www.acmicpc.net/problem/14502

import java.util.*;
import java.io.*;

public class Q14502 {
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	static int[][] d , a;
	static int N, M;
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
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); //row
		M = Integer.parseInt(st.nextToken()); // column
		a = new int[N][M];
		d = new int[N][M];
		int ans = 0;
		for(int i = 0; i<N; i++) {
			StringTokenizer row = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j<M; j++) {
				a[i][j] = Integer.parseInt(row.nextToken());
			}
		}
		
		for(int x1 = 0; x1<N; x1++) {
			for(int y1 = 0; y1<M; y1++) {
				if(a[x1][y1] != 0) continue;
				for(int x2 = 0; x2<N; x2++) {
					for(int y2 = 0; y2<M; y2++) {
						if(a[x2][y2] != 0) continue;
						for(int x3 = 0; x3<N; x3++) {
							for(int y3 = 0; y3 <M; y3++) {
								if(a[x3][y3] != 0)continue;
								if((x1 == x2 &&y1 == y2) || (x2 == x3 && y2 == y3) || (x1 == x3&&y1 == y3)) continue;
								a[x1][y1] = 1;
								a[x2][y2] = 1;
								a[x3][y3] = 1;
								int cur = bfs();
								if(ans < cur) ans = cur;
								a[x1][y1] = 0;
								a[x2][y2] = 0;
								a[x3][y3] = 0;
							}
						}
					}
				}
			}
		}
		bw.write(ans + "");
		bw.flush();
		bw.close();
		br.close();
		
	}
	
	static public int bfs() {
		Queue<Pair> queue = new LinkedList<Pair>();
		for(int i = 0; i< N; i++) {
			for(int j = 0; j<M; j++ ) {
				d[i][j] = a[i][j];
				if(d[i][j] == 2) {
					queue.add(new Pair(i,j));
				}
			}
		}
		while(!queue.isEmpty()) {
			Pair p = queue.remove();
			int px = p.x;
			int py = p.y;
			for(int i = 0; i<4; i++) {
				int nx = px+dx[i];
				int ny = py+dy[i];
				if(0<= nx && nx < N && 0<= ny && ny < M) {
					if(d[nx][ny] == 0) {
						d[nx][ny] = 2;
						queue.add(new Pair(nx, ny));
					}
				}
			}
			
		}
		int count = 0;
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<M; j++) {
				if(d[i][j] == 0) count +=1;
			}
		}
		
		return count;
	}

}
