package silver4;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class S4_10825 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String numStr = bf.readLine();
        int num = Integer.parseInt(numStr);
        List<Student> table = new ArrayList<>();

        for (int i=0; i<num; i++) {
            String info = bf.readLine();
            String[] infoArr = info.split(" ");
            Student student = new Student(infoArr[0], Integer.parseInt(infoArr[1]), Integer.parseInt(infoArr[2]),Integer.parseInt(infoArr[3]));
            table.add(student);
        }
        Check check = new Check();
        Collections.sort(table,check);
        for (Student s : table) {
            bw.write(s.name);
//            bw.write(" ");
//            bw.write(String.valueOf(s.kor));
//            bw.write(" ");
//            bw.write(String.valueOf(s.eng));
//            bw.write(" ");
//            bw.write(String.valueOf(s.math));
            bw.write("\n");
        }
        bw.close();
    }

    static class Student {
        String name;
        int kor;
        int eng;
        int math;

        Student (String name, int kor, int eng, int math) {
            this.name = name;
            this.kor = kor;
            this.eng = eng;
            this.math = math;
        }
    }

    static class Check implements Comparator<Student> {

        @Override
        public int compare(Student s1, Student s2) {
            int answer = -1;
            if (s1.kor < s2.kor){
                answer = 1;
            }
            else if (s1.kor == s2.kor) {
                if (s1.eng > s2.eng) {
                    answer = 1;
                }
                else if (s1.eng == s2.eng) {
                    if (s1.math <s2.math){
                        answer = 1;
                    }
                    else if (s1.math == s2.math){
                        if (s1.name.compareTo(s2.name) > 0 ){
                            answer = 1;
                        }
                    }
                }
            }

            return answer;
        }
    }
}
