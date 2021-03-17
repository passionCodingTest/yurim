package beakjoon;

//섬의 개수 : https://www.acmicpc.net/problem/4963

import java.io.*;
import java.util.*;
public class Q4963 {
	static int[] dx = {0,1,1,1,0,-1,-1,-1};
	static int[] dy = {1,1,0,-1,-1,-1,0,1};
	static int[][] d, a;
	static int w,h;
	static int ans ;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String input = "";
		
		while(!(input=br.readLine()).equals("0 0")){
			StringTokenizer st = new StringTokenizer(input, " ");
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			d = new int[h][w];
			a = new int[h][w];
			ans = 0;
			for(int i = 0; i<h; i++) {
				StringTokenizer row = new StringTokenizer(br.readLine()," ");
				for(int j = 0; j<w; j++) {
					a[i][j] = Integer.parseInt(row.nextToken());
				}
			}
			int cnt = 0;
			for(int i = 0; i<h; i++) {
				for(int j = 0; j<w; j++) {
					if(a[i][j] == 1 && d[i][j] == 0) {
						dfs(a,d,++cnt, j, i);
					}
				}
			}
			
			bw.write(ans+"\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
	
	static public void dfs(int[][] a, int[][] d, int cnt, int x, int y) {
		d[y][x] = cnt;
		if(ans == 0 || ans < cnt) ans = cnt;
		for(int i = 0; i < 8; i++) {
			int px = x+dx[i];
			int py = y+dy[i];
			if(0 <= px && px < w && 0 <= py && py < h) {
				if(a[py][px] == 1 && d[py][px] == 0) {
					dfs(a, d, cnt, px, py);
				}
			}
		}
	}

}
