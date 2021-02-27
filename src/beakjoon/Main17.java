package beakjoon;

import java.util.*;

public class Main17 {
	static int ans = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] puddles = {{2,2}};
		int m = 4;
		int n = 3;
		int[][] d = new int[n+1][m+1];
        d[1][1] = 1;
        
        for(int[] p : puddles) {
        	d[p[1]][p[0]] = -1;
        }
        
        for(int i = 1; i<=n; i++) {
        	for(int j = 1; j<=m; j++) {
                if(d[i][j] == -1) d[i][j] = 0;
                else{
                    if(i == 1) d[i][j] += d[i][j-1];
                    else d[i][j] =( d[i][j-1]+d[i-1][j] )%1000000007;
                }
        	}
        }
        
        System.out.println(d[n][m]);

	}

}
