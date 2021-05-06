package beakjoon;

import java.io.*;
import java.util.*;
public class Q10815 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int[] sanggoun = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for(int i = 0; i<n; i++) {
			sanggoun[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(sanggoun);
		int min = sanggoun[0]; int max = sanggoun[n-1];
		int m = Integer.parseInt(br.readLine());
		int[] nums = new int[m];
		StringTokenizer st2 = new StringTokenizer(br.readLine()," ");
		for(int i = 0; i<m; i++) {
			nums[i] =  Integer.parseInt(st2.nextToken());
		}
		for(int i = 0; i<m; i++) {
			boolean checked = false;
			if(nums[i] > max || nums[i] < min) {
				bw.write(checked?"1":"0");
				if(i != m-1) bw.write(" ");
				continue;
			}
			int left = 0; int right = n;
			while(left < right) {
				int mid = (left+right)/2;
				if(nums[i] < sanggoun[mid]) right = mid;
				else if(nums[i] > sanggoun[mid]) left = mid+1;
				else if(nums[i] == sanggoun[mid]) {
					checked = true;
					break;
				}
			}
			bw.write(checked?"1":"0");
			if(i != m-1) bw.write(" ");
		}
		bw.flush();
		bw.close();
		br.close();
	}
	
}
