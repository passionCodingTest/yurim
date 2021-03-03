package programmers;

//나누어 떨어지는 숫자 배 : https://programmers.co.kr/learn/courses/30/lessons/12910?language=java
//연습문제 

import java.util.*;

public class programmers_12910 {
	public int[] solution(int[] arr, int divisor) {
	      ArrayList<Integer> d = new ArrayList<>();
	      for(int a : arr){
	          if(a%divisor == 0) d.add(a); 
	      }
	      
	      Collections.sort(d);
	      if(d.size() == 0) d.add(-1);
	      
	      int[] answer = new int[d.size()];
	      
	      for(int a : d){
	          answer[d.indexOf(a)] = a;
	      }
	      
	      return answer ;
	    
	}

}
