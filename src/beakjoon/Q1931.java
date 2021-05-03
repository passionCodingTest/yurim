package beakjoon;

import java.util.*;
import java.io.*;
public class Q1931 {
	static ArrayList<Reservation> arr;
	static class Reservation implements Comparable<Reservation>{
		int start;
		int end;
		int time;
		Reservation(int start, int end){
			this.start = start;
			this.end = end;
			this.time = end - start;
		}
		@Override
		public int compareTo(Reservation arg0) {
			if(this.end == arg0.end)return Integer.compare(this.start, arg0.end);
			else return Integer.compare(this.end, arg0.end);
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		arr = new ArrayList<>();
		for(int i = 0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			arr.add(new Reservation(start, end));
		}
		Collections.sort(arr);
		int count = 0;
		int end = -1;
		for(int i =0; i<n; i++) {
			if(arr.get(i).start>= end) {
				end = arr.get(i).end;
				count++;
			}
		}
		bw.write(count+"\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
