package beakjoon;

// 큐 : https://www.acmicpc.net/problem/10845

import java.util.*;
import java.io.*;

public class Main30 {
	static int[] queue = new int[100000];
	static int begin = 0;
	static int end = 0;
	public static void main(String[] args) throws IOException {
		Main30 m = new Main30();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine().trim());
		
		for(int i = 0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			String func = st.nextToken();
			switch(func) {
				case "push": m.push(Integer.parseInt(st.nextToken())); break;
				case "pop" : bw.write(m.pop()+"\n"); break;
				case "front" : bw.write(m.front()+"\n"); break;
				case "back" : bw.write(m.back()+"\n"); break;
				case "size" : bw.write(m.size()+"\n"); break;
				case "empty" : bw.write(m.empty()+"\n"); break;
			}
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	public void push(int data) {
		queue[end] = data;
		end++;
	}
	
	public int pop() {
		if(end - begin != 0) {
			int data = queue[begin];
			queue[begin] = 0;
			begin++;
			return data;
		}
		else return -1;
	}
	
	public int front() {
		return end - begin != 0 ? queue[begin] : -1;
	}
	
	public int back() {
		return end - begin != 0 ? queue[end-1] : -1;
	}
	
	public int size() {
		return end - begin;
	}
	
	public int empty() {
		return end - begin == 0 ? 1: 0;
	}

}
