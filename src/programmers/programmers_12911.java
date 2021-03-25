package programmers;

public class programmers_12911 {

	public static void main(String[] args) {
		System.out.println(solution(78));
		System.out.println(solution(15));
	}
	static public int solution(int n) {
        int answer = 0;
        String binary = Integer.toBinaryString(n);
        int cnt = 0;
        for(int i = 0; i<binary.length(); i++){
            if(binary.charAt(i) == '1') cnt +=1;
        }
        int startN = n+1;
        while(true){
            int oneCount = 0;
            String str =  Integer.toBinaryString(startN++);
            for(int i = 0; i<str.length(); i++){
                if(str.charAt(i) == '1') oneCount +=1;
            }
            if(cnt == oneCount){
                answer = Integer.parseInt(str,2);
                break;
            }
        }
        return answer;
    }
}
