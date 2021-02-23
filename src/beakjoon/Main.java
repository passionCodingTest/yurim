package beakjoon;


import java.io.*;
import java.util.*;

//2309 일곱 난쟁이 : 브루트포스 알고리
public class Main{
    public static int ans = 0;
    public static void main(String[] args) throws IOException{
    	Main m = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ArrayList<Integer> arr = new ArrayList<>();
        int sum = 0;
        for(int i = 0; i<9; i++) {
        	int len = Integer.parseInt(br.readLine().trim());
        	arr.add(len);
        	sum += len;
        }
        
        for(int i = 0; i<arr.size(); i++) {
        	for(int j = i+1; j<arr.size(); j++) {
        		if(sum - arr.get(i) - arr.get(j) == 100) {
        			if(i > j) { arr.remove(i); arr.remove(j);}
        			else {arr.remove(j); arr.remove(i);}
        			Collections.sort(arr);
        			break;
        		}
        	}
        }
        
        for(int len : arr) {
        	bw.write(len+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}