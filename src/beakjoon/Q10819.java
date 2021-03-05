package beakjoon;

//차이를 최대로 : https://www.acmicpc.net/problem/10819

import java.io.*;
import java.util.*;

public class Q10819 {
	static int ans = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[] nums = new int[N];
		for(int i = 0; i<N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(nums);
		do {
			int temp = calc(nums);
			ans = Math.max(temp, ans);
		}while(next_permutation(nums));
		
		bw.write(ans+"");
		
		bw.flush();
		bw.close();
		br.close();

	}
	static int calc(int[] a) {
		int sum = 0;
		for(int i = 1; i<a.length; i++) {
			sum += Math.abs(a[i-1] - a[i]);
		}
		return sum;
	}
	
	static boolean next_permutation(int[] a) {
		int i = a.length-1;
		while(i > 0 && a[i-1] >= a[i]) i-=1;
		if(i<=0) return false;
		int j = a.length-1;
		while(a[j] <= a[i-1]) {
			j -=1;
		}
		int temp = a[i-1];
		a[i-1] = a[j];
		a[j] = temp;
		j = a.length-1;
		while(i < j) {
			temp = a[i];
			a[i] = a[j];
			a[j] = temp;
			i+=1;
			j-=1;
		}
		return true;
	}

}
