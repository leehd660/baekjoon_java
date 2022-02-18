package silver2;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class S2_9613 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testNum = Integer.parseInt(bf.readLine());
        for (int i=0; i<testNum; i++) {
            StringTokenizer token = new StringTokenizer(bf.readLine());
            int num = Integer.parseInt(token.nextToken());
            Integer[] arr = new Integer[num];
            for (int j=0; j<num; j++) {
                arr[j] = Integer.parseInt(token.nextToken());
            }
            Arrays.sort(arr, Collections.reverseOrder());
            long answer = 0;
            for (int a=0; a<num-1; a++) {
                for (int b=a+1; b<num; b++) {
                    answer += GCD(arr[a],arr[b]);
                }
            }
            bw.write(String.valueOf(answer) + "\n");
        }
        bw.close();
    }

    static int GCD(int a, int b) {
        while (a%b != 0) {
            int keep = b;
            b = a%b;
            a = keep;
        }
        return b;
    }
}
