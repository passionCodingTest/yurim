package beakjoon;

//1, 2, 3 더하기 : https://www.acmicpc.net/problem/9095

import java.io.*;

public class Main21 {

	public static void main(String[] args)  throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int testCase = Integer.parseInt(br.readLine().trim());
		long[] d = new long[12];
		d[1] = 1;
		d[2] = 2;
		d[3] = 4;
		for(int i = 4; i<=11; i++ ) {
			d[i] = d[i-1] + d[i-2] + d[i-3];
		}
		
		for(int i = 0; i<testCase; i++) {
			int N = Integer.parseInt(br.readLine().trim());
			bw.write(d[N]+"\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}

}
