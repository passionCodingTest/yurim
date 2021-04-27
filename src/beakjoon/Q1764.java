package beakjoon;

import java.io.*;
import java.util.*;
public class Q1764 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int answer = 0;
		HashSet<String> hs = new HashSet<>();
		ArrayList<String> arr = new ArrayList<>();
		for(int i=0; i<n; i++) {
			hs.add(br.readLine());
		}
		for(int i =0; i<m; i++) {
			String name = br.readLine();
			if(!hs.add(name)) {
				arr.add(name);
				answer +=1; 
			}
		}
		Collections.sort(arr);
		bw.write(answer+"\n");
		for(String a : arr) {
			bw.write(a+"\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
