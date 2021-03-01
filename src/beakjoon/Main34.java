package beakjoon;

//동물원 : https://www.acmicpc.net/problem/1309

import java.io.*;

public class Main34 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int mod = 9901;
		// 0:  x| x, 1: x | o, 2: o | x
		
		int N = Integer.parseInt(br.readLine());
		
		long[][] d = new long[N][3];
		
		d[0][0] = 1; d[0][1] = 1; d[0][2] = 1;
		
		for(int i = 1; i<N; i++) {
			d[i][0] = (d[i-1][0] + d[i-1][1] + d[i-1][2])%mod;
			d[i][1] = (d[i-1][0] + d[i-1][2])%mod;
			d[i][2] = (d[i-1][0] + d[i-1][1])%mod;
		}
		
		bw.write((d[N-1][0]+d[N-1][1]+d[N-1][2])%mod + "");
		
		bw.flush();
		bw.close();
		br.close();
	}

}
