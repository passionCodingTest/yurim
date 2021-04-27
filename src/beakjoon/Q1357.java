package beakjoon;

import java.io.*;
import java.util.*;
public class Q1357 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		StringBuilder x = new StringBuilder(st.nextToken());
		StringBuilder y = new StringBuilder(st.nextToken());
		int intX = Integer.valueOf(x.reverse().toString());
		int intY = Integer.valueOf(y.reverse().toString());
		StringBuilder sum = new StringBuilder(intX+intY+"");
		bw.write(Integer.valueOf(sum.reverse().toString())+"\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
