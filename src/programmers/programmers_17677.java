package programmers;

//뉴스 클러스터링 : 프로그래머스 - 17677번 

import java.util.*;
public class programmers_17677 {

	public static void main(String[] args) {
		System.out.println(solution("FRANCE","french"));
		System.out.println(solution("handshake","shake hands"));
		System.out.println(solution("aa1+aa2","AAAA12"));
		System.out.println(solution("E=M*C^2","e=m*c^2"));
	}
	static public int solution(String str1, String str2) {
        int answer = 0;
        ArrayList<String> arr1 = new ArrayList<>();
        ArrayList<String> arr2 = new ArrayList<>();
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        int range = str1.length()%2 == 0 ? str1.length() : str1.length()-1;
        while(str1.length()>1){
        	if(!str1.substring(0,2).matches(".*[^a-zA-Z].*")) arr1.add(str1.substring(0,2));
            str1 = str1.substring(1,str1.length());
        }
        while(str2.length() > 1){
        	if(!str2.substring(0,2).matches(".*[^a-zA-Z].*")) arr2.add(str2.substring(0,2));
            str2 = str2.substring(1,str2.length());
        }
        answer = (int)Math.floor(JaCard(arr1, arr2)*65536);
        return answer;
    }
    static public double JaCard(ArrayList<String> arr1, ArrayList<String> arr2){
        double same = 0;
        double total = arr1.size() + arr2.size();
        if(arr1.size() == 0 && arr2.size() == 0) return 1;
        for(int i = 0; i<arr1.size(); i++) {
        	for(int j = 0; j<arr2.size(); j++) {
        		if(arr1.get(i).equals(arr2.get(j))) {
        			same+=1;
        			arr1.remove(i);
        			arr2.remove(j);
        			i--;
        			break;
        		}
        	}
        }
        return same/(total-same);
    }

}
