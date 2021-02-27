package beakjoon;

//이친수 : https://www.acmicpc.net/problem/2193

import java.io.*;

public class Main27 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int max = 90;
		
		int N = Integer.parseInt(br.readLine().trim());
		
		long[] d = new long[N+1];
		d[0] = 0;
		d[1] = 1;
		for(int i = 2; i<= N; i++) {
			d[i] = d[i-1] + d[i-2]; 
			// 맨 끝자리(i번째 )가 0일 때 i-1번째의 숫자는 상관 없다,
			// 맨 끝자리(i번째 )가 1일 때 i-1번쨰의 숫자는 반드시 0이여야 함으로 i-2번째 고려값 더하면 된다.
		}
		
		bw.write(d[N]+"");
		
		bw.flush();
		bw.close();
		br.close();

	}

}
