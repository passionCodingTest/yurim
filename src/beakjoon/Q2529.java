package beakjoon;

//부등호 : 2529

import java.util.*;
public class Q2529 {
	static String[] ineq;
	static String maxStr = "";
	static String minStr = "";
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		String input = sc.nextLine();
		ineq = input.split(" ");
		int[] max = new int[n+1];
		int[] min = new int[n+1];
		int[] arr = new int[n+1];
		for(int i = 0; i<n+1; i++) {
			max[i] = 9-(n-i);
			min[i] = i;
		}
		
		per1(max, 0, n+1, n+1);
		per1(min, 0, n+1, n+1);
		
		System.out.println(maxStr+"\n"+minStr);
	}
	static void per1(int[] arr, int depth, int n, int r) {
		if(depth == r) {
			boolean check = false;
			for(int i = 0; i<ineq.length; i++) {
				switch(ineq[i]) {
					case "<" : check = arr[i] < arr[i+1] ? true : false; break;
					case ">" : check = arr[i] > arr[i+1] ? true : false; break;
				}
				if(!check) return;
			}
			
			if(check) {
				String a = "";
				for(int i : arr) {
					a += i;
				}
				if(minStr == "" || minStr.compareTo(a) > 0) minStr = a;
				if(maxStr == "" || maxStr.compareTo(a) < 0) maxStr = a;
			}
			return;
		}
		for(int i = depth; i<n; i++) {
			swap(arr, depth, i);
			per1(arr, depth+1, n, r);
			swap(arr, depth, i);
		}
	}
	
	static void swap(int[] arr, int depth, int i) {
		int temp = arr[depth];
		arr[depth] = arr[i];
		arr[i] = temp;
	}

}
