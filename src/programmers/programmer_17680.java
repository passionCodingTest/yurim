package programmers;

// 캐시 : 17680번 

import java.util.*;
public class programmer_17680 {

	public static void main(String[] args) {
		programmer_17680 s = new programmer_17680();
		System.out.println(s.solution(3, new String[] {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"}));
		System.out.println(s.solution(3, new String[] {"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"}));
		System.out.println(s.solution(2, new String[] {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"}));
		System.out.println(s.solution(5, new String[] {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"}));
		System.out.println(s.solution(2, new String[] {"Jeju", "Pangyo", "NewYork", "newyork"}));
		System.out.println(s.solution(0, new String[] {"Jeju", "Pangyo", "Seoul", "NewYork", "LA"}));
		System.out.println(s.solution(1, new String[] {"Jeju", "Pangyo", "Seoul", "NewYork", "LA"}));
		System.out.println(s.solution(5, new String[] {"Jeju", "Jeju", "Seoul", "Jeju", "LA"}));
		System.out.println(s.solution(2, new String[] {"Jeju", "Jeju", "Seoul", "Seoul", "Seoul"}));
		System.out.println(s.solution(2, new String[] {"Jeju", "Jeju", "Jeju", "Seoul", "LA"}));
	}
	public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        ArrayList<String> delArr = new ArrayList<String>();
        ArrayList<String> arr = new ArrayList<>();
        String outCity = "";
        if(cacheSize == 0) return cities.length*5;
        for(int i = 0; i<cities.length; i++){
            String city = cities[i].toLowerCase();
            if(!delArr.contains(city)) delArr.add(city);
            else {
                delArr.remove(city);
                delArr.add(city);
            }
            if(arr.size() < cacheSize){
                if(!arr.contains(city)){
                    arr.add(city);
                    answer +=5;
                    continue;
                }
                answer +=1;
            }else{
                if(arr.contains(city)){
                    answer +=1;
                    continue;
                }
                int min = 100000;
                String minStr = "";
                if(delArr.size() == 0){
                    delArr.add(arr.get(0));
                    arr.remove(0);
                }else{
                    for(int k = 0; k<arr.size(); k++){
                        if(delArr.indexOf(arr.get(k)) < min){
                            min = delArr.indexOf(arr.get(k));
                            minStr = arr.get(k);
                        }
                    }
                    if(min > -1) delArr.remove(minStr);
                    delArr.add(minStr);
                    arr.remove(minStr);
                }
                arr.add(city);
                answer +=5;
            }
            
        }
        return answer;
    }
}
