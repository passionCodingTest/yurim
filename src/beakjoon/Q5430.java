package beakjoon;

//AC

import java.io.*;
import java.util.*;
public class Q5430 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int testCase = Integer.parseInt(br.readLine());
		while(testCase > 0) {
			Deque<Integer> deq = new LinkedList<>();
			boolean reverse = false;
			boolean error = false;
			String commands = br.readLine();
			int size = Integer.parseInt(br.readLine());
			String arr = br.readLine();
			String[] numArr = new String[size];
			arr = arr.substring(1, arr.length()-1);
			numArr = arr.split(",");
			for(String num : numArr) {
				if(!num.equals("")) deq.add(Integer.parseInt(num));
			}
			for(int i =0; i<commands.length(); i++) {
				if(commands.charAt(i) == 'R') reverse = !reverse;
				if(commands.charAt(i) == 'D') {
					if(deq.isEmpty()) {
						error = true;
						break;
					}
					if(reverse) {
						deq.pollLast();
					}else {
						deq.pollFirst();
					}
				}
			}
			if(error) bw.write("error\n");
			else {
				bw.write("[");
				while(!deq.isEmpty()) {
					if(reverse) bw.write(deq.pollLast()+"");
					else bw.write(deq.pollFirst()+"");
					if(!deq.isEmpty()) bw.write(",");
				}
				bw.write("]\n");
			}
			testCase--;
		}
		bw.flush();
		br.close();
		bw.close();
	}
}
