package programmers;

import java.util.*;
public class programmers_17682 {

    static int[] d = new int[3];
	public static void main(String[] args) {
		System.out.println(solution("1S2D*3T"));
		System.out.println(solution("1D2S#10S"));
	}
	static public int solution(String dartResult) {
        int answer = 0;
        ArrayList<Integer> arr = new ArrayList<>();
        String[] bonusNOption = dartResult.split("[0-9]");
        for(int i = 0; i<dartResult.length(); i++){
            if(dartResult.charAt(i) >= '0' && dartResult.charAt(i) <= '9'){
                arr.add(Integer.parseInt(dartResult.substring(i,i+1)));
            }
        }
        for(int i = 0; i<3; i++){
            calc(arr.get(i), i, bonusNOption[i+1]);
        }
        answer = Arrays.stream(d).sum();
        return answer;
    }
    static public void calc(int a, int index, String bonus){
        if(bonus.charAt(0) == 'S'){
            d[index] = a;
        }else if(bonus.charAt(0) == 'D'){
        	d[index] = a*a;
        }else{
        	d[index] = a*a*a;
        }
        
        if(bonus.length() > 1){
            if(bonus.charAt(1) == '*'){
                if(index > 0){
                    d[index-1] *=2;
                }
                d[index] *=2;
            }
            if(bonus.charAt(1) == '#'){
                d[index] *=-1;
            }
        }
    }
}
