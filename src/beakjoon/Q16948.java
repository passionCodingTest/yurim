package beakjoon;

//데스 나이트 :https://www.acmicpc.net/problem/16948

import java.io.*;
import java.util.*;

public class Q16948 {
	static int N;
	static boolean[][] visited;
	static int[][] d ;
	static int[] dx = {-2,-2,0,0,2,2};
	static int[] dy = {-1,1,-2,2,-1,1};
	
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
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int r1 = Integer.parseInt(st.nextToken());
		int c1 = Integer.parseInt(st.nextToken());
		int r2 = Integer.parseInt(st.nextToken());
		int c2 = Integer.parseInt(st.nextToken());
		d = new int[N][N];
		for(int i = 0; i<N; i++) {
			Arrays.fill(d[i], -1);
		}
		Queue<Pair> q = new LinkedList<Pair>();
		q.add(new Pair(r1,c1));
		d[r1][c1] = 0;
		while(!q.isEmpty()) {
			Pair p = q.remove();
			int px = p.x;
			int py = p.y;
			for(int i = 0; i<6; i++) {
				int nx = px+dx[i];
				int ny = py+dy[i];
				if(0<= nx && nx <N && 0<=ny && ny<N) {
					if(d[nx][ny] == -1) {
						d[nx][ny] = d[px][py] + 1;
						q.add(new Pair(nx,ny));
					}
				}
			}
		}
		bw.write(d[r2][c2]+"");
		bw.flush();
		bw.close();
		br.close();
	}

}
