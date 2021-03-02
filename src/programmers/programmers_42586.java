package programmers;

//기능 개발 : https://programmers.co.kr/learn/courses/30/lessons/42586?language=java
//level 2

import java.util.*;

public class programmers_42586 {

	public static void main(String[] args) {
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		int[] progresses = {93,30,55};
		int[] speeds = {1,30,5};
		
        int[] deployDay = new int[progresses.length+1];
        for(int i = 1; i<= progresses.length; i++){
            if((100 - progresses[i-1])%speeds[i-1] != 0) deployDay[i] = (100 - progresses[i-1])/speeds[i-1]+1;
            else deployDay[i] = (100 - progresses[i-1])/speeds[i-1];
            if( i>1 && deployDay[i-1] > deployDay[i]) deployDay[i] = deployDay[i-1] ;
        }
        
        for(int i = 1; i<deployDay.length; i++){
            if(!map.containsKey(deployDay[i])){
                map.put(deployDay[i], 1);
            }else{
                map.put(deployDay[i], map.get(deployDay[i])+1);
            }
        }
        
        int a = 0;
        int[] answer = new int[map.size()];
        Object[] keys = map.keySet().toArray();
        Arrays.sort(keys);
        for(Object key : keys){
            answer[a] = map.get((int)key);
            a++;
        }
        for(int i = 0; i<answer.length; i++) {
        	System.out.print(answer[i]);
        	if(i != answer.length -1 ) System.out.print(" ");
        }
	}

}
