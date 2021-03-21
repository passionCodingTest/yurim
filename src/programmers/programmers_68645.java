package programmers;

//삼각 달팽이 

public class programmers_68645 {

	public static void main(String[] args) {
		int[] arr = solution(3);

	}
	static public int[] solution(int n) {
        int[] answer = new int[n*(n+1)/2];
        int[][] matrix = new int[n][n];
        int x = -1;
        int y = 0;
        int num = 1;
        for(int i =0; i<n; i++){
            for(int j = i; j<n; j++){
                if(i%3 == 0){//아래로 내려가기
                    x++;
                }else if(i%3 == 1){//x값이 마지막일때 오른쪽으로 이동
                    y++;
                }else if(i%3 == 2){ //y값이 마지막일 때 대각선 위로 이동
                    x--;
                    y--;
                }
                matrix[x][y] = num++;
            }
        }
        int k = 0;
        for(int[] m : matrix){
            for(int a : m){
                if(a != 0) answer[k++] = a;
            }
        }
        return answer;
    }

}
