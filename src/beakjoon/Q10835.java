package beakjoon;
import java.io.*;
import java.util.*;
public class Q10835 {
	static int ans = 0, k;
	static int[] left, right;
	static int[][] dp;
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		k = Integer.parseInt(br.readLine());
		left = new int[k]; right = new int[k];
		dp = new int[k][k];
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for(int i = 0; i<k; i++) left[i] = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine()," ");
		for(int i = 0; i<k; i++) right[i] = Integer.parseInt(st.nextToken());
		for(int[] arr : dp){
			Arrays.fill(arr,-1);
		}
		ans = go(0,0);
		bw.write(ans+"");
		bw.flush();
		bw.close();
		br.close();
	}
	static public int go(int l, int r){
		if(l==k || r==k) return 0;
		if(dp[l][r] != -1) return dp[l][r];
		dp[l][r] = 0;
		
		int resultWithOutLeft = go(l+1, r);
		int resultWithOutLeftAndRight = go(l+1, r+1);
		
		int result = 0;
		if(left[l] > right[r]){
			result = right[r] + go(l, r+1);
		}
		return dp[l][r] = Math.max(resultWithOutLeft, Math.max(resultWithOutLeftAndRight, result));
	}
}
