package beakjoon;

//16198번 에너지 모으기 

import java.util.*;
public class Q16198 {
	static int max = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> energy = new ArrayList<>();
		int n = sc.nextInt();
		for(int i = 0; i<n; i++) {
			energy.add(sc.nextInt());
		}
		for(int i = 1; i<n-1; i++) {
			ArrayList<Integer> cpEnergy = new ArrayList<>();
			cpEnergy.addAll(energy);
			collect(i, 0, cpEnergy);
		}
		System.out.println(max);
	}
	
	static void collect(int x, int sum, ArrayList<Integer> cpenergy) {
		if(cpenergy.size() > 2) sum += ((int)cpenergy.get(x-1)*(int)cpenergy.get(x+1));
		cpenergy.remove(x);
		if(cpenergy.size() == 2) {
			if(max < sum)max = sum;
			return;
		}
		for(int i = 1; i<cpenergy.size()-1; i++) {
			int a = cpenergy.get(i);
			collect(i, sum, cpenergy);
			cpenergy.add(i,a);
		}
	}
}
