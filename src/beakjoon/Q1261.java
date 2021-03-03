package beakjoon;

//알고스팟 : https://code.plus/course/51

import java.io.*;
import java.util.*;

public class Q1261 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		int[][] G = new int[N][M];
		for(int i = 0; i < N; i++) {
			String[] st2 = (br.readLine()).split("");
			for(int j = 0; j<M; j++) {
				G[i][j] = Integer.parseInt(st2[j]);
			}
		}
		
		int[] dx = {0,0,1,-1};
		int[] dy = {1,-1,0,0};
		int[][] d = new int[N][M];
		
		Queue<Pair> q = new LinkedList<Pair>();
		Queue<Pair> next_queue = new LinkedList<Pair>();
		q.offer(new Pair(0,0));
		
		for(int i = 0; i < N; i++) {
			Arrays.fill(d[i], -1);
		}
		
		d[0][0] = 0;
		while(!q.isEmpty()) {
			Pair p = q.remove();
			int x = p.x;
			int y = p.y;
			
			for(int k =0; k<4; k++) {
				int nx = x+dx[k];
				int ny = y+dy[k];
				
				if(0<= nx && nx < N && 0<= ny && ny < M) {
					if(d[nx][ny] == -1) {
						if(G[nx][ny] == 0) {
							d[nx][ny] = d[x][y];
							q.offer(new Pair(nx,ny));
						}else {
							d[nx][ny] = d[x][y]+1;
							next_queue.offer(new Pair(nx, ny));
						}
					}
				}
			}
			
			if(q.isEmpty()) {
				q = next_queue;
				next_queue = new LinkedList<Pair>();
			}
		}
		
		bw.write(d[N-1][M-1]+"");
		bw.flush();
		bw.close();
		br.close();
	}

}

class Pair{
	int x, y;
	Pair(int x, int y){
		this.x = x;
		this.y = y;
	}
}
