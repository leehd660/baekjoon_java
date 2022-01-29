package silver2;

import java.io.*;
import java.util.StringTokenizer;

public class S2_11055 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testNum = Integer.parseInt(bf.readLine());
        String test = bf.readLine();
        StringTokenizer testToken = new StringTokenizer(test);
        int[] arr = new int[testNum];
        int[] dp = new int[testNum];
        int first = Integer.parseInt(testToken.nextToken());
        arr[0] = first;
        dp[0] = first;
        int answer = first;
        for (int i=1;i<testNum; i++) {
            int num = Integer.parseInt(testToken.nextToken());
            arr[i] = num;
            for (int j=i-1; j>=0; j--) {
                if (arr[j]<num) {
                    dp[i] = Math.max(dp[i],dp[j]+num);
                }
                else {
                    if (j==0 && dp[i]==0) {
                        dp[i] = num;
                    }
                }
            }
            answer = Math.max(answer, dp[i]);
        }
        bw.write(String.valueOf(answer));
        bw.close();
    }
}
