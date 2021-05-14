package beakjoon;

import java.util.*;
public class Q16947 {
	static int N;
	static boolean[] cycle = new boolean[3001];
	static List<Integer>[] list = new ArrayList[3001];
	static int[] d= new int[3001];
	static Queue<Integer> queue = new LinkedList<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		for(int i =0;i<=N; i++) {
			d[i] = -1;
			list[i] = new ArrayList<>();
		}
		for(int i = 0; i < N; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			list[a].add(b);
			list[b].add(a);
		}
		for(int i = 1; i<=N; i++) {
			if(cycle[i]) continue;
			findCycle(i,i,0);
		}
		findDistance();
		for(int i = 1; i<=N; i++) {
			System.out.print(d[i]+" ");
		}
	}
	static public void findDistance() {
		int cnt = 1;
		while(!queue.isEmpty()) {
			int size= queue.size();
			for(int i = 1; i<=size; i++) {
				int q = queue.poll();
				for(int n : list[q]) {
					if(d[n] != -1) continue;
					d[n] = cnt;
					queue.add(n);
				}
			}
			cnt++;
		}
	}
	static public boolean findCycle(int v, int start, int cnt) {
		if(cycle[v]) return v == start && cnt > 2;
		cycle[v] = true;
		for(int n : list[v]) {
			if(findCycle(n,start,cnt+1)) {
				d[n] = 0;
				queue.add(n);
				return true;
			}
		}
		cycle[v] = false;
		return false;
	}

}
