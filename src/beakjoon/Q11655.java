package beakjoon;

import java.io.*;
import java.util.*;
public class Q11655 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder str = new StringBuilder(br.readLine());
		for(int i = 0; i<str.length(); i++) {
			if(str.charAt(i) >='A' && str.charAt(i) <='Z') {
				if(str.charAt(i)+13 > 'Z') str.setCharAt(i, (char)(str.charAt(i)+13-26));
				else str.setCharAt(i, (char)(str.charAt(i)+13));
			}
			else if(str.charAt(i) >='a' && str.charAt(i) <='z') {
				if(str.charAt(i)+13 > 'z') str.setCharAt(i, (char)(str.charAt(i)+13-26));
				else str.setCharAt(i, (char)(str.charAt(i)+13));
			}
		}
		bw.write(str.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}
