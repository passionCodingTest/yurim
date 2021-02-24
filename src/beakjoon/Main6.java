package beakjoon;

import java.io.*;
import java.util.*;

//N과 M (3)

public class Main6 {
	static boolean[] c = new boolean[10];
	static int[] a = new int[10];
	public static void main(String[] args) throws IOException {
		Main6 m = new Main6();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int range = Integer.parseInt(st.nextToken());
		int count = Integer.parseInt(st.nextToken());
		
		m.go(0, range, count, bw);
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	public void go(int index, int range, int count, BufferedWriter bw) throws IOException{
		if(index == count) {
			for(int i = 0; i<count; i++) {
				bw.write(a[i]+"");
				if(i != count-1) bw.write(" ");
			}
			bw.write("\n");
			return;
		}
		for(int i = 1; i<=range; i++) {
			c[i] = true; a[index] = i;
			go(index+1, range, count, bw);
			c[i] = false;
		}
	}

}
