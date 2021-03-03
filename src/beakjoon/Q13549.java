package beakjoon;

//숨박꼭질3 : https://code.plus/course/51

//가중치가 다를때, 덱을 이용하여 최단 거리 찾기 

import java.io.*;
import java.util.*;

public class Q13549 {
	
	public static void main(String[] args) throws IOException {
		Queue<Integer> nowQ = new LinkedList<Integer>();
		Queue<Integer> nextQ = new LinkedList<Integer>();;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int MAX = 200000;
		
		boolean[] check = new boolean[MAX];
		int[] dist = new int[MAX];
		check[N] = true;
		dist[N] = 0;
		nowQ.add(N);
		while(!nowQ.isEmpty()) {
			int now = nowQ.remove();
			
			for(int next : new int[]{now*2, now+1, now-1}) {
				if(next >= 0 && next<MAX) {
					if(check[next] == false) {
						check[next] = true;
						if(now*2 == next) {
							nowQ.add(next); dist[next] = dist[now];
						}
						else {
							nextQ.add(next);
							dist[next] = dist[now]+1;
						}
					}
				}
			}
			
			if(nowQ.isEmpty()) {
				nowQ = nextQ;
				nextQ = new LinkedList<Integer>();
			}
		}
		bw.write(dist[K]+"");
		
		bw.flush();
		bw.close();
		br.close();
	}

}
