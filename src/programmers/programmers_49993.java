package programmers;


import java.util.*;
public class programmers_49993 {

	public static void main(String[] args) {
		System.out.println(solution("CBD",new String[] {"BCAED","ACBWGD","EACVB","BDSAE","CASDYU"}));

	}
	
	static public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        for(int j = 0; j < skill_trees.length; j++){
            for(int i = skill.length()-1; i>0; i--){
                if(!check(skill.charAt(i-1), skill.charAt(i),skill_trees[j])){
                    answer +=1;
                    break;
                }
            }   
        }
        
        return skill_trees.length - answer;
    }
    
    static public boolean check(char front, char after, String skill){
        int frontIndex = -1;
        int afterIndex = -1;
        for(int i = 0; i<skill.length(); i++){
            if(skill.charAt(i) == front) frontIndex = i;
            if(skill.charAt(i) == after) afterIndex = i;
        }
        if(afterIndex != -1){
            if(frontIndex == -1) return false;
            else if(frontIndex > afterIndex) return false;
        }
        return true;
    }

}
