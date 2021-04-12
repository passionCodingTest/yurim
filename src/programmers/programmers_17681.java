package programmers;

//비밀 지도 

public class programmers_17681 {

	public static void main(String[] args) {
		solution(5, new int[] {9, 20, 28, 18, 11}, new int[] {30, 1, 21, 17, 28});

	}
	static public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for(int i = 0; i<n; i++){
            String a1 = Integer.toBinaryString(arr1[i]);
            String a2 = Integer.toBinaryString(arr2[i]);
            if(a1.length() < n){
            	int leng = a1.length();
                for(int k = 0; k<n-leng; k++){
                    a1 = "0"+a1;
                }
            }
            if(a2.length() < n){
            	int leng = a2.length();
                for(int k = 0; k<n-leng; k++){
                    a2 = "0"+a2;
                }
            }
            answer[i] = "";
            for(int j = 0; j<n; j++){
                if(a1.charAt(j) == '1' || a2.charAt(j) == '1'){
                    answer[i] +="#";
                }else{
                    answer[i] += " ";
                }
            }
        }
        for(String str : answer) {
        	System.out.println(str);
        }
        return answer;
    }

}
