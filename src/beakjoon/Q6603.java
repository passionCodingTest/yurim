package beakjoon;

//로또 : https://www.acmicpc.net/problem/6603

import java.util.*;

public class Q6603 {
	static int N ;
	static ArrayList<Integer> arr = new ArrayList<>();
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		while(s.hasNext()) {
			String input = s.nextLine();
			if(input == "0") break;
			String[] strArr = input.split(" ");
			int testcase = Integer.parseInt(strArr[0]);
			int[] a = new int[testcase];
			for(int i = 0; i<testcase; i++) {
				a[i] = Integer.parseInt(strArr[i+1]);
			}
			go(a,0,0);
			System.out.println();
		}
	}
	
	static public void go(int[] a, int index,int cnt) { //a[0] ~ a[n-1] a[index] 선택 o,x cnt로 선택갯수확인 
		if(cnt == 6) {
			for(int n : arr) {
				System.out.print(n+" ");
			}
			System.out.println();
			return;
		}
		if(index == a.length) return;
		arr.add(a[index]);
		go(a, index+1, cnt+1); //선택 함  
		arr.remove(arr.size()-1);
		go(a, index+1, cnt);// 선택 안함 
	}

}
