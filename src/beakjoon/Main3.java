package beakjoon;

//퇴사 : https://www.acmicpc.net/problem/14501

import java.io.*;
import java.util.*;

public class Main3 {
	public static int ans = 0;
	public static void main(String[] args) throws IOException {
		Main3 m = new Main3();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        
        int[] T = new int[N];
        int[] P = new int[N];
        
        for(int i = 0; i<N; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        	T[i] = Integer.parseInt(st.nextToken());
        	P[i] = Integer.parseInt(st.nextToken());
        }
        m.go(T, P, 0, 0, N);
        
        bw.write(ans+"");
        
	    bw.flush();
	    bw.close();
	    br.close();
	}
	
	public void go(int[] T, int[] P, int sum, int day, int N) {
		if(day == N) {
			if(ans < sum) ans = sum;
			return;
		}
		if(!(day+T[day] > N)) go(T, P, sum+P[day], day+T[day], N); // 선택
		go(T, P, sum, day+1, N); //선택 안함
	}

}
