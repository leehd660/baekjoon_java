package silver2;

import java.io.*;
import java.util.*;

public class S2_11725 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int nodeNum = Integer.parseInt(bf.readLine());
        List<Integer>[] connect = new List[nodeNum+1];
        boolean[] visited = new boolean[nodeNum+1];
        for (int i=1; i<=nodeNum; i++) {
            connect[i] = new ArrayList<>();
        }
        for (int i=0; i<nodeNum-1; i++) {
            StringTokenizer numToken = new StringTokenizer(bf.readLine());
            int num1 = Integer.parseInt(numToken.nextToken());
            int num2 = Integer.parseInt(numToken.nextToken());
            connect[num1].add(num2);
            connect[num2].add(num1);
        }
        Deque<Integer> deque = new ArrayDeque<>();
        int[] parents = new int[nodeNum+1];
        deque.add(1);
        visited[1] = true;
        while (!deque.isEmpty()) {
            int nowNode = deque.pollFirst();
            for (int i : connect[nowNode]) {
                if (!visited[i]) {
                    deque.add(i);
                    visited[i] = true;
                    parents[i] = nowNode;
                }
            }
        }
        for (int i=2; i<=nodeNum; i++) {
            bw.write(String.valueOf(parents[i])+"\n");
        }
        bw.close();
    }
}
