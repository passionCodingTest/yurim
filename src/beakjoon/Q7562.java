package beakjoon;


import java.io.*;
import java.util.*;

public class Q7562 {
	static int[] dx = {-2,-2,-1,-1,1,1,2,2};
	static int[] dy = {-1,1,-2,2,2,-2,1,-1};
	static int l ;
	static int ans = Integer.MAX_VALUE;
	class Pair{
		int x; int y;
		Pair(int x, int y){
			this.x=x;
			this.y=y;
		}
	}
	
	public static void main(String[] args) throws IOException{
		Q7562 m = new Q7562();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int testCase = Integer.parseInt(br.readLine());
		
		for(int i = 0; i<testCase; i++) {
			l = Integer.parseInt(br.readLine());
			StringTokenizer s = new StringTokenizer(br.readLine(), " ");
			StringTokenizer s2 = new StringTokenizer(br.readLine(), " ");
			int now_x = Integer.parseInt(s.nextToken());
			int now_y = Integer.parseInt(s.nextToken());
			int d_x = Integer.parseInt(s2.nextToken());
			int d_y = Integer.parseInt(s2.nextToken());
			boolean[][] check = new boolean[l][l];
			int[][] d = new int[l][l];
			m.bfs(d, check, now_x, now_y, d_x, d_y, 0);
			
			bw.write(d[d_x][d_y]+"\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	public void bfs(int[][] d, boolean[][] check, int start_X, int start_Y, int end_X, int end_Y, int cnt) {
		Queue<Pair> q = new LinkedList<Pair>();
		q.add(new Pair(start_X, start_Y));
		check[start_X][start_Y] = true;
		d[start_X][start_Y] = cnt;
		
		while(!q.isEmpty()) {
			Pair p = q.remove();
			int x = p.x;
			int y = p.y;
			for(int k = 0; k<8; k++) {
				int nx = x+dx[k];
				int ny = y+dy[k];
				if(0<= nx && nx<l && 0<=ny && ny < l) {
					if(check[nx][ny] == false) {
						q.add(new Pair(nx,ny));
						check[nx][ny] = true;
						d[nx][ny] = d[x][y]+1;
					}
				}
			}
		}
		
	}
	
}
