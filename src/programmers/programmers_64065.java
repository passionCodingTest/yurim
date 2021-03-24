package programmers;

//튜플 : https://programmers.co.kr/learn/courses/30/lessons/64065?language=java

import java.util.*;

public class programmers_64065 {
	
	public static void main(String[] args) {
		solution("{{2},{2,1},{2,1,3},{2,1,3,4}}"); //[2, 1, 3, 4]
		solution("{{1,2,3},{2,1},{1,2,4,3},{2}}"); //[2, 1, 3, 4]
		solution("{{20,111},{111}}"); //[111,20]
		solution("{{123}}"); //[123]
		solution("{{4,2,3},{3},{2,3,4,1},{2,3}}"); //[3,2,4,1]
	}
	
	static public int[] solution(String s) {
		String str = s.substring(2, s.length()-2);
        String[] strArr = str.split("\\},\\{");
        ArrayList<String> result = new ArrayList<>();
        ArrayList<String> arr = new ArrayList<>(Arrays.asList(strArr));
        Collections.sort(arr,new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if(s1.length() < s2.length()) return -1;
                else if(s1.length() > s2.length()) return 1;
                return 0;
            }
        });
        for(String a : arr) {
        	String[] num = a.split(",");
        	for(int i = 0; i <num.length; i++) {
        		if(!result.contains(num[i])) result.add(num[i]);
        	}
        }
        int[] answer = new int[result.size()];
        for(int i = 0; i<result.size(); i++) {
        	answer[i] = Integer.parseInt(result.get(i));
        }
        return answer;
    }

}
