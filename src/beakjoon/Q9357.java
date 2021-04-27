package beakjoon;

import java.io.*;
import java.util.*;
public class Q9357 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int testCase = Integer.parseInt(br.readLine());
		while(testCase > 0) {
			int clothCase = 1;
			int n = Integer.parseInt(br.readLine());
			HashMap<String, ArrayList<String>> map = new HashMap<>();
			for(int i = 0; i<n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine()," ");
				String name = st.nextToken();
				String type = st.nextToken();
				ArrayList<String> cloth ;
				if(!map.containsKey(type)) {
					cloth = new ArrayList<>();
					cloth.add(name);
				}else {
					cloth = map.get(type);
					cloth.add(name);
				}
				map.put(type, cloth);
				
			}
			for(String key : map.keySet()) {
				clothCase *= (map.get(key).size()+1);
			}
			bw.write((clothCase - 1)+"\n");
			testCase--;
		}
		bw.flush();
		bw.close();
		br.close();
	}

}
