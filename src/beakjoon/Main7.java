package beakjoon;

//N과 M(4)

import java.io.*;
import java.util.*;

public class Main7 {
	
	static boolean[] c = new boolean[10];
	static int[] a = new int[10];

	public static void main(String[] args)  throws IOException  {
		Main7 m = new Main7();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int range = Integer.parseInt(st.nextToken());
		int count = Integer.parseInt(st.nextToken());
		
		m.go(0, 1, range, count, bw);
		
		
		bw.flush();
		bw.close();
		br.close();

	}
	
	public void go(int index, int start, int range, int count, BufferedWriter bw)  throws IOException {
		
		if(index == count) {
			for(int i = 0; i<count; i++){
				bw.write(a[i]+"");
				if(i != count-1) bw.write(" ");
			}
			bw.write("\n");
			return;
		}
		
		for(int i = start; i<= range; i++) {
			c[i] = true;
			a[index] = i;
			go(index+1, i, range, count, bw);
			c[i] = false;
		}
		
	}

}
