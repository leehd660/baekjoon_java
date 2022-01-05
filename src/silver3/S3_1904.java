package silver3;

import java.io.*;

public class S3_1904 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = Integer.parseInt(bf.readLine());
        int[] dp = new int[num];
        if (num==1) {
            dp[0] = 1;
        }
        else if (num==2) {
            dp[0] = 1;
            dp[1] = 2;
        }
        else {
            dp[0] = 1;
            dp[1] = 2;
            for (int i=2; i<num; i++) {
                dp[i] = (dp[i-2] + dp[i-1]) % 15746;
            }
        }
        bw.write(String.valueOf(dp[num-1]));
        bw.close();
    }
}
