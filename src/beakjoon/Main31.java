package beakjoon;

//덱 : https://www.acmicpc.net/problem/10866

import java.io.*;
import java.util.*;

public class Main31 {
	static int[] deque = new int[100000];
	static int begin = 0;
	static int end = 0;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Main31 m = new Main31();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine().trim());
		
		for(int i = 0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			String func = st.nextToken();
			switch(func) {
				case "push_back": m.push_back(Integer.parseInt(st.nextToken())); break;
				case "push_front": m.push_front(Integer.parseInt(st.nextToken())); break;
				case "pop_front" : bw.write(m.pop_front()+"\n"); break;
				case "pop_back" : bw.write(m.pop_back()+"\n"); break;
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
	
	public void push_back(int data) {
		deque[end] = data;
		end++;
	}
	
	public void push_front(int data) {
		if(begin == 0) {
			for(int i = end-1; i >= 0; i--) {
				int temp = deque[i];
				deque[i+1] = temp;
			}
			deque[0] = data;
			end++;
		}else {
			deque[begin-1] = data;
			begin--;
		}
	}
	
	public int pop_front() {
		if(end - begin != 0) {
			int data = deque[begin];
			deque[begin] = 0;
			begin++;
			return data;
		}
		else return -1;
	}
	
	public int pop_back() {
		if(end - begin != 0) {
			int data = deque[end-1];
			deque[end-1] = 0;
			end--;
			return data;
		}
		else return -1;
	}
	
	public int front() {
		return end - begin != 0 ? deque[begin] : -1;
	}
	
	public int back() {
		return end - begin != 0 ? deque[end-1] : -1;
	}
	
	public int size() {
		return end - begin;
	}
	
	public int empty() {
		return end - begin == 0 ? 1: 0;
	}

}
