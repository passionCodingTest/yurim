package beakjoon;

//링크와 스타트 : https://www.acmicpc.net/problem/15661

import java.util.*;
import java.io.*;

public class Q15661 {
	static int N;
	static int[][] team;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		team = new int[N][N];
		for(int i = 0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for(int j = 0; j<N; j++) {
				team[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		ArrayList<Integer> first = new ArrayList<>();
		ArrayList<Integer> second = new ArrayList<>();
		int ans = go(0, first, second);
		
		bw.write(ans+"");
		bw.flush();
		bw.close();
		br.close();

	}
	
	static int go(int index , ArrayList<Integer> first, ArrayList<Integer> second) {
		if(index == N) {
			if(first.size() == 0) return -1;
			if(second.size() == 0) return -1;
			int t1 = 0;
			int t2 = 0;
			for(int i = 0; i<first.size(); i++) {
				for(int j = 0; j<first.size(); j++) {
					if(i == j) continue;
					t1 += team[first.get(i)][first.get(j)];
				}
			}
			
			for(int i = 0; i<second.size(); i++ ) {
				for(int j = 0; j<second.size(); j++) {
					if(i == j ) continue;
					t2 +=team[second.get(i)][second.get(j)];
				}
			}
			
			int diff = Math.abs(t1-t2);
			
			return diff;
		}
		if(first.size() > N/2) return -1;
		if(second.size() > N/2) return -1;
		int ans = -1;
		first.add(index);
		int t1 = go(index+1, first, second);
		if(ans == -1 || (t1 != -1 && ans > t1)) ans = t1;
		first.remove(first.size()-1);
		second.add(index);
		int t2 = go(index+1, first, second);
		if(ans == -1 || (t2 != -1 && ans > t2)) ans = t2;
		second.remove(second.size()-1);
		return ans;
	}

}
