package beakjoon;


//2×n 타일링 :https://www.acmicpc.net/problem/11726

import java.util.*;
import java.io.*;

public class Main19 {
	public static void main(String[] args) throws IOException  {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine().trim());
		long[] d = new long[1001];
		d[1] = 1;
		d[2] = d[1]+1;
		for(int i = 3; i <= N; i++) {
			d[i] = (d[i-1] + d[i-2])%10007;
		}
		bw.write(d[N]+"");
		
		bw.flush();
		bw.close();
		br.close();
	}

}
