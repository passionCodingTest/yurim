package beakjoon;

//부분수열의 합 : https://www.acmicpc.net/problem/1182

import java.util.*;

public class Q1182 {
	static int ans = 0;
	static int N;
	static long S;
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String str = s.nextLine();
		StringTokenizer st = new StringTokenizer(str, " ");
		N = Integer.parseInt(st.nextToken());
		S = Long.parseLong(st.nextToken());
		int[] arr = new int[N];
		String str2 = s.nextLine();
		StringTokenizer st2 = new StringTokenizer(str2, " ");
		for(int i = 0; i<N; i++) {
			arr[i] = Integer.parseInt(st2.nextToken());
		}
		
		go(arr, 0, 0);
		if(S == 0) ans -=1; //아무것도 선택하지 않은 경우를 제외하기 위해 전체에서 -1함 
		
		System.out.println(ans);
		
	}
	static void go(int[] a, int index, long sum) {
		if(index == a.length) {
			if(sum == S) ans +=1;
			return;
		}
		go(a, index+1, sum+a[index]);
		go(a, index+1, sum);
	}
}
