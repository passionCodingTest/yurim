package beakjoon;

//NM과 K (1) : https://www.acmicpc.net/problem/18290

import java.io.*;
import java.util.*;

public class Main12 {
	static int ans = -2147483647;
	static int[][] a = new int[10][10];
	static boolean[][] c = new boolean[10][10];
	static int n, m, k;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	public static void main(String[] args) throws IOException {
		Main12 main = new Main12();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		for(int i = 0; i<n; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine()," ");
			for(int j = 0; j<m; j++) {
				a[i][j] = Integer.parseInt(st2.nextToken());
			}
		}
		
		main.go(-1, 0, 0, bw);
		
		bw.write(ans+"");
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	public void go(int prev, int cnt, int sum, BufferedWriter bw) throws IOException {
		if(cnt == k) {
			if(ans < sum) ans = sum;
			return ;
		}
		for(int j=prev+1; j<n*m; j++) {
			int x = j/m;
			int y = j%m;
			
			if(c[x][y]) continue;
			
			boolean ok = true;
			
			for(int i = 0; i<4; i++) {
				int nx = x+dx[i];
				int ny = y+dy[i];
				if(0<=nx && nx < n && 0<= ny && ny < m) {
					if(c[nx][ny]) ok=false;
				}
			}
			if(ok) {
				c[x][y] = true;
				go(x*m+y, cnt+1,sum+a[x][y], bw);
				c[x][y] = false;
			}
		}
	}
}
