package beakjoon;

//이모티콘 : https://www.acmicpc.net/problem/14226

import java.io.*;
import java.util.*;

public class Q14226 {

	public static void main(String[] args) throws IOException {
		Queue<Integer> queue = new LinkedList<Integer>();// 화면 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int MAX = 1000;
		int S = Integer.parseInt(br.readLine());
		int[][] dist = new int[S+1][S+1];
		for(int i = 0; i<=S; i++) {
			Arrays.fill(dist[i], -1);
		}
		queue.add(1);
		queue.add(0);
		dist[1][0] = 0; //화면 : 1 , 클립보드 : 0
		while(!queue.isEmpty()) {
			int s = queue.remove();
			int c = queue.remove();
			
			if(dist[s][s] == -1) { //복사 
				dist[s][s] = dist[s][c]+1;
				queue.add(s); queue.add(s);
			}
			
			if(s+c <= S && dist[s+c][c] == -1) { // 붙여넣기 
				dist[s+c][c] = dist[s][c]+1;
				queue.add(s+c); queue.add(c);
			}
			
			if(s-1 >= 0 && dist[s-1][c] == -1) { //삭제 
				dist[s-1][c] = dist[s][c] + 1;
				queue.add(s-1); queue.add(c);
			}
			
		}
		
		int ans = -1;
		
		for(int i = 0; i<=S; i++) {
			if(dist[S][i] != -1) {
				if(ans == -1 || ans > dist[S][i]) {
					ans = dist[S][i];
				}
			}
		}
		
		bw.write(ans+"");
		
		bw.flush();
		bw.close();
		br.close();
	}

}
