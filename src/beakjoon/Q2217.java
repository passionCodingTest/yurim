package beakjoon;

import java.util.*;
public class Q2217 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int answer = 0;
		ArrayList<Integer> w = new ArrayList<>();
		for(int i = 0; i<n; i++) {
			w.add(sc.nextInt());
		}
		Collections.sort(w);
		for(int i = w.size()-1; i >= 0; i--) {
			int sum = w.get(i)*(w.size()-i);
			for(int j = i-1; j>=0; j--) {
				if(w.get(i) > w.get(j)) break;
				sum += w.get(i);
			}
			answer = answer > sum ? answer : sum;
		}
		System.out.println(answer);
	}
}
