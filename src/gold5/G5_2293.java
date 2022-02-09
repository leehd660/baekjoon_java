package gold5;

import java.io.*;
import java.util.StringTokenizer;

public class G5_2293 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer NKtoken = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(NKtoken.nextToken());
        int K = Integer.parseInt(NKtoken.nextToken());
        int[] dp = new int[K+1];
        for (int i=1; i<=N; i++) {
            int value = Integer.parseInt(bf.readLine());
            for (int j=1; j<=K; j++) {
                int compare = 0;
                try {
                    if (j%value==0) {
                        compare = 1;
                    }
                    dp[j] = (dp[j]+ Math.max(compare, dp[j-value]));
                }
                catch (IndexOutOfBoundsException e) {
                    dp[j] = (dp[j] + compare);
                }
            }
        }
        bw.write(String.valueOf(dp[K]));
        bw.close();

    }
}
