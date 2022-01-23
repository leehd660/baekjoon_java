package silver1;

import java.io.*;
import java.util.StringTokenizer;

public class S1_1932 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.valueOf(bf.readLine());
        int[][] tree = new int[n][n];
        for (int i=0; i<n; i++) {
            String leaf = bf.readLine();
            StringTokenizer leafToken = new StringTokenizer(leaf);
            for (int j=0; j<i+1; j++) {
                tree[i][j] = Integer.parseInt(leafToken.nextToken());
            }
        }
        for (int i=1; i<n; i++) {
            for (int j=0; j<i+1; j++) {
                try {
                    tree[i][j] += Math.max(tree[i-1][j-1], tree[i-1][j]);
                }
                catch (IndexOutOfBoundsException e) {
                    tree[i][j] += tree[i-1][j];
                }
            }
        }
        int answer = 0;
        for (int i=0; i<n; i++) {
            answer = Math.max(tree[n-1][i],answer);
        }
        bw.write(String.valueOf(answer));
        bw.close();
    }
}
