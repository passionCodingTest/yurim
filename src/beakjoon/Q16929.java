package beakjoon;

import java.io.*;
import java.util.*;
public class Q16929 {
	static boolean[][] check ;
	static Character[][] a;
	static int n,m;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};
	static int[][] d ;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		check = new boolean[n][m];
		d = new int[n][m];
		a = new Character[n][m];
		for(int i = 0; i<n; i++) {
			String s = br.readLine();
			for(int j = 0; j<m; j++) {
				a[i][j] = s.charAt(j);
			}
		}
		for(int i = 0; i<n; i++) {
			for(int j = 0; j < m; j++) {
				if(dfs(i,j, 0, a[i][j])) {
					System.out.println("Yes");
					return ;
				}
			}
		}
		System.out.println("No");
	}
	
	static public boolean dfs(int x, int y, int cnt, char color) {
		if(check[x][y]) return cnt - d[x][y] >= 4;
		d[x][y] = cnt; check[x][y] = true;
		for(int k = 0; k<4; k++) {
			int nx = x + dx[k];
			int ny = y + dy[k];
			if(0<= nx && nx < n && 0<= ny && ny < m) {
				if(a[nx][ny] == color) {
					if(dfs(nx, ny, cnt+1, color)) return true;
				}
			}
		}
		
		return false;
	}

}
