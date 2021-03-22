package programmers;

import java.util.*;

public class programmers_42583 {

	public static void main(String[] args) {
		System.out.println(solution(2,10,new int[] {7,4,5,6}));

	}
	static public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> waittingTruck = new LinkedList<Integer>();
        Queue<Integer> truckOnBridge = new LinkedList<Integer>();
        int nowWeight = 0;
        for(int w : truck_weights){
            waittingTruck.add(w);
        }
        while(true){
            if(nowWeight == 0 && waittingTruck.isEmpty()) break;
            answer++;
            if(truckOnBridge.size() == bridge_length){
                nowWeight -= truckOnBridge.remove();
            }
            if(truckOnBridge.size() < bridge_length){
                if(waittingTruck.isEmpty()){
                    truckOnBridge.add(0);
                }
                else{
                    if(nowWeight+waittingTruck.peek() <= weight){
                        nowWeight += waittingTruck.peek();
                        truckOnBridge.add(waittingTruck.remove());
                    }else if(nowWeight+waittingTruck.peek() > weight){
                        truckOnBridge.add(0);
                    }
                }
            }
        }
        return answer;
    }

}
