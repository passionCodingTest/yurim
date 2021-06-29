package beakjoon;

import java.util.*;
import java.io.*;
public class Q2583 {
	static int[][] g,visited;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {-1,0,1,0};
	static boolean broken = false;
	static int n,m;
	static int ans = Integer.MAX_VALUE;
	static class Pair{
		int x; int y; int broken; int dis;
		Pair(int x, int y, int dis, int broken){
			this.x = x;
			this.y = y;
			this.broken = broken;
			this.dis = dis;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		g = new int[n][m];
		visited = new int[n][m];
		for(int i = 0; i<n; i++) {
			String row = br.readLine();
			for(int j = 0; j<m; j++) {
				g[i][j] = Integer.parseInt(row.charAt(j)+"");
				visited[i][j] = Integer.MAX_VALUE;
			}
		}
		bfs(0,0);
		bw.write((ans==Integer.MAX_VALUE? -1 : ans) +"\n");
		bw.flush();
		bw.close();
		br.close();

	}
	static public void bfs(int x, int y) {
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(x,y,1,0));
		visited[x][y] = 0;
		while(!q.isEmpty()) {
			Pair p = q.poll();
			if(p.x==n-1 && p.y == m-1) {
				ans = p.dis;
				break;
			}
			for(int k = 0; k<4; k++) {
				int nx = p.x+dx[k];
				int ny = p.y+dy[k];
				if(ny < 0 || nx < 0 || ny >= m || nx >= n) continue;
				if(visited[nx][ny] <= p.broken) continue;
				
				if(g[nx][ny]==0) {
					visited[nx][ny] = p.broken;
					q.add(new Pair(nx,ny,p.dis+1, p.broken));
				}else {
					if(p.broken==0) {
						visited[nx][ny] = p.broken+1;
						q.add(new Pair(nx,ny,p.dis+1, p.broken+1));
					}
				}
			}
		}
	}
}
