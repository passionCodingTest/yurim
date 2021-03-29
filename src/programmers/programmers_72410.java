package programmers;

//72410 : 신규 아이디 추천 


public class programmers_72410 {

	public static void main(String[] args) {
		System.out.println(solution("...!@BaT#*..y.abcdefghijklm"));
		System.out.println(solution("z-+.^."));
		System.out.println(solution("=.="));
		System.out.println(solution("123_.def"));
		System.out.println(solution("abcdefghijklmn.p"));
	}
	static public String solution(String new_id) {
        String answer = "";
        new_id = new_id.toLowerCase(); //1
        new_id = new_id.replaceAll("[^a-z0-9._-]","").replaceAll("[.]+",".").replaceAll("^[.]", "").replaceAll("[.]$", "");//2
        new_id = new_id.length() == 0 ? "a" : new_id;
        new_id = (new_id.length() > 15 ? new_id.substring(0,15) : new_id).replaceAll("[.]$", "");//6
        if(new_id.length() <= 2 ){//7
        	StringBuffer sb = new StringBuffer(new_id);
        	while(sb.length() < 3) {
        		sb.append(sb.charAt(sb.length()-1)+"");
        	}
        	new_id = sb.toString();
        }
        answer = new_id;
        return answer;
    }

}
