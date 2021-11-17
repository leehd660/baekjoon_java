package silver4;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class S4_3986 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String numStr = bf.readLine();
        int num = Integer.parseInt(numStr);
        int answer = 0;
        for (int i=0; i<num; i++) {
            Deque<String> deque = new ArrayDeque<>();
            String word = bf.readLine();
            String[] wordArr = word.split("");
            for (String s : wordArr) {
                if (deque.isEmpty()) {
                    deque.addLast(s);
                }
                else {
                    if (deque.peekLast().equals(s)){
                        deque.removeLast();
                    }
                    else {
                        deque.addLast(s);
                    }
                }
            }
            if (deque.isEmpty()){
                answer ++;
            }
        }
        bw.write(String.valueOf(answer));
        bw.close();
    }
}
