package silver2;

import java.io.*;
import java.util.StringTokenizer;

public class S2_1912 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(bf.readLine());
        String str = bf.readLine();
        StringTokenizer st = new StringTokenizer(str);
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] dp = new int[N];
        dp[0] = arr[0];
        int max = arr[0];
        for (int i = 1; i < N; i++) {
            int containNum = dp[i-1] + arr[i];
            dp[i] = Math.max(containNum, arr[i]);
            max = Math.max(max, dp[i]);
        }
        bw.write(String.valueOf(max));
        bw.close();
    }
}

        //누적합 이용하기 - 시간초과 발생
//        int[] dp = new int[N];
//        dp[0] = Integer.parseInt(st.nextToken());
//        for (int i=1; i<N; i++) {
//            dp[i] = Integer.parseInt(st.nextToken()) + dp[i-1];
//        }
//        int max = dp[0];
//        for (int i=0; i<N-1; i++) {
//            for (int j=i+1; j<N; j++) {
//                max = Math.max(max, dp[j]-dp[i]);
//            }
//        }
//        bw.write(String.valueOf(max));
//        bw.close();

