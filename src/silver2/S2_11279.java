package silver2;

import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;

public class S2_11279 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testNum = Integer.parseInt(bf.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for (int i=0; i<testNum; i++) {
            int num = Integer.parseInt(bf.readLine());
            if (num == 0) {
                if (queue.isEmpty()){
                    bw.write("0\n");
                }
                else {
                    bw.write(String.valueOf(queue.poll())+"\n");
                }
            }
            else {
                queue.add(num);
            }
        }
        bw.close();
    }
}
