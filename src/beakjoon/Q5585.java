package beakjoon;

import java.util.*;
public class Q5585 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int money = 1000 - sc.nextInt();
		int[] extraMoney = {500, 100, 50, 10, 5, 1};
		int index = 0;
		int cnt = 0;
		while(money > 0) {
			if(money - extraMoney[index] >= 0) {
				cnt++;
				money -= extraMoney[index];
			}
			else index++;
			if(money == 0) break;
		}
		System.out.println(cnt);
	}

}
