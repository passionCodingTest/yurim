package beakjoon;

//제로 
import java.util.*;

public class Q10773 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack<Integer> st = new Stack<>();
		int n = sc.nextInt();
		while(n > 0) {
			int o = sc.nextInt();
			if(o != 0) st.add(o);
			else st.pop();
			n--;
		}
		if(st.isEmpty()) System.out.println("0");
		else {
			int sum = 0;
			while(!st.isEmpty()) {
				sum += st.pop();
			}
			System.out.println(sum);
		}
	}

}
