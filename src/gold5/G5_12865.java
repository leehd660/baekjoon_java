package gold5;

import java.io.*;
import java.util.StringTokenizer;

public class G5_12865 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer NKtoken = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(NKtoken.nextToken());
        int K = Integer.parseInt(NKtoken.nextToken());
        int[][] table = new int[N+1][2];
        for (int i=1; i<=N; i++) {
            StringTokenizer WVtoken = new StringTokenizer(bf.readLine());
            table[i][0] = Integer.parseInt(WVtoken.nextToken());
            table[i][1] = Integer.parseInt(WVtoken.nextToken());
        }
//        int answer = 0;
        int[][] dp = new int[N+1][K+1];
        for (int i=1; i<=N; i++) {
            for (int j=1; j<=K; j++) {
                if (j>=table[i][0]) {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-table[i][0]] + table[i][1]);
                }
                else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        bw.write(String.valueOf(dp[N][K]));
        bw.close();
    }
}
