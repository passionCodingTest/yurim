package beakjoon;

import java.util.*;
import java.io.*;
public class Q10825 {
	static class Student implements Comparable<Student> {
		String name ;
		int koreaScore;
		int englishScore;
		int mathScore;
		Student(String name, int koreaScore, int englishScore, int mathScore){
			this.name = name;
			this.koreaScore = koreaScore;
			this.englishScore = englishScore;
			this.mathScore = mathScore;
		}
		@Override
		public int compareTo(Student o){
			if(this.koreaScore == o.koreaScore){
				if(this.englishScore == o.englishScore) {
					if(this.mathScore == o.mathScore) return this.name.compareTo(o.name);
					else return Integer.compare(o.mathScore, this.mathScore);
				}else return Integer.compare(this.englishScore, o.englishScore);
			}else return Integer.compare(o.koreaScore, this.koreaScore);
		}
	}
	static public void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		ArrayList<Student> students = new ArrayList<>();
		int n = Integer.parseInt(br.readLine());
		for(int i = 0; i<n; i++){
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			students.add(new Student(st.nextToken(), Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
		}
		Collections.sort(students);
		for(Student s : students){
			bw.write(s.name+"\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
