package beakjoon;

// 암호 만들기 : https://www.acmicpc.net/problem/1759

import java.util.*;
import java.io.*;

public class Main14 {
	static ArrayList<String> passwordArr = new ArrayList<>();
	static ArrayList<String> alpha = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		Main14  m = new Main14();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		StringTokenizer st2 = new StringTokenizer(br.readLine()," ");
		int L = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		
		for(int i = 0; i<C; i++) {
			alpha.add(st2.nextToken());
		}
		
		Collections.sort(alpha);
		
		m.go(L, alpha, "", 0);
		
		for(String pwd : passwordArr) {
			System.out.println(pwd);
		}
		
		br.close();
	}
	
	public void go(int L, ArrayList<String> alpha, String password, int index) {
		if(L==password.length()) {
			if(check(password))
				if(!passwordArr.contains(password)) passwordArr.add(password);
		}
		if(index >= alpha.size()) return ;
		go(L, alpha, password+alpha.get(index), index+1);
		go(L, alpha, password, index+1);
	}
	
	public boolean check(String password) {
		int ja = 0;
		int mo = 0;
		for(char x : password.toCharArray()) {
			if(x == 'a' || x == 'i' || x == 'e' || x == 'o' || x == 'u') {
				mo +=1;
			}else {
				ja +=1;
			}
		}
		
		return mo >=1 && ja >= 2;
	}
}
