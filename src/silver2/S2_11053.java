package silver2;

import java.io.*;
import java.util.StringTokenizer;

public class S2_11053 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = Integer.parseInt(bf.readLine());
        String numStr = bf.readLine();
        StringTokenizer stringTokenizer = new StringTokenizer(numStr);
        int[] arr = new int[num];
        int[] dp = new int[num];
        for (int i=0; i<num; i++) {
            arr[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        dp[0] = 1;
        int maxAnswer = 1;
        for (int i=1; i<num; i++) {
            int maxDp = 0;
            for (int j=i-1; j>=0; j--) {
                if (arr[j] < arr[i]) {
                    maxDp = Math.max(maxDp, dp[j]);
                }
            }
            dp[i] = maxDp + 1;
            maxAnswer = Math.max(maxAnswer, dp[i]);
        }
        bw.write(String.valueOf(maxAnswer));
        bw.close();
    }
}
