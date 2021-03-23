package programmers;

//피보나치 

public class programmers_12945 {

	public static void main(String[] args) {
		System.out.println(solution(3));
		System.out.println(solution(5));
	}
	
	static public int solution(int n) {
        int mod = 1234567;
        int[] d = new int[n+1];
        d[0] = 0;
        d[1] = 1;
        for(int i = 2; i<=n; i++){
            d[i] = d[i-1]%mod + d[i-2]%mod;
        }
        return d[n]%mod;
    }

}
