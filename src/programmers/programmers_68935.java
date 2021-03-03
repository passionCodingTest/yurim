package programmers;

// 3진법 뒤집기 : https://programmers.co.kr/learn/courses/30/lessons/68935
// 월간 코드 챌린지 시즌1 

import java.util.*;

public class programmers_68935 {

	public int solution(int n) {
        int answer = 0;
        String samjin = "";
        while(n != 0){
            samjin += n%3; //반전된 3진법
            n /=3;
        }
        long a = Long.valueOf(samjin).longValue();
        long pow = 1;
        while(a != 0){
            answer += (a%10) * pow;
            a /= 10;
            pow *= 3;
        }
        return answer;
    }

}
