package programmers;

//카카오프렌즈 컬러링북 : https://programmers.co.kr/learn/courses/30/lessons/1829?language=java


import java.util.*;

public class programmers_1829 {
	static int[][] d ;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static int max = 0;
	public static void main(String[] args) {
		solution(6,4, new int[][] {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}});

	}
	static public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        Queue<Pair> q = new LinkedList<Pair>();
        d = new int[m][n];
        for(int y = 0; y< m; y++){
            for(int x = 0; x<n; x++){
            	if(d[y][x] == 0 && picture[y][x] != 0) {
            		numberOfArea++;
            		q.add(new Pair(x, y));
            		d[y][x] = numberOfArea;
            		while(!q.isEmpty()) {
            			Pair p = q.remove();
            			int px = p.x;
            			int py = p.y;
            			for(int k = 0; k<4; k++){
            	        	int nx = px + dx[k];
            	        	int ny = py + dy[k];
            	        	if(0<=nx && nx < n && 0<= ny && ny < m) {
            	        		if(d[ny][nx] == 0 && picture[ny][nx] == picture[py][px]){
            	                    d[ny][nx] = numberOfArea;
            	                    q.add(new Pair(nx, ny));
            	                }
            	        	}
            	            
            	        }
            		}
            	}
            }
        }
        int[] sizeOfArea = new int[numberOfArea+1];
        for(int[] row : d) {
        	for(int c : row) {
        		if(c!= 0)sizeOfArea[c] +=1;
        	}
        }
        for(int i : sizeOfArea) {
        	if(maxSizeOfOneArea < i) maxSizeOfOneArea = i;
        }
        
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
    static class Pair{
    	int x ;
    	int y ;
    	Pair(int x, int y){
    		this.x = x;
    		this.y = y;
    	}
    }
}
