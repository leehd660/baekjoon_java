package silver1;

import java.io.*;

public class S1_11057 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(bf.readLine());
        int[][] dp = new int[N][10];
        for (int i=0; i<10; i++) {
            dp[0][i] = 1;
        }
        for (int i=1; i<N; i++) {
            for (int j=0; j<10; j++) {
                for (int k=j; k>=0; k--) {
                    dp[i][j] += dp[i-1][k];
                }
                dp[i][j] %= 10007;
            }
        }
        int answer = 0;
        for (int i=0; i<10; i++) {
            answer += dp[N-1][i];
            answer %= 10007;
        }
        bw.write(String.valueOf(answer));
        bw.close();
    }
}