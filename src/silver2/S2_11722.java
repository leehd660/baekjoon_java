package silver2;

import java.io.*;
import java.util.StringTokenizer;

public class S2_11722 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(bf.readLine());
        StringTokenizer numToken = new StringTokenizer(bf.readLine());
        int[] arr = new int[n];
        int[] dp = new int[n];
        int startNum = Integer.parseInt(numToken.nextToken());
        arr[0] = startNum;
        dp[0] = 1;
        int answer = 1;
        for (int i=1; i<n; i++) {
            int num = Integer.parseInt(numToken.nextToken());
            arr[i] = num;
            for (int j=i-1; j>=0; j--) {
                if (num<arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            if (dp[i]==0) {
                dp[i] = 1;
            }
            answer = Math.max(dp[i], answer);
        }
        bw.write(String.valueOf(answer));
        bw.close();
    }
}
