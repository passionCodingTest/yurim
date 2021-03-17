package beakjoon;

//안전 영역 : https://www.acmicpc.net/problem/2468

import java.io.*;
import java.util.*;

public class Q2468 {
	static int[] dx = {-1, 0, 0, 1};
	static int[] dy = {0, -1, 1, 0};
	static int ans = 0;
	static int n;
	static int[][] a, d;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		n = Integer.parseInt(br.readLine());
		a = new int[n][n];
		int max = 0;
		for(int i = 0; i<n; i++) {
			StringTokenizer row = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j<n; j++) {
				a[i][j] = Integer.parseInt(row.nextToken());
				if(max < a[i][j]) max = a[i][j];
			}
		}
		for(int k = 0; k <= max; k++) {
			int cnt = 0;
			d = new int[n][n];
			for(int i = 0; i<n; i++) {
				for(int j = 0; j<n; j++) {
					if(a[i][j] <= k) {
						a[i][j] = -1;
					}
				}
			}
			for(int i = 0; i<n; i++) {
				for(int j = 0; j<n; j++) {
					if(a[i][j] > k && d[i][j] == 0) {
						dfs(++cnt, j, i, k);
					}
				}
			}
		}
		bw.write(ans+"");
		bw.flush();
		bw.close();
		br.close();
	}
	
	static public void dfs(int cnt, int x, int y, int k) {
		d[y][x] = cnt;
		if(ans == 0 || ans < cnt) ans = cnt;
		for(int i = 0; i<4; i++) {
			int px = x + dx[i];
			int py = y + dy[i];
			if( 0 <= px && px < n && 0<= py && py < n) {
				if(a[py][px] > k && d[py][px] == 0)
					dfs(cnt, px, py, k);
			}
		}
	}

}
