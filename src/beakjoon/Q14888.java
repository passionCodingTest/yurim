package beakjoon;

//연산자 끼워넣기 : https://www.acmicpc.net/problem/14888
//memory = 19468kb, time = 172ms

import java.io.*;
import java.util.*;
public class Q14888 {
	static int N;
	static int[] operand;
	static long max = Long.MIN_VALUE;
	static long min = Long.MAX_VALUE;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		long sum = 0;
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		StringTokenizer st2 = new StringTokenizer(br.readLine()," ");
		operand = new int[N];
		int[] operator = new int[4];
 		for(int i = 0; i<N; i++) {
			operand[i] = Integer.parseInt(st.nextToken());
		}
 		for(int i = 0; i<4; i++) {
 			operator[i] = Integer.parseInt(st2.nextToken());
 		}
		dfs(1, operator[0], operator[1], operator[2], operator[3], operand[0]);
		
		bw.write(max+"\n"+min);
		bw.flush();
		bw.close();
		br.close();
	}
	
	static public void dfs(int index, int plus, int minus, int mul, int div, long sum) {
		if(plus == -1 || minus == -1 || mul == -1 || div == -1) return;
		if(index == N) {
			if(sum > max ) max = sum;
			if(sum < min ) min = sum;
			return ;
		}
		dfs(index+1, plus-1, minus, mul, div, sum+operand[index]);
		dfs(index+1, plus, minus-1, mul, div, sum-operand[index]);
		dfs(index+1, plus, minus, mul-1, div, sum*operand[index]);
		dfs(index+1, plus, minus, mul, div-1, sum/operand[index]);
	}

}
