package beakjoon;

import java.io.*;
import java.util.*;
public class Q1120 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		String a = st.nextToken();
		String b = st.nextToken();
		int len = b.length()-a.length();
		int answer = a.length();
		for(int i = 0; i <len+1; i++) {
			int cnt = 0;
			for(int j = 0; j<a.length(); j++) {
				if(a.charAt(j) != b.charAt(j+i)) cnt +=1;
			}
			if(answer > cnt) answer = cnt;
		}
		System.out.println(answer);
	}
}
