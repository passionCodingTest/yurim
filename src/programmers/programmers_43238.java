package programmers;

//43238 : 입국 심사 

import java.util.*;
public class programmers_43238 {

	public static void main(String[] args) {
		programmers_43238 m = new programmers_43238();
		System.out.println(m.solution(6, new int[] {7,10}));
	}
	public long solution(int n, int[] times) {
        Arrays.sort(times);
        long answer = Long.MAX_VALUE;
        long left = 1;
        long right = ((long)times[times.length-1])*((long)n);
        long cnt = 0;
        long mid = 0;
        while(left <= right){
            cnt = 0;
            mid = (left+right)/2;
            for(int t : times){
                cnt += mid/t;
            }
            if(cnt >= n) {
                answer = answer > mid ? mid : answer;
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        return answer;
    }

}
