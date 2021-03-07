package beakjoon;

//부등호 : https://www.acmicpc.net/problem/2529

import java.io.*;
import java.util.*;

public class Q2529 {
	static boolean[] check = new boolean[10];
	static String[] sign;
	static int k;
	static ArrayList<String> ok = new ArrayList<>();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		k = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		sign = new String[k];
		for(int i = 0; i< k; i++) {
			sign[i] = st.nextToken();
		}
		
		go(0, "");
		
		Collections.sort(ok);
		
		bw.write(ok.get(ok.size()-1)+"\n");
		bw.write(ok.get(0));
		
		bw.flush();
		bw.close();
		br.close();
	}
	static void go(int index, String nums) {
		if(index == k+1) {
			ok.add(nums);
			return ;
		}
		for(int i = 0; i<= 9 ; i++) {
			if(check[i]) continue;
			if(index == 0 || checking(nums.charAt(index-1), (char) (i+'0'), sign[index-1])) {
				check[i] = true;
				go(index+1, nums+i);//숫자 포함 
				check[i] = false;
			}
		}
		
	}
	
	static boolean checking(char a, char b, String op) {
		if(op == ">") {
			if(a < b) return false;
		}
		if(op == "<"){
			if(a > b) return false;
		}
		return true;
	}
}
