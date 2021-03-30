package programmers;

//12917 : 문자열 내림차순으로 배치하기 

import java.util.*;
public class programmers_12917 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	static public String solution(String s) {
        StringBuilder st = new StringBuilder(s);
        for(int i = 0; i<s.length(); i++){
            for(int j = i+1; j<s.length(); j++){
                if(st.charAt(i) < st.charAt(j)){
                    char c = st.charAt(i);
                    char c2 = st.charAt(j);
                    st.setCharAt(j,c);
                    st.setCharAt(i,c2);
                }
            }
        }
        String answer = st.toString();
        return answer;
    }
}
