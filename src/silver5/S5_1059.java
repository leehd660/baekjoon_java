package silver5;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class S5_1059 {
    public static void main(String[] args) throws IOException {
        int answer = 0;
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String numStr = bf.readLine();
        int num = Integer.parseInt(numStr);
        String setStr = bf.readLine();
        String[] setArr = setStr.split(" ");
        List<Integer> set = new ArrayList<>();
        for (int i=0; i<num; i++) {
            set.add(Integer.parseInt(setArr[i]));
        }
        Collections.sort(set);
        String nStr = bf.readLine();
        int n = Integer.parseInt(nStr);
        if (set.contains(n)){
            answer = 0;
        }
        else {
            int small = 0;
            int big = 1000;
            for (int i = 0; i < num; i++) {
//                if (set.get(i) < n && set.get(i + 1) > n) {
//                    small = set.get(i);
//                    big = set.get(i + 1);
//                }
                if (set.get(i) < n && set.get(i) > small) {
                    small = set.get(i);
//                    big = set.get(i + 1);
                }
                if (set.get(i) > n && big > set.get(i)){
                    big = set.get(i);
                }
            }
            if (small==0 && big ==0) {
                answer = 0;
            }
            else {
                answer = (n - small) * (big - n) - 1;
            }
        }
        bw.write(String.valueOf(answer));
        bw.close();
    }
}
