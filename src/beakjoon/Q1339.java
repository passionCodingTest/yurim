package beakjoon;

//단어 수학 : 1339번 

import java.util.*;
public class Q1339 {
	static int[] alpha = new int[256];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String[] a = new String[n];
		HashSet<Character> s = new HashSet<>();
		for(int i =0; i<n; i++) {
			a[i] = sc.next();
			for(char x : a[i].toCharArray()) {
				s.add(x);
			}
		}
		Character[] letters = s.toArray(new Character[s.size()]);
		int m = letters.length;
		int[] d = new int[m];
		for(int i = 0; i<m; i++) {
			d[i] = 9-i;
		}
		Arrays.sort(d);
		int ans = 0;
		do {
			int now = calc(a, letters, d);
			if(ans < now) ans = now;
		}while(next_permutation(d));
		System.out.println(ans);
	}
	
	static int calc(String[] a, Character[] letters, int[] d) {
		int sum = 0;
		int m = letters.length;
		for(int i = 0; i<m; i++) {
			alpha[letters[i]] = d[i];
		}
		for(String s : a) {
			int now = 0;
			for(char x : s.toCharArray()) {
				now = now*10 + alpha[x];
			}
			sum += now;
		}
		return sum;
	}
	
	static boolean next_permutation(int[] arr) {
		int i = arr.length-1;
		while(i > 0 && arr[i-1] >= arr[i]) {
			i -= 1;
		}
		if(i<=0) return false;
		int j = arr.length-1;
		while(arr[j] <= arr[i-1]) {
			j -=1;
		}
		int temp = arr[i-1];
		arr[i-1] = arr[j];
		arr[j] = temp;
		
		j = arr.length -1;
		while(i < j) {
			temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			i+=1;
			j-=1;
		}
		return true;
	}
}
