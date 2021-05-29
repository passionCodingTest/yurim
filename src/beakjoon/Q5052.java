package beakjoon;
// 전화번호 목록 :시간초과
import java.io.*;
import java.util.*;
public class Q5052 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int testCase = Integer.parseInt(br.readLine());
		for(int i = 0; i<testCase; i++) {
			int cnt = Integer.parseInt(br.readLine());
			String[] list = new String[cnt];
			for(int l = 0; l<cnt; l++) {
				list[l] = br.readLine()+'\0';
			}
			boolean check = false;
			for(int j = 0; j<cnt; j++) {
				TrieNode tn = new TrieNode();
				check = false;
				for(int k = 0; k<cnt; k++) {
					if(j==k) continue;
					tn.insert(list[k]);
				}
				Boolean result = tn.find(list[j]);
				if(!(result==null||result)) {
					check = true;
					break;
				}
			}
			if(check) bw.write("No\n");
			else bw.write("YES\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
	static class TrieNode{
		TrieNode[] next = new TrieNode[10];
		boolean leaf = false;
		void insert(String str) {
			char[] arr = str.toCharArray();
			char s = arr[0];
			if(s=='\0') leaf=true;
			else {
				int idx = s-'0';
				if(next[idx]==null) next[idx] = new TrieNode();
				if(str.length()>1) str = str.substring(1);
				next[idx].insert(str);
			}
		}
		
		Boolean find(String str) {
			char[] arr = str.toCharArray();
			char s = arr[0];
			if(s=='\0') return leaf;
			else {
				int idx = s-'0';
				if(next[idx]==null) return null;
				if(str.length()>1) str = str.substring(1);
				return next[idx].find(str);
			}
		}
	}
	
	//통과 코드 
//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//		int testCase = Integer.parseInt(br.readLine());
//		for(int i = 0; i<testCase; i++) {
//			int cnt = Integer.parseInt(br.readLine());
//			String[] list = new String[cnt];
//			for(int j = 0; j<cnt; j++){
//				list[j] = br.readLine();
//			}
//			Arrays.sort(list);
//			boolean check = false;
//			for(int j=0; j<cnt-1; j++){
//				if(list[j].startsWith(list[j+1])) check=true;
//				if(list[j+1].startsWith(list[j])) check = true;
//			}
//			if(check) bw.write("NO\n");
//			else bw.write("YES\n");
//		}
//		
//		bw.flush();
//		bw.close();
//		br.close();
//	}
}
