package beakjoon;

//1, 2, 3 더하기 : https://www.acmicpc.net/problem/9095

import java.util.*;

public class Main13 {

	public static void main(String[] args) {
		Main13 m = new Main13();
		Scanner sc = new Scanner(System.in);
		
		int testCase = sc.nextInt();
		
		for(int i= 0; i<testCase; i++) {
			int goal = sc.nextInt();
			System.out.println(m.go(0,0,goal));
		}

	}
	
	public int go(int count, int sum, int goal) {
		if(sum > goal) return 0;
		else if(sum == goal) return 1;
		int now = 0;
		for(int i = 1; i<= 3; i++) {
			now += go(count+1, sum+i, goal);
		}
		
		return now;
	}

}
