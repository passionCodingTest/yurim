package beakjoon;

//부분 수열의 합 : https://www.acmicpc.net/problem/14225

import java.io.*;
import java.util.*;
public class Q14225 {
	static ArrayList<Long> arr = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[] a = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i<N; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		
		go(a, 0, 0);
		
		Collections.sort(arr);
		long ans = 0;
		int len = arr.size();
		for(int i = 0; i<len; i++) {
			if(i+1 < len) {
				if(arr.get(i+1) - arr.get(i) > 1) {
					ans = arr.get(i)+1;
					break;
				}
			}
		}
		
		bw.write((ans != 0 ? ans : arr.get(arr.size()-1)+1 )+ "");
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void go(int[] a , int index, long sum) {
		if(index == a.length) {
			arr.add(sum);
			return ;
		}
		go(a, index+1, sum+a[index]);
		go(a, index+1, sum);
	}
}
