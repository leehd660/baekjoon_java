package silver2;

import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class S2_1260 {
    private static boolean[][] table;
    private static int N;
    private static int M;
    private static int V;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String NMVstr = bf.readLine();
        String[] NMVarr = NMVstr.split(" ");
        N = Integer.parseInt(NMVarr[0]);
        M = Integer.parseInt(NMVarr[1]);
        V = Integer.parseInt(NMVarr[2]);
        table = new boolean[N+1][N+1];
        for (int i=0; i<M; i++) {
            String numbers = bf.readLine();
            String[] numArr = numbers.split(" ");
            int num1 = Integer.parseInt(numArr[0]);
            int num2 = Integer.parseInt(numArr[1]);
            table[num1][num2] = true;
            table[num2][num1] = true;
        }
        //DFS출력
        boolean[] visited1 = new boolean[N+1];
        List<Integer> list = new ArrayList<>();
        list.add(V);
        visited1[V] = true;
        bw.write(String.valueOf(V) + " ");
        DFS(list, visited1);
        bw.write("\n");
        //BFS출력
        boolean[] visited2 = new boolean[N+1];
        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(V);
        visited2[V] = true;
        bw.write(String.valueOf(V) + " ");
        BFS(deque, visited2);


        bw.close();
    }

    static void DFS(List<Integer> list, boolean[] visited1) throws IOException {
        int num = list.get(list.size()-1);
        for (int i=1; i<=N; i++) {
            if (table[num][i] && !visited1[i]) {
                bw.write(String.valueOf(i)+" ");
                list.add(i);
                visited1[i] = true;
                DFS(list, visited1);
                list.remove(list.size()-1);
            }
        }
    }

    static void BFS(Deque<Integer> deque, boolean[] visited2) throws IOException {
        int num = deque.getFirst();
        for (int i=1; i<=N; i++) {
            if (table[num][i] && !visited2[i]) {
                deque.add(i);
                visited2[i] = true;
                bw.write(String.valueOf(i) + " ");
            }
        }
        deque.pollFirst();
        if (!deque.isEmpty()) {
            BFS(deque, visited2);
        }
    }
}
