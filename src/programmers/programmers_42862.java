package programmers;

import java.util.*;
class programmers_42862 {
	public static void main(String[] args) {
		programmers_42862 m = new programmers_42862();
		System.out.println(m.solution(5, new int[] {2,4}, new int[] {1,3,5}));
		System.out.println(m.solution(5, new int[] {2,4}, new int[] {3}));
		System.out.println(m.solution(3, new int[] {3}, new int[] {1}));
	}
	
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] student = new int[n+1];
        for(int i : lost){
            student[i] -=1;
        }
        for(int j : reserve){
            student[j] +=1;
        }
        
        for(int i = 1; i<=n; i++){
            if(student[i] == 0 || student[i] == 1) continue;
            if(student[i] == -1){
                if(i-1 >= 1 && student[i-1] == 1){
                    student[i-1] = 0;
                    student[i] = 0;
                    continue;
                }
                if(i+1 <= n && student[i+1] == 1){
                    student[i+1] = 0;
                    student[i] = 0;
                    continue;
                }
            }
        }
        
        for(int i = 1; i<=n; i++){
            if(student[i] == -1) answer +=1;
        }
        
        return n-answer;
    }
}