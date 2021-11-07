package silver4;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class S4_18256 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String numStr = bf.readLine();
        int num = Integer.parseInt(numStr);
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i=0; i<num; i++) {
            String instruction = bf.readLine();
            String[] arr = instruction.split(" ");
            if (arr.length ==2) {
                deque.add(Integer.parseInt(arr[1]));
            }
            else {
                if (arr[0].equals("front")) {
                    if (deque.isEmpty()){
                        bw.write("-1\n");
                    }
                    else {
                        bw.write(String.valueOf(deque.getFirst()));
                        bw.write("\n");
                    }
                }
                else if (arr[0].equals("back")){
                    if (deque.isEmpty()){
                        bw.write("-1\n");
                    }
                    else {
                        bw.write(String.valueOf(deque.getLast()));
                        bw.write("\n");
                    }
                }
                else if (arr[0].equals("size")){
                    bw.write(String.valueOf(deque.size()));
                    bw.write("\n");
                }
                else if (arr[0].equals("pop")) {
                    if (deque.isEmpty()){
                        bw.write("-1\n");
                    }
                    else {
                        bw.write(String.valueOf(deque.pollFirst()));
                        bw.write("\n");
                    }
                }
                else if (arr[0].equals("empty")){
                    if (deque.isEmpty()){
                        bw.write("1\n");
                    }
                    else {
                        bw.write("0\n");
                    }
                }
            }
        }
        bw.close();
    }
}
