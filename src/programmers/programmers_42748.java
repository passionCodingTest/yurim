package programmers;

//K번째 수 : https://programmers.co.kr/learn/courses/30/lessons/42748?language=java

//level 1 

import java.util.*;

public class programmers_42748 {
	public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int n = 0;
        for(int[] c : commands){
            ArrayList<Integer> a = new ArrayList<>();
            int i = c[0];
            int j = c[1];
            int k = c[2];
            
            for(int index = i-1; index < j; index++ ){
                a.add(array[index]);
            }
            Collections.sort(a);
            answer[n++] = a.get(k-1);
        }
        return answer;
    }
}
