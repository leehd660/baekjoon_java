package silver4;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class S4_11866 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String numStr = bf.readLine();
        String[] numArr = numStr.split(" ");
        int num = Integer.parseInt(numArr[0]);
        int jumpNum = Integer.parseInt(numArr[1]);
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i=1; i<=num; i++) {
            deque.add(i);
        }
        int count =0;
        bw.write("<");
        while (deque.size()>0){
            count++;
            if (count%jumpNum==0) {
                bw.write(String.valueOf(deque.pollFirst()));
                if (deque.size()!=0) {
                    bw.write(", ");
                }
            }
            else{
                deque.addLast(deque.pollFirst());
            }
        }
        bw.write(">");
        bw.close();
    }
}
