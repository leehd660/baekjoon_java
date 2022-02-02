package silver1;

import java.io.*;

public class S1_9020 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testNum = Integer.parseInt(bf.readLine());
        for (int test = 0; test<testNum; test++) {
            int num = Integer.parseInt(bf.readLine());
            boolean[] table = new boolean[num+1];
            table[0] = true;
            table[1] = true;
            //false가 소수
            for (int i=0; i<num+1; i++) {
                if (!table[i]) {
                    int multiply = 2;
                    while (i*multiply < num+1) {
                        table[i*multiply] = true;
                        multiply++;
                    }
                }
                else {
                    continue;
                }
            }
            int min = 0;
            int max = num;
            for (int i=2; i<num+1; i++) {
                if (i>num-i) {
                    break;
                }
                if (!table[i] && !table[num-i]) {
                    if (max-min > num-i-i) {
                        min = i;
                        max = num-i;
                    }
                }
            }
            bw.write(String.valueOf(min) +" "+ String.valueOf(max)+"\n");
        }
        bw.close();
    }
}
