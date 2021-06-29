package beakjoon;

import java.util.*;
import java.io.*;
public class Q2565 {
	static int[] dp = new int[501];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		ArrayList<Elements> arr = new ArrayList<>();
		StringTokenizer st ;
		while(n-- > 0) {
			st = new StringTokenizer(br.readLine()," ");
			arr.add(new Elements(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		Collections.sort(arr);
		int max = 0;
		dp[0] = 1;
		for(int i = 1; i<arr.size(); i++) {
			dp[i] = 1;
			for(int j = 0; j<i; j++) {
				if(arr.get(i).b > arr.get(j).b && dp[j]+1 > dp[i]) dp[i] = dp[j]+1;
			}
			max = max < dp[i] ? dp[i] : max;
		}
		System.out.println(arr.size() - max);
	}
	
	static class Elements implements Comparable<Elements>{
		int a, b;
		public Elements(int a, int b) {
			this.a = a;
			this.b = b;
		}
		@Override
		public int compareTo(Elements o1) {
			if(this.a > o1.a) return 1;
			else return -1;
		}
	}
}
