package beakjoon;

import java.io.*;
import java.util.*;
public class Q1107 {
	static int m,r,ans;
	static String n;
	static boolean[] usedButton = new boolean[10];
	static StringTokenizer st ;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		n = br.readLine();
		ans = Math.abs(100 - Integer.parseInt(n));
		m = Integer.parseInt(br.readLine());
		r = n.length();
		if(m > 0) st = new StringTokenizer(br.readLine()," ");
		for(int i = 0; i < m; i++) {
			usedButton[Integer.parseInt(st.nextToken())] = true;
		}
		go(sb);
		System.out.println(ans);
	}
	static void go(StringBuffer sb) {
		if(sb.length() != 0) ans = Math.min(ans, getMoveCount(sb));
		if(sb.length() == r+1) return ;
		for(int i = 0; i<10; i++) {
			if(usedButton[i]) continue;
			sb.append(i+"");
			go(sb);
			sb.deleteCharAt(sb.length()-1);
		}
	}
	static int getMoveCount(StringBuffer sb) {
		int wantChannel = Integer.parseInt(n);
		int channel = Integer.valueOf(sb.toString());
		return Math.abs(wantChannel-channel)+sb.length();
	}
}
