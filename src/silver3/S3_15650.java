package silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class S3_15650 {
    private static int N;
    private static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String NMstr = bf.readLine();
        String[] NMarr = NMstr.split(" ");
        N = Integer.parseInt(NMarr[0]);
        M = Integer.parseInt(NMarr[1]);
        for (int i=1; i<=N; i++) {
            Deque<Integer> deque = new ArrayDeque<>();
            deque.add(i);
            DFS(deque);
        }
    }

    static void DFS(Deque<Integer> deque) {
        if (deque.size()==M) {
            for (int i=0; i<deque.size(); i++){
                int num = deque.pollFirst();
                System.out.print(num+" ");
                deque.addLast(num);
            }
            System.out.println();
        }
        else {
            for (int i=deque.peekLast()+1; i<=N; i++) {
                deque.addLast(i);
                DFS(deque);
                deque.removeLast();
            }
        }
    }
}
