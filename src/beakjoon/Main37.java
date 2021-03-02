package beakjoon;

//제곱수의 합 : https://www.acmicpc.net/problem/1699

import java.io.*;

public class Main37 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		long[] d = new long[N+1];
		
		
		for(int i = 1; i<=N; i++) {
			d[i] = i;
			for(int j = 1; j*j<=i; j++) {
				if(d[i] > d[i-(j*j)]+1)
					d[i] =  d[i-(j*j)]+1;
			}
		}
		
		bw.write(d[N]+"");
		
		bw.flush();
		bw.close();
		br.close();
	}

}
