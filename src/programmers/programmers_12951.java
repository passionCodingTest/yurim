package programmers;

//JadenCase 문자열 만들기 : https://programmers.co.kr/learn/courses/30/lessons/12951?language=java#


public class programmers_12951 {

	public static void main(String[] args) {
		System.out.println(solution("3people unFollowed me"));
		System.out.println(solution("for the last week"));

	}
	static public String solution(String s) {
        String answer = "";
        String[] word = s.split(" ", -1);
        for(int i = 0; i < word.length; i++){
            if(word[i].length() > 0) answer += word[i].substring(0,1).toUpperCase() + word[i].substring(1,word[i].length()).toLowerCase();
            if(i != word.length-1) answer +=" ";
        }
        return answer;
    }

}
