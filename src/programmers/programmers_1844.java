package programmers;

//게임 맵 최단 거 : https://programmers.co.kr/learn/courses/30/lessons/1844

import java.util.*;
public class programmers_1844 {
	static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
	public static void main(String[] args) {
		System.out.println(solution(new int[][] {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}}));
		System.out.println(solution(new int[][] {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,0},{0,0,0,0,1}}));
	}
	
    static public int solution(int[][] maps) {
        int answer = 0;
        int n = maps.length; //y
        int m = maps[0].length; //x
        Queue<Pair> queue = new LinkedList<Pair>();
        int[][] d = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        queue.add(new Pair(0,0));
        d[0][0] = 1;
        visited[0][0] = true;
        while(!queue.isEmpty()){
            Pair p = queue.remove();
            int px = p.x;
            int py = p.y;
            for(int k =0; k<4; k++){
                int nx = px+dx[k];
                int ny = py+dy[k];
                if(0 <= nx && nx < m && 0 <= ny && ny < n){
                    if(maps[ny][nx] == 1 && !visited[ny][nx]){
                        visited[ny][nx] = true;
                        d[ny][nx] = d[py][px]+1;
                        queue.add(new Pair(nx, ny));
                    }
                }
            }
        }
        answer = d[n-1][m-1];
        if(d[n-1][m-1] == 0) answer = -1;
        
        return answer;
    }
    
    static class Pair{
        int x;
        int y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

}
