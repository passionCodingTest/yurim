package programmers;

//64061번 : 크레인 인형뽑기 게임 

import java.util.*;
public class programers_64061 {

	public static void main(String[] args) {
		System.out.println(solution(new int[][] {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}}, new int[] {1,5,3,5,1,2,1,4}));

	}
	static public int solution(int[][] board, int[] moves) {
        int answer = 0;
        ArrayList<Integer>[] g = (ArrayList<Integer>[]) new ArrayList[board[0].length+1];
        Stack<Integer> result = new Stack<>();
        for(int i = 0; i<g.length; i++){
            g[i] = new ArrayList<Integer>();
        }
        for(int j = 0 ; j<board[0].length; j++){
            for(int i = board.length; i > 0; i--){
                if(board[i-1][j] == 0) break;
                g[j+1].add(board[i-1][j]);
            }
        }
        for(int n : moves) {
        	if(g[n].size() > 0) {
        		if(result.size() == 0) {
        			result.add(g[n].get(g[n].size()-1));
        			g[n].remove(g[n].size()-1);
        			continue;
        		}
        		if(result.peek() == g[n].get(g[n].size()-1)){
        			g[n].remove(g[n].size()-1);
        			result.pop();
        			answer +=2;
        			continue;
        		}
        		result.add(g[n].get(g[n].size()-1));
        		g[n].remove(g[n].size()-1);
        	}
        }
        return answer;
    }

}
