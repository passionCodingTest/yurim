package beakjoon;

import java.io.*;
import java.util.*;
public class Q11004 {
	static int[] d,temp ;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		StringTokenizer st2 = new StringTokenizer(br.readLine()," ");
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		d = new int[n];
		temp = new int[n];
		for(int i = 0; i<n; i++) {
			d[i] = Integer.parseInt(st2.nextToken());
		}
		mergeSort(0,n-1);
		bw.write(d[k-1]+"");
		bw.flush();
		bw.close();
		br.close();
	}
	static public void mergeSort(int start, int end) {
		if(start < end) {
			int mid = (start+end)/2;
			mergeSort(start,mid);
			mergeSort(mid+1,end);
			
			int p = start;
			int q = mid +1;
			int idx = p;
			
			while(p<=mid || q<= end) {
				if(q>end || (p<=mid&&d[p]<d[q])) {
					temp[idx++] = d[p++];
				}else {
					temp[idx++] = d[q++];
				}
			}
			
			for(int i = start; i<= end; i++) {
				d[i] = temp[i];
			}
		}
	}
}
