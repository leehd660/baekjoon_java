package silver1;

import java.io.*;
import java.util.StringTokenizer;

public class S1_11051 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer token = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(token.nextToken());
        int K = Integer.parseInt(token.nextToken());
        int[][] arr = new int[N+1][N+1];
        arr[0][0] = 1;
        for (int i=1; i<=N; i++) {
            for (int j=0; j<=i; j++) {
                if (j==0 || j==i) {
                    arr[i][j] =1;
                }
                else {
                    arr[i][j] = (arr[i - 1][j - 1] + arr[i - 1][j]) % 10007;
                }
            }
        }
        bw.write(String.valueOf(arr[N][K]));
        bw.close();
    }
}
