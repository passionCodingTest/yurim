package programmers;

//12915 : 문자열 내 마음대로 정렬하기 

public class programmers_12915 {

	public static void main(String[] args) {
		solution(new String[] {"sun","bed","car"}, 1);
		solution(new String[] {"abce","abcd","cdx"}, 1);
	}
	static public String[] solution(String[] strings, int n) {
        for(int i = 0; i<strings.length; i++){
            for(int j = 0; j<strings.length; j++){
                if(strings[i].charAt(n) < strings[j].charAt(n)){
                    String tmp=strings[i];
                    strings[i] = strings[j];
                    strings[j] = tmp;
                }else if(strings[i].charAt(n) == strings[j].charAt(n)){
                    if(strings[i].compareTo(strings[j]) < 0){
                        String tmp=strings[i];
                        strings[i] = strings[j];
                        strings[j] = tmp;
                    }
                }
            }
        }
        String[] answer=strings;
        return answer;
    }
}
