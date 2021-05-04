package beakjoon;

import java.util.*;
public class Q11651 {
	static class Locate implements Comparable<Locate>{
		int x;
		int y;
		Locate(int x, int y){
			this.x = x;
			this.y = y;
		}
		@Override
		public int compareTo(Locate o) {
			// TODO Auto-generated method stub
			if(this.y == o.y) return Integer.compare(this.x, o.x);
			else return Integer.compare(this.y, o.y);
		}
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<Locate> arr = new ArrayList<>();
		for(int i = 0; i<n ; i++) {
			arr.add(new Locate(sc.nextInt(), sc.nextInt()));
		}
		Collections.sort(arr);
		for(Locate l : arr) {
			System.out.println(l.x +" "+l.y);
		}
	}

}
