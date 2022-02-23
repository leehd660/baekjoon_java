package silver2;

import java.io.*;
import java.util.StringTokenizer;

public class S2_10971 {
    private static int N;
    private static int lowCost;
    private static int[][] table;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(bf.readLine());
        table = new int[N][N];
        lowCost = 0;
        for (int i=0; i<N; i++) {
            StringTokenizer token = new StringTokenizer(bf.readLine());
            for (int j=0; j<N; j++) {
                table[i][j] = Integer.parseInt(token.nextToken());
                lowCost += table[i][j];
            }
        }
        visited = new boolean[N];
        for (int i=0; i<N; i++) {
            visited[i] = true;
            DFS(i, i, 0);
            visited[i] = false;
        }
        bw.write(String.valueOf(lowCost));
        bw.close();
    }

    static void DFS (int first, int start, int cost) {
        boolean allCheck = true;
        for (int i=0; i<N; i++) {
            if (!visited[i]) {
                allCheck = false;
                break;
            }
        }
        if (allCheck) {
            if (table[start][first] != 0) {
                lowCost = Math.min(lowCost, cost + table[start][first]);
            }
        }
        else {
            for (int i=0; i<N; i++) {
                if (!visited[i] && table[start][i] != 0) {
                    visited[i] = true;
                    cost += table[start][i];
                    DFS(first, i, cost);
                    visited[i] = false;
                    cost -= table[start][i];
                }
            }
        }
    }
}
