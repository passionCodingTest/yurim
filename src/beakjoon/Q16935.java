package beakjoon;

//배열 돌리기3 : https://www.acmicpc.net/problem/16935

import java.io.*;
import java.util.*;

public class Q16935 {
	static int N;
	static int M;
	static int[][] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		for(int i = 0; i < N; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j<M; j++) {
				arr[i][j] = Integer.parseInt(st2.nextToken());
			}
		}
		StringTokenizer st3 = new StringTokenizer(br.readLine(), " ");
		for(int i = 0 ; i <R; i++) {
			int op =  Integer.parseInt(st3.nextToken());
			switch(op) {
				case 1 : 
					arr = upsideDown(); 
					break;
				case 2 :
					arr = LRreversal();
					break;
				case 3 : 
					arr = rotateRightHalf(); 
					break;
				case 4 :
					arr = rotateLeftHalf(); 
					break;
				case 5 : 
					arr = rotateRight(); 
					break;
				case 6 : 
					arr = rotateLeft(); 
					break;
			}
			N = arr.length;
			M = arr[0].length;
		}
		
		for(int[] array : arr) {
			for(int n : array) {
				bw.write(n+" ");
			}
			bw.write("\n");
		}
		
		bw.flush();
		bw.close();
		br.close();

	}
	
	static public int[][] upsideDown(){
		int[][] result = new int[N][M];
		for(int i = 0; i<M; i++) {
			for(int j = 0; j<N; j++) {
				result[j][i] = arr[(N-1)-j][i];
			}
		}
		return result;
	}//위 아래 반전 
	
	static int[][] LRreversal(){
		int[][] result = new int[N][M];
		for(int i = 0; i< N; i++) {
			for(int j = 0; j < M; j++) {
				result[i][j] = arr[i][M-1-j];
			}
		}
		return result;
	}//좌우 반전 
	
	static int[][] rotateRightHalf(){
		int[][] result = new int[M][N];
		for(int i = 0; i<M; i++) {
			for(int j = 0; j <N; j++) {
				result[i][j] = arr[N-1-j][i];
			}
		}
		return result;
	}// 90도 회전 
	
	static int[][] rotateLeftHalf(){
		int[][] result = new int[M][N];
		for(int i = 0; i<N; i++) {
			for(int j = 0; j <M; j++) {
				result[j][i] = arr[i][M-1-j];
			}
		}
		return result;
	}// 반시계 방향 90도 회전 
	
	static int[][] rotateRight(){
		int[][] result = new int[N][M];
		//1번 -> 2번 
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(i >= 0 && i<N/2) {
					if(j >= 0 && j<M/2) {//1번일때 
						result[i][j+M/2] = arr[i][j];
					}
					if(j >= M/2 && j < M) {// 2번일 
						result[i+N/2][j] = arr[i][j];
					}
				}
				if( i>= N/2 && i<N) {
					if(j >= 0 && j<M/2) {//4번일때 
						result[i-N/2][j] = arr[i][j];
					}
					if(j >= M/2 && j < M) {// 3번일 
						result[i][j-M/2] = arr[i][j];
					}
				}
			}
		}
		return result;
	}//좌우 이동 
	
	static int[][] rotateLeft(){
		int[][] result = new int[N][M];
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<M; j++) {
				if(i >= 0 && i<N/2) {
					if(j >= 0 && j<M/2) {//1번일때 
						result[i+N/2][j] = arr[i][j];
					}
					if(j >= M/2 && j < M) {// 2번일 
						result[i][j-M/2] = arr[i][j];
					}
				}
				if( i>= N/2 && i<N) {
					if(j >= 0 && j<M/2) {//4번일때 
						result[i][j+M/2] = arr[i][j];
					}
					if(j >= M/2 && j < M) {// 3번일 
						result[i-N/2][j] = arr[i][j];
					}
				}
			}
		}
		return result;
	}//반 시계방향 이동 
}
