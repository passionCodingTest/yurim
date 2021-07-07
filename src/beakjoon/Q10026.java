package beakjoon;

import java.io.*;
import java.util.*;
public class Q10026 {
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		char[][] g = new char[n][n];
		int[][] groups = new int[n][n];
		int[][] colorBlindnessGroups = new int[n][n];
		for(int i = 0; i<n; i++) {
			String line = br.readLine();
			for(int j = 0; j<n; j++) {
				g[i][j] = line.charAt(j);
			}
		}
		int cnt = 1;
		int colorCnt = 1;
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<n; j++) {
				if(groups[i][j] == 0) {
					Queue<Integer> q = new LinkedList<>();
					q.add(i); q.add(j);
					groups[i][j] = cnt;
					while(!q.isEmpty()) {
						int x = q.poll();
						int y = q.poll();
						for(int k = 0; k<4; k++) {
							int nx = x+dx[k];
							int ny = y+dy[k];
							if(nx < 0 || nx >= n || ny <0 || ny >= n) continue;
							if(g[x][y] != g[nx][ny] || groups[nx][ny] != 0) continue;
							groups[nx][ny] = cnt;
							q.add(nx); q.add(ny);
						}
					}
					cnt+=1;
				}
				if(colorBlindnessGroups[i][j]==0) {
					Queue<Integer> q = new LinkedList<>();
					q.add(i); q.add(j);
					colorBlindnessGroups[i][j] = colorCnt;
					boolean check = g[i][j] == 'G' || g[i][j] == 'R';
					while(!q.isEmpty()) {
						int x = q.poll();
						int y = q.poll();
						if(check) {// 적색 혹은 녹색일떼 
							for(int k = 0; k<4; k++) {
								int nx = x+dx[k];
								int ny = y+dy[k];
								if(nx < 0 || nx >= n || ny <0 || ny >= n) continue;
								if((g[nx][ny] != 'G' && g[nx][ny] != 'R') || colorBlindnessGroups[nx][ny] != 0) continue;
								colorBlindnessGroups[nx][ny] = colorCnt;
								q.add(nx); q.add(ny);
							}
						}else {
							for(int k = 0; k<4; k++) {
								int nx = x+dx[k];
								int ny = y+dy[k];
								if(nx < 0 || nx >= n || ny <0 || ny >= n) continue;
								if(g[x][y] != g[nx][ny] || colorBlindnessGroups[nx][ny] != 0) continue;
								colorBlindnessGroups[nx][ny] = colorCnt;
								q.add(nx); q.add(ny);
							}
						}
					}
					colorCnt +=1;
				}
			}
		}
		System.out.println((cnt-1)+" "+(colorCnt-1));
	}

}
