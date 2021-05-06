package beakjoon;

import java.util.*;
public class Q2752 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] d = new int[3];
		for(int i = 0; i<3; i++) {
			d[i] = sc.nextInt();
		}
		Arrays.sort(d);
		System.out.print(d[0]+" "+d[1]+" "+d[2]);
	}

}
