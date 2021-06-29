package beakjoon;
import java.util.*;
public class Q9663 {
	static int n;
	static int[] col;
	static int cnt = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		col = new int[n];
		go(0);
		System.out.println(cnt);
	}
	static public void go(int depth) {
		if(depth == n) {
			cnt +=1;
			return;
		}
		for(int i = 0; i<n; i++) {
			col[depth] = i;
			if(isPossible(depth)) {
				go(depth+1);
			}
		}
	}
	static public boolean isPossible(int depth) {
		for(int i = 0; i<depth; i++) {
			//i번째 퀸이 일직선상에 있는 경우
			//i번째 퀸의 위치가 depth위치의 퀸의 대각선상의 있는 경우.
				// 밑변의 길이와 높이가 같으면 대각선상에 있다고 볼 수 있다.
			if(col[i] == col[depth] || Math.abs(depth - i ) == Math.abs(col[depth]-col[i])) return false; 
		
		}
		return true;
	}
}
