package silver5;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class S5_2635 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String numStr = bf.readLine();
        int n = Integer.parseInt(numStr);
        int max = 0;
        int maxNum = 0;
//        List<Integer> answerList = new ArrayList<>();
        for (int i=n; i>=0; i--) {
            int number = check(n,i).size();
//            max = Math.max(max, number);
            if (max < number) {
                max = number;
                maxNum = i;
            }
        }
        bw.write(String.valueOf(max)+"\n");
        for (int num : check(n,maxNum)) {
            bw.write(String.valueOf(num) + " ");
//            bw.write(" ");
        }
        bw.close();

    }

    static List<Integer> check(int n, int i) {
        List<Integer> list = new ArrayList<>();
        list.add(n);
        list.add(i);
        int now = 2;
        while (true) {
            int number = list.get(now-2) - list.get(now-1);
            if (number >= 0) {
                list.add(number);
            }
            else {
                break;
            }
            now++;
        }
        return list;
    }
}
