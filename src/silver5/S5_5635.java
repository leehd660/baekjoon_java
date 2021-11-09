package silver5;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class S5_5635 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String numStr = bf.readLine();
        int num = Integer.parseInt(numStr);

        List<People> list = new ArrayList<>();
        Birth birth = new Birth();

        for (int i=0; i<num; i++) {
            String p = bf.readLine();
            String[] pInfo = p.split(" ");
            String name = pInfo[0];
            int date = Integer.parseInt(pInfo[1]);
            int month = Integer.parseInt(pInfo[2]);
            int year = Integer.parseInt(pInfo[3]);
            People people = new People(name, date, month, year);
            list.add(people);
        }
        Collections.sort(list,birth);

        bw.write(list.get(0).name);
        bw.write("\n");
        bw.write(list.get(list.size()-1).name);
        bw.close();
    }

    static class People {
        String name;
        int year;
        int month;
        int date;

        People (String name, int date, int month, int year) {
            this.name = name;
            this.date = date;
            this.month = month;
            this.year = year;
        }
    }

    static class Birth implements Comparator<People> {

        @Override
        public int compare(People p1, People p2) {
            int answer = -1;
            if (p1.year < p2.year) {
                answer = 1;
            }
            else if (p1.year == p2.year){
                if (p1.month < p2.month) {
                    answer = 1;
                }
                else if (p1.month == p2.month) {
                    if (p1.date < p2.date) {
                        answer = 1;
                    }
                }
            }
            return answer;
        }
    }
}
