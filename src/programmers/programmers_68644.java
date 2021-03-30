package programmers;

//68644 : 두 개 뽑아서 더하기 

import java.util.*;
public class programmers_68644 {

	public static void main(String[] args) {
		solution(new int[] {2,1,3,4,1});
		solution(new int[] {5,0,2,7});

	}
	static public int[] solution(int[] numbers) {
        ArrayList<Integer> arr = new ArrayList<>();
        int sum;
        int index = 0;
        for(int i = 0; i<numbers.length; i++){
            for(int j = i+1; j<numbers.length; j++){
                sum = numbers[i]+numbers[j];
                arr.add(sum);
            }
        }
        Collections.sort(arr);
        while(index+1 < arr.size()){
            if(arr.get(index).equals(arr.get(index+1))){
                arr.remove(index);
                continue;
            }
            index +=1;
        }
        int[] answer = new int[arr.size()];
        for(int i = 0; i<arr.size(); i++){
            answer[i] = arr.get(i);
        }
        return answer;
    }

}
