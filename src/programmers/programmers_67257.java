package programmers;
import java.util.*;
public class programmers_67257 {
	static ArrayList<String> nums;
    static ArrayList<String> op;
	public static void main(String[] args) {
		System.out.println(solution("100-200*300-500+20"));
		System.out.println(solution("50*6-3*2"));
	}
    static public long solution(String expression) {
        long answer = 0;
        int idx = 0;
        nums = new ArrayList<>();
        op= new ArrayList<>();
        String[][] prioty =new String[][]{{"*","+","-"},{"*","-","+"},{"+","-","*"},{"+","*","-"},{"-","+","*"},{"-","*","+"}};
        for(int i = 0; i<expression.length(); i++){
            if(expression.charAt(i) == '+' || expression.charAt(i) == '-' || expression.charAt(i) == '*'){
                nums.add(expression.substring(idx, i));
                op.add(expression.substring(i,i+1));
                idx = i+1;
                i++;
            }
        }
        nums.add(expression.substring(idx,expression.length()));
        for(int i = 0; i<prioty.length; i++){
            answer = Math.max(calc(prioty[i]), answer);
        }
        return answer;
    }
    static public long calc(String[] prioty){
        ArrayList<String> cpNums = new ArrayList<>(nums);
        ArrayList<String> cpOp = new ArrayList<>(op);
        for(int i = 0; i<prioty.length; i++){
            for(int j = 0; j < cpOp.size(); j++){
                if(prioty[i].equals(cpOp.get(j))){
                    int num1 = Integer.parseInt(cpNums.get(j));
                    int num2 = Integer.parseInt(cpNums.get(j+1));
                    cpNums.remove(j);
                    cpNums.remove(j);
                    switch(cpOp.get(j)){
                        case "+": cpNums.add(j,num1+num2+""); break;
                        case "-": cpNums.add(j,num1-num2+""); break;
                        case "*": cpNums.add(j,num1*num2+""); break;
                    }
                    cpOp.remove(j);
                    j--;
                }
            }
        }
        return Math.abs(Long.parseLong(cpNums.get(0)));
    }
}
