package beakjoon;

import java.io.*;
import java.util.*;

public class Main2 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine().trim());
        int sum = 0;
        int decomposition = 0;
        for(int i = 1; i<=N; i++) {
        	sum = i;
        	int a = i;
        	while(a/10 != 0) {
        		sum += a%10;
        		a = a/10;
        	}
        	sum += a;
        	if(sum == N) {decomposition = i; break;}  
    	}
        
        bw.write(decomposition+"\n");
        
        bw.flush();
        bw.close();
        br.close();
	}
}
