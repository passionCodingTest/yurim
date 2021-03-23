package programmers;

//이진 변환 반복하기 : https://programmers.co.kr/learn/courses/30/lessons/70129?language=java

public class programers_70129 {
	static int removeCnt = 0;
	public static void main(String[] args) {
		int[] result = solution("110010101001");
		System.out.println("["+result[0]+", "+result[1]+"]");
		result = solution("01110");
		System.out.println("["+result[0]+", "+result[1]+"]");
		result = solution("1111111");
		System.out.println("["+result[0]+", "+result[1]+"]");
	}
	
    static public int[] solution(String s) {
    	removeCnt = 0;
        int repeatCnt = 0;
        while(!s.equals("1")){
            s = repeat(s);
            repeatCnt +=1;
        }
        int[] answer = {repeatCnt, removeCnt};
        return answer;
    }
    
    static public String repeat(String s){
        int cnt = 0;
        for(int i = 0; i<s.length(); i++){
            if(s.charAt(i) == '1') cnt +=1;
        }
        removeCnt += s.length() - cnt;
        String convert = "";
        while(cnt > 0){
            convert = cnt%2 + convert;
            cnt /=2;
        }
        return convert;
    }

}
