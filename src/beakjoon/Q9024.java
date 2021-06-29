package beakjoon;

import java.util.*;
import java.io.*;
public class Q9024 {
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		while(tc-- > 0) {
			st = new StringTokenizer(br.readLine()," ");
			int n = Integer.parseInt(st.nextToken()), 
					k = Integer.parseInt(st.nextToken()), min = 200000000, cnt = 0;;
			int[] d = new int[n];
			st = new StringTokenizer(br.readLine()," ");
			for(int i=0; i<n; i++) {
				d[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(d);
			int left = 0, right = n-1;
			while(left < right) {
				int ans = d[left]+d[right];
				if(Math.abs(k-min) > Math.abs(k-ans)) {
					min = ans;
					cnt = 1;
				}else if(Math.abs(k-min) == Math.abs(k-ans)) cnt +=1;
				
				if(ans > k) right--;
				else left++;
			}
			System.out.println(cnt);
		}
	}
}
