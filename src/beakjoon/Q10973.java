package beakjoon;

//이전 순열 : https://www.acmicpc.net/problem/10973

import java.io.*;
import java.util.StringTokenizer;

public class Q10973 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int[] nums = new int[N];
		for(int i = 0; i<N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		if(prev_permutation(nums)) {
			for(int i = 0; i<N; i++) {
				bw.write(nums[i]+" ");
			}
			bw.write("\n");
		}
		else {
			bw.write("-1");
		}
		
		bw.flush();
		bw.close();
		br.close();
		
	}
	
	static boolean prev_permutation(int[] a) {
		int i = a.length-1;
		while( i > 0 && a[i-1] <= a[i]) i-=1;
		if(i <= 0) return false; 
		int j = a.length-1;
		while(a[j] >= a[i-1]) j-=1;
		int temp = a[i-1];
		a[i-1] = a[j];
		a[j] = temp;
		j=a.length-1;
		while(i < j) {
			temp = a[i];
			a[i] = a[j];
			a[j] = temp;
			i +=1;
			j -=1;
		}
		return true;
	}

}
