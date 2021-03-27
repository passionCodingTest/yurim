package programmers;

//최솟값 만들기 : https://programmers.co.kr/learn/courses/30/lessons/12941?language=java

import java.util.*;
public class programmers_12941 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	static public int solution(int []A, int []B)
    {
        int n = B.length-1;
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        for(int i = 0; i < A.length; i++){
            answer += (A[i]*B[n - i]);
        }

        return answer;
    }

}
