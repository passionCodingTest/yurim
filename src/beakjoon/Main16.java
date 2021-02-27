package beakjoon;

//프로그래머스 

public class Main16 {
	static int ans = 0;
	static int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
	public static void main(String[] args) {
		int[][] dp = new int[triangle.length][triangle.length];
        dp[0][0] = triangle[0][0];
        for(int i = 1; i<triangle.length; i++){
            dp[i][0] = dp[i-1][0] + triangle[i][0];
            dp[i][i] = dp[i-1][i-1] + triangle[i][i];
        }
        
        for(int i = 2; i<triangle.length; i++){
            for(int j = 1; j<i; j++){
                dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j])+triangle[i][j];
            }
        }
        
        int max = 0;
        
        for(int i = 0; i<dp.length; i++){
            max = Math.max(max, dp[dp.length-1][i]);
        }
        
        System.out.println(max);
	}
}
