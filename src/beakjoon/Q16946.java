package beakjoon;

import java.io.*;
import java.util.*;
public class Q16946 {
	static int N,M;
	static int MAX=1001;
	static int[][] d = new int[MAX][MAX];
	static int[][] group = new int[MAX][MAX];
	static int[] groupSize = new int[MAX*MAX];
	static boolean[][] checked = new boolean[MAX][MAX];
	static int[] dx = {0,1,0,-1};
	static int[] dy = {-1,0,1,0};
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		for(int i = 0; i<N; i++) {
			String row = br.readLine();
			for(int j = 0; j<M; j++) {
				d[i][j] = row.charAt(j)-'0';
			}
		}
		int cnt = 1;
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<M; j++) {
				if(d[i][j] == 0 && checked[i][j] == false) {
					bfs(i,j,cnt);
					cnt++;
				}
			}
		}
		for(int i = 0; i<N; i++) {
			StringBuilder sb = new StringBuilder();
			for(int j = 0; j<M; j++) {
				if(d[i][j]==0) {
					sb.append("0");
					continue;
				}
				HashSet<Integer> groupList = new HashSet<>();
				for(int k = 0; k<4; k++) {
					int nx = i+dx[k];
					int ny = j+dy[k];
					if(0<=nx && nx <N && 0<=ny && ny<M) {
						if(d[nx][ny]==0) groupList.add(group[nx][ny]);
					}
				}
				int sum = 1;
				for(int g : groupList) sum += groupSize[g];
				sb.append(sum%10+"");
			}
			bw.write(sb.toString()+"\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
	static public void bfs(int x,int y, int num) {
		Queue<Integer> q = new LinkedList<>();
		q.add(x); q.add(y);
		checked[x][y] = true;
		group[x][y] = num;
		int cnt = 1;
		while(!q.isEmpty()) {
			int qx = q.poll();
			int qy = q.poll();
			for(int k = 0; k<4; k++) {
				int nx = qx+dx[k];
				int ny = qy+dy[k];
				if(0<=nx && nx <N && 0<=ny && ny<M) {
					if(d[nx][ny]==0 && checked[nx][ny]==false) {
						q.add(nx); q.add(ny);
						group[nx][ny] = num;
						checked[nx][ny] = true;
						cnt+=1;
					}
				}
			}
		}
		groupSize[num] = cnt;
	}
}
