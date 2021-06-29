package beakjoon;

import java.io.*;
import java.util.*;
public class Q15686 {
	static int n,m;
	static int minValue = -1;
	static boolean[] selected ;
	static ArrayList<Pair> chicken = new ArrayList<>(), house = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		for(int i = 1; i<=n; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j = 1; j<=n; j++) {
				int a = Integer.parseInt(st.nextToken());
				if(a == 1) house.add(new Pair(i,j));
				if(a == 2) chicken.add(new Pair(i,j));
			}
		}
		selected = new boolean[chicken.size()];
		go(0,0);
		System.out.println(minValue);
	}
	static void go(int depth, int selectCnt) {
		if(selectCnt == m) {
			minValue = minValue == -1 ? getDistance() : Math.min(getDistance(), minValue);
		}
		if(depth == chicken.size()) return ;
		selected[depth] = true;
		go(depth+1, selectCnt+1);
		selected[depth] = false;
		go(depth+1, selectCnt);
	}
	static int getDistance() {
		int totalDist = 0;
		for(Pair p : house) {
			int minDist = -1;
			int x = p.x;
			int y = p.y;
			for(int i = 0; i<chicken.size(); i++) {
				if(selected[i]==false) continue;
				Pair p2 = chicken.get(i);
				minDist = minDist == -1 ? 
						Math.abs(p2.x-x) + Math.abs(p2.y - y) : 
							Math.min(Math.abs(p2.x-x) + Math.abs(p2.y - y), minDist);
		
			}
			totalDist += minDist;
		}
		return totalDist;
	}
	static class Pair{
		int x,y ;
		Pair(int x, int y){
			this.x = x;
			this.y = y;
		}
	}

}
