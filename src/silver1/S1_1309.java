package silver1;

import java.io.*;

public class S1_1309 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n= Integer.parseInt(bf.readLine());
        int[][] dp = new int[n][3];
        for(int i=0; i<3; i++) {
            dp[0][i] = 1;
        }
        for (int i=1; i<n; i++) {
            dp[i][0] = (dp[i-1][0]+dp[i-1][1]+dp[i-1][2])%9901;
            dp[i][1] = (dp[i-1][0]+dp[i-1][2])%9901;
            dp[i][2] = (dp[i-1][0]+dp[i-1][1])%9901;
        }
        bw.write(String.valueOf((dp[n-1][0]+dp[n-1][1]+dp[n-1][2])%9901));
        bw.close();
    }
}
