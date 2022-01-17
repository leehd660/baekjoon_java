package silver2;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class S2_11724 {
    private static boolean[][] connected;
    private static int N;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String NMstr = bf.readLine();
        StringTokenizer NMtoken = new StringTokenizer(NMstr);
        N = Integer.parseInt(NMtoken.nextToken());
        int M = Integer.parseInt(NMtoken.nextToken());
        connected = new boolean[N+1][N+1];
        for (int i=0; i<M; i++) {
            String line = bf.readLine();
            StringTokenizer lineSt = new StringTokenizer(line);
            int num1 = Integer.parseInt(lineSt.nextToken());
            int num2 = Integer.parseInt(lineSt.nextToken());
            connected[num1][num2] = true;
            connected[num2][num1] = true;
        }
        visited = new boolean[N+1];
        visited[0] = true;
        int count = 0;
        for (int i=1; i<N+1; i++) {
            if (!visited[i]) {
                visited[i] = true;
                count++;
                Deque<Integer> deque = new ArrayDeque<>();
                deque.add(i);
                DFS(deque);
            }
        }
        bw.write(String.valueOf(count));
        bw.close();
    }

    static void DFS (Deque<Integer> deque) {
        while(!deque.isEmpty()) {
            int num = deque.pollFirst();
            for (int i = 0; i < N + 1; i++) {
                if (connected[num][i] && !visited[i]) {
                    deque.add(i);
                    visited[i] = true;
                }
            }
        }
    }
}
