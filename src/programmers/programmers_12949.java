package programmers;

public class programmers_12949 {

	public static void main(String[] args) {
		solution(new int[][] {{1,4},{3,2},{4,1}}, new int[][] {{3,3},{3,3}});

	}
	static public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];
        for(int row = 0; row<arr1.length; row++){
            for(int col = 0; col<arr2[0].length; col++){
                for(int i = 0; i<arr2.length; i++){
                    answer[row][col] += (arr1[row][i]*arr2[i][col]);
                }
            }
        }
        for(int[] row : answer) {
        	for(int c : row) {
        		System.out.print(c+" ");
        	}
        	System.out.println();
        }
        return answer;
    }

}
