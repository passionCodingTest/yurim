package beakjoon;

//알파벳 개수 
import java.util.*;
public class Q10808 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		int[] d = new int[26];
		for(int i = 0; i<str.length(); i++) {
			d[str.charAt(i)%'a'] +=1;
		}
		for(int i : d) {
			System.out.print(i+" ");
		}
	}

}
