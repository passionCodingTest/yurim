package programmers;

//level - 2 : 조이스틱 (greedy algorithm)

public class programmers_42860 {

	public static void main(String[] args) {
		System.out.println(solution("JEROEN"));//56
		System.out.println();
		System.out.println(solution("JAN")); // 23
		System.out.println();
		System.out.println(solution("JAZ")); //11
		System.out.println();
		System.out.println(solution("BBBAAAB")); // 9
		System.out.println();
		System.out.println(solution("ABABAAAAABA")); // 11
	}
	static public int solution(String name) {
        int answer = 0;
        answer = countMove(name, 0);
        return answer;
    }
	static public int countMove(String name, int index) {
		int cnt = 0;
		StringBuilder initStr = new StringBuilder();
        for(int i = 0; i<name.length(); i++){
            initStr.append("A");
        }
        while(!name.equals(initStr.toString())) {
        	cnt += (int)name.charAt(index) < 79 ? ((int)name.charAt(index)-65) :  (91 - (int)name.charAt(index));
        	initStr.setCharAt(index, name.charAt(index));
        	if(name.equals(initStr.toString())) break;
        	int leftindex = index == 0 ? name.length() - 1 : index -1;
        	int rightindex = index < name.length() - 1 ? index+1 : 0;
        	int leftCnt = 0;
        	int rightCnt = 0;
        	while(leftindex != index) {
        		if(name.charAt(leftindex) == 'A' || name.charAt(leftindex) == initStr.charAt(leftindex)) {leftindex = leftindex-1 < 0 ? name.length()-1 : leftindex-1; leftCnt +=1;}
        		else break;
        	}
        	while(rightindex != index) {
        		if(name.charAt(rightindex) == 'A' ||  name.charAt(rightindex) == initStr.charAt(rightindex)) {rightindex = rightindex+1 < name.length() ? rightindex+1 : 0; rightCnt +=1;}
        		else break;
        	}
        	if(leftCnt < rightCnt) {
        		cnt += leftCnt+1;
        		index = leftindex;
        	}else {
        		cnt +=rightCnt+1;
        		index = rightindex;
        	}
        }
		return cnt;
	}
}
