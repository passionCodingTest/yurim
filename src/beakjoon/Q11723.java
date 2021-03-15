package beakjoon;

// 집합  :https://www.acmicpc.net/problem/11723

import java.util.*;
import java.io.*;


@SuppressWarnings("deprecation")
public class Q11723 {
	static ArrayList<Integer> arr = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int cnt = Integer.parseInt(br.readLine());
		for(int i = 0; i<cnt; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			String op = st.nextToken();
			switch(op) {
				case "add" : add(Integer.parseInt(st.nextToken())); break;
				case "remove" : remove(Integer.parseInt(st.nextToken())); break;
				case "toggle" : toggle(Integer.parseInt(st.nextToken())); break;
				case "check" : bw.write(check(Integer.parseInt(st.nextToken()))+"\n"); break;
				case "all" : all(); break;
				case "empty" : empty(); break;
			}
		}
		
		bw.flush();
		bw.close();
		br.close();

	}
	
	static public void add(int n) {
		if(!arr.contains(n)) arr.add(n);
	}
	
	static public void remove(int n) {
		if(arr.contains(n)) arr.remove(new Integer(n));
	}
	
	static public int check(int n) {
		if(arr.contains(n)) return 1;
		else return 0;
	}
	
	static public void toggle(int n) {
		if(arr.contains(n)) remove(n);
		else add(n);
	}
	
	static public void all() {
		arr.clear();
		for(int i = 1; i<21; i++) {
			arr.add(i);
		}
	}
	
	static public void empty() {
		arr.clear();
	}

}
