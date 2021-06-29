package beakjoon;
import java.util.*;
public class Q10835 {
	static int ans = 0, k;
	static int[] left, right;
	public static void main (String[] args){
		Scanner sc = new Scanner(System.in);
		k = sc.nextInt();
		left = new int[k]; right = new int[k];
		for(int i = 0; i<k; i++) left[i] = sc.nextInt();
		for(int i = 0; i<k; i++) right[i] = sc.nextInt();
		//조건 : 언제든지 left 혹은 left&right를 버릴 수 있다. *이때 점수는 없다*
		//조건 : left > right : right만 담기 *점수 획득*
//		go(0,0,0,0);
		
		//왼쪽 : 오른
		int[][] dp= new int[k][k];
		int l=0,r=0;
		while(l<k&&r<k) {
		}
		System.out.println(ans);
	}
//	static public void go(int l, int r, int buket, int cnt){
//		if(l==k || r==k) {
//			ans = Math.max(ans, buket);
//			return;
//		}
//		int a = left[l];
//		int b = right[r];
//		if(a > b) {
//			//오른쪽 카드 버리기
//			go(l,r+1,buket+b,cnt+1);
//		}
//		else{
//			//왼쪽만 버리기
//			go(l+1, r, buket, cnt+1);
//			//왼쪽 & 오른쪽 버리기
//			go(l+1, r+1, buket , cnt+1);
//		}
//	}
}
