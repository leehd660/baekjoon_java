package silver2;

import java.io.*;
import java.util.*;

public class S2_1927 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = Integer.parseInt(bf.readLine());
//        Deque<Integer> deque = new ArrayDeque<>();
//        Stack<Integer> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        for (int i=0; i<num; i++) {
            int n = Integer.parseInt(bf.readLine());
            if (n == 0) {
                if (list.isEmpty()) {
                    bw.write(String.valueOf(0+"\n"));
                }
                else {
                    bw.write(String.valueOf(list.get(0)) + "\n");
                    list.remove(0);
                }
            }
            else {
                list.add(n);
                Collections.sort(list);
//                while (true) {
//                    if (deque.isEmpty()) {
//                        deque.addFirst(n);
//                        break;
//                    }
//                    else if (deque.peekFirst() < n) {
//                        stack.add(deque.pollFirst());
//                    }
//                    else {
//                        deque.addFirst(n);
//                        break;
//                    }
//                }
//                while (!stack.isEmpty()) {
//                    deque.addFirst(stack.pop());
//                }
            }
        }
        bw.close();
    }
}
