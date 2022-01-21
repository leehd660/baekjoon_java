package silver1;

import java.io.*;
import java.util.*;

public class S1_1697 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String NKstr = bf.readLine();
        StringTokenizer NKtoken = new StringTokenizer(NKstr);
        int N = Integer.parseInt(NKtoken.nextToken());
        int K = Integer.parseInt(NKtoken.nextToken());
        Deque<Integer> deque = new ArrayDeque<>();
        Set<Integer> set = new HashSet<>();
        deque.add(N);
        set.add(N);
        int num = 1;
        int time = 0;
        while (true) {
            if (set.contains(K)) {
                break;
            }
            else {
                int addNum = 0;
                for (int i=0; i<num; i++) {
                    if (!set.contains(deque.peekFirst()+1) && deque.peekFirst()+1<=100000) {
                        deque.addLast(deque.peekFirst() + 1);
                        set.add(deque.peekFirst() + 1);
                        addNum++;
                    }
                    if (!set.contains(deque.peekFirst()-1) && deque.peekFirst()-1>=0) {
                        deque.addLast(deque.peekFirst()-1);
                        set.add(deque.peekFirst()-1);
                        addNum++;
                    }
                    if (!set.contains(deque.peekFirst()*2) && deque.peekFirst()*2 <=100000) {
                        deque.addLast(deque.peekFirst()*2);
                        set.add(deque.peekFirst()*2);
                        addNum++;
                    }
                    deque.pollFirst();
                }
                num = addNum;
                time++;
            }
        }
        bw.write(String.valueOf(time));
        bw.close();
    }
}
