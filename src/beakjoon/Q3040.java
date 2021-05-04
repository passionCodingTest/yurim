package beakjoon;

import java.util.*;
public class Q3040 {
	static boolean[] minian = new boolean[10];
	static int[] d = new int[10];
	static int total = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		for(int i = 0; i<9; i++) {
			d[i] = sc.nextInt();
			total+=d[i];
		}
		go(0,0,total);
	}
	static public void go(int index, int cnt, int sum) {
		if(index == 9 && cnt < 2 || sum < 100) return;
		if(cnt == 2) {
			if(sum == 100) {
				for(int i=0; i<9; i++) {
					if(!minian[i]) System.out.println(d[i]);
				}
				return;
			}
			return;
		}
		minian[index] = true;
		go(index+1, cnt+1, sum-d[index]);
		minian[index] = false;
		go(index+1, cnt, sum);
	}
}
