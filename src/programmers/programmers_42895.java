package programmers;

//https://programmers.co.kr/learn/courses/30/lessons/42895
//level 3

public class programmers_42895 {
	static int[] d ;
	static int ans = -1;
	public static void main(String[] args) {
		programmers_42895 m = new programmers_42895();
		int N = 5;
		int number = 12;
        d = new int[9];
        
        d[0] = 0;
        d[1] = N;
        for(int i = 2; i<d.length; i++){
            d[i] = d[i-1] * 10 + N;
        }
        
        m.go(0, 0, number);
        
        System.out.println(ans);
        
	}
	
	public void go(int count, int num, int number) {
		if(count > 8 ) return ;
		if(num == number) {
			if(ans > count || ans == -1) ans = count;
			return;
		}
		for(int i = 1; i < 8; i++) {
			go(count+i, num + d[i], number);
			go(count+i, num - d[i], number);
			go(count+i, num * d[i], number);
			go(count+i, num / d[i], number);
		}
	}

}
