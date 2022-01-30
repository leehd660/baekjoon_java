package silver1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class S1_11729 {
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static List<String> list;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(bf.readLine());
        if (num==1) {
            bw.write(String.valueOf(1)+"\n");
            bw.write("1 3"+"\n");
        }
        else {
            list = new ArrayList<>();
            hanoi(num, 1, 3, 2);
            bw.write(String.valueOf(list.size()) + "\n");
            for (String word : list) {
                bw.write(word + "\n");
            }
        }
        bw.close();
    }

    static void hanoi(int num, int start, int fin, int nothing) throws IOException {
        if (num == 2) {
            list.add(String.valueOf(start)+" "+String.valueOf(nothing));
            list.add(String.valueOf(start)+" "+String.valueOf(fin));
            list.add(String.valueOf(nothing)+" "+String.valueOf(fin));
        }
        else {
            hanoi(num-1,start, nothing,fin);
            list.add(String.valueOf(start)+" "+String.valueOf(fin));
            hanoi(num-1, nothing, fin, start);
        }
    }
}
