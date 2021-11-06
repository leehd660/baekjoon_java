package silver4;

import java.io.*;
import java.util.*;

public class S4_1021 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        Deque<Integer> deque1 = new ArrayDeque<>();
        Deque<Integer> deque2 = new ArrayDeque<>();
        for (int i=1; i<=N; i++) {
            deque1.addLast(i);
            deque2.addLast(i);
        }
        int answer = 0;
        for (int i=0; i<M; i++) {
            int a = scanner.nextInt();
            int countLeft = 0;
            int countRight = 0;
            if (deque1.getFirst() == a && deque2.getFirst() ==a) {
                deque1.removeFirst();
                deque2.removeFirst();
                continue;
            }
            else {
                while (true) {
                    countLeft++;
                    deque1.addFirst(deque1.pollLast());
                    if ((int) deque1.getFirst() == a) {
                        deque1.removeFirst();
                        break;
                    }
                }
                while (true) {
                    countRight++;
                    deque2.addLast(deque2.pollFirst());
                    if ((int) deque2.getFirst() == a) {
                        deque2.removeFirst();
                        break;
                    }
                }
            }
            answer += Math.min(countLeft,countRight);
        }
        System.out.println(answer);
    }

//    static int check(Deque deque, int a) {
//        int countLeft = 0;
//        int countRight = 0;
//        while(true) {
//            countLeft++;
//            deque.addFirst(deque.pollLast());
//            if ((int)deque.getFirst() == a) {
//                break;
//            }
//        }
//        while (true) {
//            countRight++;
//            deque.addLast(deque.pollFirst());
//            if ((int)deque.getFirst() == a) {
//                break;
//            }
//        }
//        int answer = Math.max(countLeft,countRight);
//        return answer;
//    }
}
