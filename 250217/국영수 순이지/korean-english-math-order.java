import java.util.*;
import java.io.*;

class Student implements Comparable<Student>{
    String name;
    int kor, eng, math;

    public Student(String name, int kor, int eng, int math){
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
    }

    @Override
    public int compareTo(Student stu){
        if(this.kor == stu.kor){
            if(this.eng == stu.eng){
                return this.math - stu.math;
            }
            return this.eng - stu.eng;
        }
        return this.kor - stu.kor;
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        Student[] students = new Student[n];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int kor, eng, math;
            kor = Integer.parseInt(st.nextToken());
            eng = Integer.parseInt(st.nextToken());
            math = Integer.parseInt(st.nextToken());
            Student stu = new Student(name, kor, eng, math);
            students[i] = stu;
        }

        Arrays.sort(students);

        for(int i = n-1; i >= 0; i--)
            System.out.println(students[i].name + " " + students[i].kor + " " + students[i].eng + " " + students[i].math);

    }
}